package com.alakey.serbiaguide.controller;

import com.alakey.serbiaguide.entity.TgChat;
import com.alakey.serbiaguide.service.TgChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/tgchats")
public class TgChatController {
    @Autowired
    private TgChatService tgChatService;

    @GetMapping
    public Iterable<TgChat> getAllTgChats() {
        return tgChatService.getAllTgChats();
    }

    @GetMapping("/{id}")
    public Optional<TgChat> getLocationById(@PathVariable Long id) {
        return tgChatService.getTgChatById(id);
    }

    @PostMapping
    public TgChat createTgChat(@RequestBody TgChat tgChat) {
        return tgChatService.saveTgChat(tgChat);
    }

    @DeleteMapping("/{id}")
    public void deleteTgChat(@PathVariable Long id) {
        tgChatService.deleteTgChat(id);
    }
}