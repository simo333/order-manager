package com.simo333.spring.projects.ordersmanager.service;

import com.simo333.spring.projects.ordersmanager.model.ModelWorkingStats;
import com.simo333.spring.projects.ordersmanager.repository.ModelWorkingStatsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@Slf4j
public class ModelWorkingStatsService {
    private final ModelWorkingStatsRepository repository;

    @Autowired
    public ModelWorkingStatsService(ModelWorkingStatsRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public ModelWorkingStats save(ModelWorkingStats stats) {
        log.info("Saving model working stats: {}", stats);
        return repository.save(stats);
    }

    public List<ModelWorkingStats> findAll() {
        return repository.findAll();
    }

    public ModelWorkingStats getOne(Long id) {
        return repository.findById(id).orElseThrow(() -> {
           log.error("Model working stats with id '{}' not found", id);
           throw new ResourceNotFoundException("Model working stats not found. For id: " + id);
        });
    }

    public List<ModelWorkingStats> findAllByModelId(Long id) {
        return repository.findAllByModelId(id);
    }

    public List<ModelWorkingStats> findAllByJobPositionId(Long id) {
        return repository.findAllByJobPositionId(id);
    }

    public ModelWorkingStats findOneByModelIdAndJobPositionId(Long modelId, Long jobPositionId) {
        return repository.findModelStatsByModelIdAndJobPositionId(modelId, jobPositionId)
                .orElseThrow(() -> {
                    log.error("Model working stats with model id '{}' and job position id '{}' not found.",
                            modelId, jobPositionId);
                    throw new ResourceNotFoundException(
                            "Model statistics not found for given model and job positions ids");
                });
    }

    @Transactional
    public ModelWorkingStats update(ModelWorkingStats stats) {
        getOne(stats.getId());
        log.info("Updating model working stats: {}", stats);
        return repository.save(stats);
    }

    @Transactional
    public void deleteById(Long id) {
        log.info("Deleting model working stats with id '{}'", id);
        repository.deleteById(id);
    }

    @Transactional
    public void deleteOneByModelIdAndJobPositionId(Long modelId, Long jobPositionId) {
        log.info("Deleting model working stats with modelId '{}' and job position id '{}'", modelId, jobPositionId);
        repository.deleteOneByModelIdAndJobPositionId(modelId, jobPositionId);
    }

}
