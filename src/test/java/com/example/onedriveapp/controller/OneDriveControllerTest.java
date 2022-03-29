package com.example.onedriveapp.controller;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class OneDriveControllerTest {

    private final String ONE_DRIVE_CONTROLLER_URL = "/api/one-drive/file";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private OneDriveController oneDriveController;

    @Test
    @DisplayName("Zwrócenie katalogu OneDrive")
    public void getOneDriveFiles_shouldReturnFile_whenFillParam() throws Exception {
        //given
        //when
        //then
        mockMvc.perform(get(ONE_DRIVE_CONTROLLER_URL)
                        .queryParam("name", "example")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());
    }
}
