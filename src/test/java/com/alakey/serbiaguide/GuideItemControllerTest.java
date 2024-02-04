package com.alakey.serbiaguide;

import com.alakey.serbiaguide.controller.GuideItemController;
import com.alakey.serbiaguide.entity.GuideItem;
import com.alakey.serbiaguide.service.GuideItemService;
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

public class GuideItemControllerTest {

    private MockMvc mockMvc;

    @Mock
    private GuideItemService guideItemService;

    @InjectMocks
    private GuideItemController guideItemController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(guideItemController).build();
    }

    @Test
    void testGetAllGuideItems() throws Exception {
        when(guideItemService.getAllGuideItems()).thenReturn(Arrays.asList(new GuideItem(), new GuideItem()));

        mockMvc.perform(get("/guideitems"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(2));

        verify(guideItemService, times(1)).getAllGuideItems();
        verifyNoMoreInteractions(guideItemService);
    }

    @Test
    void testGetGuideItemById() throws Exception {
        long guideItemId = 1L;
        GuideItem guideItem = new GuideItem();
        when(guideItemService.getGuideItemById(guideItemId)).thenReturn(Optional.of(guideItem));

        mockMvc.perform(get("/guideitems/{id}", guideItemId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(guideItemId));

        verify(guideItemService, times(1)).getGuideItemById(guideItemId);
        verifyNoMoreInteractions(guideItemService);
    }

    @Test
    void testCreateGuideItem() throws Exception {
        GuideItem guideItem = new GuideItem();
        when(guideItemService.saveGuideItem(any())).thenReturn(guideItem);

        mockMvc.perform(post("/guideitems")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").exists());

        verify(guideItemService, times(1)).saveGuideItem(any());
        verifyNoMoreInteractions(guideItemService);
    }

    @Test
    void testUpdateGuideItem() throws Exception {
        long guideItemId = 1L;
        GuideItem guideItem = new GuideItem();
        when(guideItemService.saveGuideItem(any())).thenReturn(guideItem);

        mockMvc.perform(put("/guideitems/{id}", guideItemId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").exists());

        verify(guideItemService, times(1)).saveGuideItem(any());
        verifyNoMoreInteractions(guideItemService);
    }

    @Test
    void testDeleteGuideItem() throws Exception {
        long guideItemId = 1L;

        mockMvc.perform(delete("/guideitems/{id}", guideItemId))
                .andExpect(status().isOk());

        verify(guideItemService, times(1)).deleteGuideItem(guideItemId);
        verifyNoMoreInteractions(guideItemService);
    }
}
