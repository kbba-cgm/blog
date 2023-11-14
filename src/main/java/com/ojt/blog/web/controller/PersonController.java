package com.ojt.blog.web.controller;

import com.ojt.blog.bl.dto.PersonDTO;
import com.ojt.blog.bl.service.PersonService;
import com.ojt.blog.persistence.entity.Person;
import com.ojt.blog.web.form.PersonForm;
import jakarta.validation.Valid;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Iterator;

@Controller
@RequestMapping("/person")
public class PersonController {
    @Autowired
    @Qualifier("personService")
    PersonService personService;

    /**
     * <h2>Register Page</h2>
     * <p>Show form for person registration</p>
     *
     * @param model
     * @return String
     */
    @GetMapping("/create")
    public String registerPage(Model model) {
        model.addAttribute("person", new PersonForm());
        return "person/create";
    }

    /**
     * <h2>Register Person</h2>
     * <p>pass person data to service</p>
     *
     * @param model
     * @param person
     * @return String
     */
    @PostMapping("/create")
    public String registerPerson(Model model, @Valid @ModelAttribute("person") PersonForm person, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("person", person);
            return "person/create";
        }
        PersonDTO personDTO = new PersonDTO(person);
        personService.registerPerson(personDTO);
        // personDTO --> service
        return "redirect:/";
    }

    @GetMapping("/list")
    public String personList(Model model,
                             @RequestParam(defaultValue = "0") Integer page,
                             @RequestParam(defaultValue = "5") Integer size) {
//        List<PersonDTO> personDTOList = new ArrayList<>();
//        personDTOList.add(new PersonDTO("person one"));
//        personDTOList.add(new PersonDTO("person two"));
//        personDTOList.add(new PersonDTO("person three"));
//        personDTOList.add(new PersonDTO("person four"));
//        personDTOList.add(new PersonDTO("person five"));
//        model.addAttribute("persons", personDTOList);
        // get list >> service
        Pageable pageableDate = PageRequest.of(page, size);
        Page<Person> persons = personService.getPageablePersonList(pageableDate);
//        List<PersonDTO> persons = personService.getPersonList();
        model.addAttribute("pageNo", persons.getNumber());
        model.addAttribute("persons", persons);
        return "person/list";
    }

    @PostMapping("/excel-import")
    public String personListExcelExport(@RequestParam("personFile") MultipartFile file) throws IOException {
//        File file = new File("D:\\OJT_projects\\javaOJT-batch-10\\blog\\src\\main\\resources\\static\\files\\sample-data.xlsx");
//        FileInputStream fis = new FileInputStream(file);
        System.out.println("excel import *************");
        var workbook = new XSSFWorkbook(file.getInputStream());
//        var sh = workbook.createSheet();
//        var r = sh.createRow(0);
//        var c = r.createCell(0);
//        c.setCellValue(135);

        var sheet = workbook.getSheetAt(0);
        Iterator<Row> itr = sheet.iterator();
        while (itr.hasNext()){
            Row row = itr.next();
            Cell cell = row.getCell(0);
            String name = cell.getStringCellValue();

            PersonForm personForm = new PersonForm();
            personForm.setName(name);
            personService.registerPerson(new PersonDTO(personForm));
        }

        return "home/index";
    }
}
