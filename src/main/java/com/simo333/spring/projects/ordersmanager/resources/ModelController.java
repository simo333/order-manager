package com.simo333.spring.projects.ordersmanager.resources;

import com.simo333.spring.projects.ordersmanager.model.Model;
import com.simo333.spring.projects.ordersmanager.service.ModelService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    ResponseEntity<Model> findById(@PathVariable Long id) {
        Model actualModel = service.getOne(id);
        return new ResponseEntity<>(actualModel, HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<Model> add(@RequestBody @Valid  Model model) {
        Model newModel = service.save(model);
        return new ResponseEntity<>(newModel, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    ResponseEntity<Model> update(@PathVariable Long id, @RequestBody @Valid Model model) {
        model.setId(id);
        Model updated = service.update(model);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(@PathVariable Long id) {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
