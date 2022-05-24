package com.simo333.spring.projects.ordersmanager.resources;

import com.simo333.spring.projects.ordersmanager.model.Model;
import com.simo333.spring.projects.ordersmanager.service.ModelService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/models")
public class ModelController {

    private final ModelService service;

    public ModelController(ModelService service) {
        this.service = service;
    }

    @GetMapping
    ResponseEntity<Page<Model>> findInPages(Pageable page) {
        Page<Model> models = service.findAllModelsInPages(page);
        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<Model> findById(@PathVariable("id") Long id) {
        Model actualModel = service.findModelById(id);
        return new ResponseEntity<>(actualModel, HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<Model> add(@RequestBody Model model) {
        Model newModel = service.addModel(model);
        return new ResponseEntity<>(newModel, HttpStatus.CREATED);
    }

    @PutMapping
    ResponseEntity<?> update(@RequestBody Model model) {
        Model actualModel = service.updateModel(model);
        return new ResponseEntity<>(actualModel, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.deleteModel(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
