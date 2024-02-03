package com.alakey.serbiaguide.controller;

import com.alakey.serbiaguide.entity.GuideItem;
import com.alakey.serbiaguide.service.GuideItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/guideitems")
public class GuideItemController {
    @Autowired
    private GuideItemService guideItemService;

    @GetMapping
    public Iterable<GuideItem> getAllGuideItems() {
        return guideItemService.getAllGuideItems();
    }

    @GetMapping("/{id}")
    public Optional<GuideItem> getGuideItemById(@PathVariable Long id) {
        return guideItemService.getGuideItemById(id);
    }

    @PostMapping
    public GuideItem createGuideItem(@RequestBody GuideItem guideItem) {
        return guideItemService.saveGuideItem(guideItem);
    }

    @PutMapping("/{id}")
    public GuideItem updateGuideItem(@PathVariable Long id, @RequestBody GuideItem guideItem) {
        // Предполагается, что сущность существует; вы можете добавить дополнительные проверки
        guideItem.setId(id);
        return guideItemService.saveGuideItem(guideItem);
    }

    @DeleteMapping("/{id}")
    public void deleteGuideItem(@PathVariable Long id) {
        guideItemService.deleteGuideItem(id);
    }
}