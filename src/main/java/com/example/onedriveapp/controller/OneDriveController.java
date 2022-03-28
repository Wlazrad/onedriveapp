package com.example.onedriveapp.controller;

import com.example.onedriveapp.service.OneDriveService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Pobieranie plików z OneDrive")
@RestController
@RequestMapping(value = "/internal/api/v1/dfg/eti/")
@RequiredArgsConstructor
public class OneDriveController {

    private final OneDriveService oneDriveService;

    @ApiOperation(
            value = "Pobranie pliku po nazwie"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Plik pobrany"),
            @ApiResponse(code = 400, message = "Nieprawidłowe zapytanie"),
            @ApiResponse(code = 401, message = "Błąd autoryzacji"),
            @ApiResponse(code = 404, message = "Nie znaleziono pliku podanym numerze")
    })
    @GetMapping(value = "/file")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public @ResponseBody
    byte[] getOneDriveFiles(@ApiParam(value = "Nazwa pliku", example = "name") @RequestParam String name) {
        return oneDriveService.getOneDriveFile(name);
    }
}
