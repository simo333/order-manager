package com.simo333.spring.projects.ordersmanager.service;

import com.simo333.spring.projects.ordersmanager.data.ModelStatsRepository;
import com.simo333.spring.projects.ordersmanager.exception.ApiRequestException;
import com.simo333.spring.projects.ordersmanager.model.ModelStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ModelStatsService {
    private final ModelStatsRepository repository;

    @Autowired
    public ModelStatsService(ModelStatsRepository repository) {
        this.repository = repository;
    }

    public ModelStats addModelStats(ModelStats modelStats) {
        return repository.save(modelStats);
    }

    public List<ModelStats> findAllModelStats() {
        return repository.findAll();
    }

    public List<ModelStats> findAllByModelId(Long id) {
        List<ModelStats> modelStatsList = repository.findAllByModelId(id);
        if(modelStatsList.isEmpty()) {
            throw new ApiRequestException("Model statistics not found for given model id.", HttpStatus.NOT_FOUND);
        }
        return repository.findAllByModelId(id);
    }

    public List<ModelStats> findAllByJobPositionId(Long id) {
        List<ModelStats> modelStatsList = repository.findAllByJobPositionId(id);
        if(modelStatsList.isEmpty()) {
            throw new ApiRequestException("Model statistics not found for given job position id.", HttpStatus.NOT_FOUND);
        }
        return repository.findAllByJobPositionId(id);
    }

    public ModelStats findOneByModelIdAndJobPositionId(Long modelId, Long jobPositionId) {
        repository.findModelStatsByModelIdAndJobPositionId(modelId, jobPositionId)
                .orElseThrow(() -> new ApiRequestException(
                        "Model statistics not found for given model and job positions ids", HttpStatus.NOT_FOUND));
        return repository.findModelStatsByModelIdAndJobPositionId(modelId, jobPositionId).orElseThrow();
    }

    @Transactional
    public ModelStats updateModelStats(ModelStats modelStats) {
        ModelStats modelStatsToEdit = findOneByModelIdAndJobPositionId(
                        modelStats.getModel().getId(), modelStats.getJobPosition().getId());
        modelStatsToEdit.setRate(modelStats.getRate());
        modelStatsToEdit.setTimeToComplete(modelStats.getTimeToComplete());
        return repository.save(modelStatsToEdit);
    }

    @Transactional
    public void deleteOneByModelIdAndJobPositionId(Long modelId, Long jobPositionId) {
        repository.deleteOneByModelIdAndJobPositionId(modelId, jobPositionId);
    }

}
