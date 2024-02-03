package com.alakey.serbiaguide.controller;

import com.alakey.serbiaguide.entity.Guide;
import com.alakey.serbiaguide.service.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/guides")
public class GuideController {
    @Autowired
    private GuideService guideService;

    @GetMapping
    public Iterable<Guide> getAllGuides() {
        return guideService.getAllGuides();
    }

    @GetMapping("/{id}")
    public Optional<Guide> getGuideById(@PathVariable Long id) {
        return guideService.getGuideById(id);
    }

    @PostMapping
    public Guide createGuide(@RequestBody Guide guide) {
        return guideService.saveGuide(guide);
    }

    @PutMapping("/{id}")
    public Guide updateGuide(@PathVariable Long id, @RequestBody Guide guide) {
        guide.setId(id);
        return guideService.saveGuide(guide);
    }

    @DeleteMapping("/{id}")
    public void deleteGuide(@PathVariable Long id) {
        guideService.deleteGuide(id);
    }
}