package it.corsospring.cert.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {

    @Autowired
    PersonRepository personRepository;

    @RequestMapping(value = "/hello", method = {RequestMethod.GET,RequestMethod.POST})
    public String hello() {
        return "Hello, world!";
    }

    @GetMapping("/getperson/{id}")
    public Person getPerson(@PathVariable Integer id, @RequestParam String test) {
        System.out.println("Il parametro test è: "+test);
        Person p = personRepository.getById(id);
        System.out.println(p);
        return p;
    }

    @GetMapping("/getpersons")
    public List<Person> getPersons() {
        return personRepository.findAll();
    }

    @GetMapping("/getbyemail")
    public List<Person> getByEmail(@RequestParam String email) {
        return personRepository.findByEmail(email);
    }

}
