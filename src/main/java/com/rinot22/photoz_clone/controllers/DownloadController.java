package com.rinot22.photoz_clone.controllers;

import com.rinot22.photoz_clone.model.Photo;
import com.rinot22.photoz_clone.service.PhotozService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/photoz")
public class DownloadController {

    @Autowired
    private PhotozService photozService;

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> download(@PathVariable Integer id) {
        Photo photo = photozService.get(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        byte[]data = photo.getData();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf(photo.getContentType()));
        ContentDisposition build = ContentDisposition
                .builder("attachment")
                .filename(photo.getFileName())
                .build();
        headers.setContentDisposition(build);

        return new ResponseEntity<>(data, headers, HttpStatus.OK);
    }
}
