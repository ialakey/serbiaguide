package com.alakey.serbiaguide;

import com.alakey.serbiaguide.controller.TgChatController;
import com.alakey.serbiaguide.entity.TgChat;
import com.alakey.serbiaguide.service.TgChatService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class TgChatControllerTest {

    private MockMvc mockMvc;

    @Mock
    private TgChatService tgChatService;

    @InjectMocks
    private TgChatController tgChatController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(tgChatController).build();
    }

    @Test
    void testGetAllTgChats() throws Exception {
        when(tgChatService.getAllTgChats()).thenReturn(Arrays.asList(new TgChat(), new TgChat()));

        mockMvc.perform(get("/tgchats"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(2));

        verify(tgChatService, times(1)).getAllTgChats();
        verifyNoMoreInteractions(tgChatService);
    }

    @Test
    void testGetLocationById() throws Exception {
        long chatId = 1L;
        TgChat tgChat = new TgChat();
        when(tgChatService.getTgChatById(chatId)).thenReturn(Optional.of(tgChat));

        mockMvc.perform(get("/tgchats/{id}", chatId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(chatId));

        verify(tgChatService, times(1)).getTgChatById(chatId);
        verifyNoMoreInteractions(tgChatService);
    }

    @Test
    void testCreateTgChat() throws Exception {
        TgChat tgChat = new TgChat();
        when(tgChatService.saveTgChat(any())).thenReturn(tgChat);

        mockMvc.perform(post("/tgchats")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").exists());

        verify(tgChatService, times(1)).saveTgChat(any());
        verifyNoMoreInteractions(tgChatService);
    }

    @Test
    void testDeleteTgChat() throws Exception {
        long chatId = 1L;

        mockMvc.perform(delete("/tgchats/{id}", chatId))
                .andExpect(status().isOk());

        verify(tgChatService, times(1)).deleteTgChat(chatId);
        verifyNoMoreInteractions(tgChatService);
    }
}