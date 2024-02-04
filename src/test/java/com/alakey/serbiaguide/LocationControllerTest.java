package com.alakey.serbiaguide;

import com.alakey.serbiaguide.controller.LocationController;
import com.alakey.serbiaguide.entity.Location;
import com.alakey.serbiaguide.service.LocationService;
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

public class LocationControllerTest {

    private MockMvc mockMvc;

    @Mock
    private LocationService locationService;

    @InjectMocks
    private LocationController locationController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(locationController).build();
    }

    @Test
    void testGetAllLocations() throws Exception {
        when(locationService.getAllLocations()).thenReturn(Arrays.asList(new Location(), new Location()));

        mockMvc.perform(get("/locations"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(2));

        verify(locationService, times(1)).getAllLocations();
        verifyNoMoreInteractions(locationService);
    }

    @Test
    void testGetLocationById() throws Exception {
        long locationId = 1L;
        Location location = new Location();
        when(locationService.getLocationById(locationId)).thenReturn(Optional.of(location));

        mockMvc.perform(get("/locations/{id}", locationId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(locationId));

        verify(locationService, times(1)).getLocationById(locationId);
        verifyNoMoreInteractions(locationService);
    }

    @Test
    void testCreateLocation() throws Exception {
        Location location = new Location();
        when(locationService.saveLocation(any())).thenReturn(location);

        mockMvc.perform(post("/locations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").exists());

        verify(locationService, times(1)).saveLocation(any());
        verifyNoMoreInteractions(locationService);
    }

    @Test
    void testUpdateLocation() throws Exception {
        long locationId = 1L;
        Location location = new Location();
        when(locationService.saveLocation(any())).thenReturn(location);

        mockMvc.perform(put("/locations/{id}", locationId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").exists());

        verify(locationService, times(1)).saveLocation(any());
        verifyNoMoreInteractions(locationService);
    }

    @Test
    void testDeleteLocation() throws Exception {
        long locationId = 1L;

        mockMvc.perform(delete("/locations/{id}", locationId))
                .andExpect(status().isOk());

        verify(locationService, times(1)).deleteLocation(locationId);
        verifyNoMoreInteractions(locationService);
    }
}