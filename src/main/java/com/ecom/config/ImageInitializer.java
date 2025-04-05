package com.ecom.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ecom.util.ImageUtil;

@Component
public class ImageInitializer implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        // Setup all images using the default placeholder
        ImageUtil.setupDefaultImage();
    }
} 