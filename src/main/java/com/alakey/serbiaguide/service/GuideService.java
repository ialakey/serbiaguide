package com.alakey.serbiaguide.service;

import com.alakey.serbiaguide.entity.Guide;
import com.alakey.serbiaguide.repository.GuideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GuideService {
    @Autowired
    private GuideRepository guideRepository;

    public Iterable<Guide> getAllGuides() {
        return guideRepository.findAll();
    }

    public Optional<Guide> getGuideById(Long id) {
        return guideRepository.findById(id);
    }

    public Guide saveGuide(Guide guide) {
        return guideRepository.save(guide);
    }

    public void deleteGuide(Long id) {
        guideRepository.deleteById(id);
    }
}