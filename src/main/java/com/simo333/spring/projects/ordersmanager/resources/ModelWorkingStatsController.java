package com.simo333.spring.projects.ordersmanager.resources;

import com.simo333.spring.projects.ordersmanager.model.ModelWorkingStats;
import com.simo333.spring.projects.ordersmanager.service.ModelWorkingStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/model-stats")
public class ModelWorkingStatsController {

    private final ModelWorkingStatsService service;

    @Autowired
    public ModelWorkingStatsController(ModelWorkingStatsService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ModelWorkingStats>> findAll() {
        List<ModelWorkingStats> modelWorkingStatsList = service.findAll();
        return new ResponseEntity<>(modelWorkingStatsList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ModelWorkingStats> add(@RequestBody @Valid ModelWorkingStats stats) {
        ModelWorkingStats newModelWorkingStats = service.save(stats);
        return new ResponseEntity<>(newModelWorkingStats, HttpStatus.CREATED);
    }

    @GetMapping("/model/{modelId}/job-position/{jobPositionId}")
    public ResponseEntity<ModelWorkingStats> findByModelIdAndJobPositionId(
            @PathVariable("modelId") Long modelId, @PathVariable("jobPositionId") Long jobPositionId) {

        ModelWorkingStats stats = service.findOneByModelIdAndJobPositionId(modelId, jobPositionId);
        return new ResponseEntity<>(stats, HttpStatus.OK);
    }

    @GetMapping("/model/{id}")
    public ResponseEntity<List<ModelWorkingStats>> findAllByModelId(@PathVariable("id") Long id) {
        List<ModelWorkingStats> actualModelStats = service.findAllByModelId(id);
        return new ResponseEntity<>(actualModelStats, HttpStatus.OK);
    }

    @GetMapping("/job-position/{id}")
    public ResponseEntity<List<ModelWorkingStats>> findAllByJobPositionId(@PathVariable("id") Long id) {
        List<ModelWorkingStats> actualModelStats = service.findAllByJobPositionId(id);
        return new ResponseEntity<>(actualModelStats, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModelWorkingStats> update(@PathVariable Long id, @RequestBody @Valid ModelWorkingStats stats) {
        stats.setId(id);
        ModelWorkingStats updated = service.update(stats);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{modelId}/{jobPositionId}")
    public ResponseEntity<?> delete(@PathVariable("modelId") Long modelId,
                                    @PathVariable("jobPositionId") Long jobPositionId) {
        service.deleteOneByModelIdAndJobPositionId(modelId, jobPositionId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
