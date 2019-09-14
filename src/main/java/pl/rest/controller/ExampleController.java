package pl.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.rest.entity.Example;
import pl.rest.service.ExampleService;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ExampleController {
    @Autowired
    ExampleService exampleService;

    @RequestMapping("/hello")
    public String hello(){
        return "{hello: World}";
    }

    @GetMapping("")
    public List<Example> listExample() {
        return exampleService.getList();
    }

    @PostMapping("")
    public Example addExample(@RequestBody Example example) {
        exampleService.save(example);
        return example;
    }

    @DeleteMapping("/{id}")
    public void remExample(@PathVariable long id) {
        exampleService.deleteById(id);
    }

    @RequestMapping("/{id}")
    public Example getExample(@PathVariable long id) {
        return exampleService.getById(id);
    }

    @PutMapping("/{id}")
    public void updExample(@RequestBody Example example, @PathVariable long id) {
        exampleService.update(example);
    }
}
