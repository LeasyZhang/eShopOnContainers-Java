package com.eshop.api.catalog.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.InputStream;

@Controller
public class PicController {

    @GetMapping(value = "api/v1/catalog/items/{catalogItemId}/pic", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] getImage(@PathVariable("catalogItemId") Long catalogItemId) throws IOException {
        if (catalogItemId <= 0) {
            throw new IllegalArgumentException("Bad catalog item id " + catalogItemId);
        }

        final InputStream in = getClass().getResourceAsStream("/com/eshop/api/catalog/controller/pic/" + catalogItemId + ".jpg");
        return IOUtils.toByteArray(in);
    }
}
