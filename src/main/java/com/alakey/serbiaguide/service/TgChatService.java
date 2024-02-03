package com.alakey.serbiaguide.service;

import com.alakey.serbiaguide.entity.TgChat;
import com.alakey.serbiaguide.repository.TgChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TgChatService {
    @Autowired
    private TgChatRepository tgChatRepository;

    public Iterable<TgChat> getAllTgChats() {
        return tgChatRepository.findAll();
    }

    public Optional<TgChat> getTgChatById(Long id) {
        return tgChatRepository.findById(id);
    }

    public TgChat saveTgChat(TgChat tgChat) {
        return tgChatRepository.save(tgChat);
    }

    public void deleteTgChat(Long id) {
        tgChatRepository.deleteById(id);
    }
}