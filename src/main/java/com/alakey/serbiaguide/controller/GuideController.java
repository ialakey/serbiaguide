package com.alakey.serbiaguide.controller;

import com.alakey.serbiaguide.entity.Guide;
import com.alakey.serbiaguide.service.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/guides")
public class GuideController {

    @Autowired
    private GuideService guideService;

    @GetMapping
    public ResponseEntity<Iterable<Guide>> getAllGuides() {
        try {
            Iterable<Guide> guides = guideService.getAllGuides();
            return ResponseEntity.ok(guides);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Guide> getGuideById(@PathVariable Long id) {
        try {
            Optional<Guide> guide = guideService.getGuideById(id);
            return guide.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<Guide> createGuide(@RequestBody Guide guide) {
        try {
            if (guide.getItems() != null) {
                guide.getItems().forEach(guideItem -> guideItem.setGuide(guide));
            }
            Guide savedGuide = guideService.saveGuide(guide);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedGuide);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Guide> updateGuide(@PathVariable Long id, @RequestBody Guide guide) {
        try {
            if (guide.getItems() != null) {
                guide.getItems().forEach(guideItem -> guideItem.setGuide(guide));
            }
            guide.setId(id);
            Guide updatedGuide = guideService.saveGuide(guide);
            return ResponseEntity.ok(updatedGuide);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGuide(@PathVariable Long id) {
        try {
            guideService.deleteGuide(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}