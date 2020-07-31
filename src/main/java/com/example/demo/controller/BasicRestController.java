package com.example.demo.controller;

import com.example.demo.model.CustomError;
import com.example.demo.model.ErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.UUID;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/microservice1/file")
public class BasicRestController {

  @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
  @Operation(
      summary = "Zip file to be uploaded",
      description = "")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "Upload succeeded",
            content = @Content(schema = @Schema(implementation = String.class))),
        @ApiResponse(
            responseCode = "400",
            description = "",
            content =
                @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ErrorResponse.class),
                    examples = {
                      @ExampleObject(
                          name = "ErrorOne",
                          summary = "Example 1",
                          description = "The server will not process request due to invalid file size",
                          value =
                              "{\"errors\":[{\"errorCode\": err_01\", \"field\": \"name\", \"message\":\"Invalid file size\".}]}"),
                      @ExampleObject(
                          name = "ErrorTwo",
                          summary = "Example 2",
                          description = "Malformed file",
                          value =
                              "{\"errors\":[{\"errorCode\": err_02\", \"field\": \"name\", \"message\":\"Corrupt file\".}]}"
                      )
                    }))
      })
  public ResponseEntity<String> CreateSD(
      @RequestParam("file") MultipartFile file, @RequestHeader(value = "filename", required = false) String filename) {

    return ResponseEntity.ok(UUID.randomUUID().toString());

  }

}
