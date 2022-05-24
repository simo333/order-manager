package com.simo333.spring.projects.ordersmanager.resources;

import com.simo333.spring.projects.ordersmanager.model.ModelStats;
import com.simo333.spring.projects.ordersmanager.service.ModelStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/model-stats")
public class ModelStatsController {

    private final ModelStatsService service;

    @Autowired
    public ModelStatsController(ModelStatsService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ModelStats>> findAllModelStats() {
        List<ModelStats> modelStatsList = service.findAllModelStats();
        return new ResponseEntity<>(modelStatsList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ModelStats> newModelStats(@RequestBody ModelStats modelStats) {
        ModelStats newModelStats = service.addModelStats(modelStats);
        return new ResponseEntity<>(newModelStats, HttpStatus.CREATED);
    }

    @GetMapping("/{modelId}/{jobPositionId}")
    public ResponseEntity<ModelStats> findOneByModelIdAndJobPositionId(@PathVariable("modelId") Long modelId,
                                                                       @PathVariable("jobPositionId") Long jobPositionId) {
        ModelStats modelStats = service.findOneByModelIdAndJobPositionId(modelId, jobPositionId);
        return new ResponseEntity<>(modelStats, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<ModelStats>> findAllByModelId(@PathVariable("id") Long id) {
        List<ModelStats> actualModelStats = service.findAllByModelId(id);
        return new ResponseEntity<>(actualModelStats, HttpStatus.OK);
    }

    @GetMapping("/jp/{id}")
    public ResponseEntity<List<ModelStats>> findAllByJobPositionId(@PathVariable("id") Long id) {
        List<ModelStats> actualModelStats = service.findAllByJobPositionId(id);
        return new ResponseEntity<>(actualModelStats, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ModelStats> updateModelStats(@RequestBody ModelStats modelStats) {
        ModelStats editedModelStats = service.updateModelStats(modelStats);
        return new ResponseEntity<>(editedModelStats, HttpStatus.OK);
    }

    @DeleteMapping("/{modelId}/{jobPositionId}")
    public ResponseEntity<?> deleteModelStats(@PathVariable("modelId") Long modelId,
                                 @PathVariable("jobPositionId") Long jobPositionId) {
        service.deleteOneByModelIdAndJobPositionId(modelId, jobPositionId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
