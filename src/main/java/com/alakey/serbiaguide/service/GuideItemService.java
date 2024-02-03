package com.alakey.serbiaguide.service;

import com.alakey.serbiaguide.entity.GuideItem;
import com.alakey.serbiaguide.repository.GuideItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GuideItemService {
    @Autowired
    private GuideItemRepository guideItemRepository;

    public Iterable<GuideItem> getAllGuideItems() {
        return guideItemRepository.findAll();
    }

    public Optional<GuideItem> getGuideItemById(Long id) {
        return guideItemRepository.findById(id);
    }

    public GuideItem saveGuideItem(GuideItem guideItem) {
        return guideItemRepository.save(guideItem);
    }

    public void deleteGuideItem(Long id) {
        guideItemRepository.deleteById(id);
    }
}
