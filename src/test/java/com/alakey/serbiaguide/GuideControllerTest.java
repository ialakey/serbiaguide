package com.alakey.serbiaguide;

import com.alakey.serbiaguide.controller.GuideController;
import com.alakey.serbiaguide.entity.Guide;
import com.alakey.serbiaguide.service.GuideService;
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

public class GuideControllerTest {

    private MockMvc mockMvc;

    @Mock
    private GuideService guideService;

    @InjectMocks
    private GuideController guideController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(guideController).build();
    }

    @Test
    void testGetAllGuides() throws Exception {
        when(guideService.getAllGuides()).thenReturn(Arrays.asList(new Guide(), new Guide()));

        mockMvc.perform(get("/guides"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(2));

        verify(guideService, times(1)).getAllGuides();
        verifyNoMoreInteractions(guideService);
    }

    @Test
    void testGetGuideById() throws Exception {
        long guideId = 1L;
        Guide guide = new Guide();
        when(guideService.getGuideById(guideId)).thenReturn(Optional.of(guide));

        mockMvc.perform(get("/guides/{id}", guideId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(guideId));

        verify(guideService, times(1)).getGuideById(guideId);
        verifyNoMoreInteractions(guideService);
    }

    @Test
    void testCreateGuide() throws Exception {
        Guide guide = new Guide();
        when(guideService.saveGuide(any())).thenReturn(guide);

        mockMvc.perform(post("/guides")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").exists());

        verify(guideService, times(1)).saveGuide(any());
        verifyNoMoreInteractions(guideService);
    }

    @Test
    void testUpdateGuide() throws Exception {
        long guideId = 1L;
        Guide guide = new Guide();
        when(guideService.saveGuide(any())).thenReturn(guide);

        mockMvc.perform(put("/guides/{id}", guideId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").exists());

        verify(guideService, times(1)).saveGuide(any());
        verifyNoMoreInteractions(guideService);
    }

    @Test
    void testDeleteGuide() throws Exception {
        long guideId = 1L;

        mockMvc.perform(delete("/guides/{id}", guideId))
                .andExpect(status().isNoContent());

        verify(guideService, times(1)).deleteGuide(guideId);
        verifyNoMoreInteractions(guideService);
    }
}
