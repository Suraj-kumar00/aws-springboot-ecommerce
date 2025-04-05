package com.ecom.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Base64;

import org.springframework.core.io.ClassPathResource;

public class ImageUtil {
    
    private static final String DEFAULT_IMAGE = "/9j/4AAQSkZJRgABAQEASABIAAD/4QAiRXhpZgAATU0AKgAAAAgAAQESAAMAAAABAAEAAAAAAAD/2wBDAAIBAQIBAQICAgICAgICAwUDAwMDAwYEBAMFBwYHBwcGBwcICQsJCAgKCAcHCg0KCgsMDAwMBwkODw0MDgsMDAz/2wBDAQICAgMDAwYDAwYMCAcIDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAz/wAARCABkAGQDASIAAhEBAxEB/8QAHwAAAQUBAQEBAQEAAAAAAAAAAAECAwQFBgcICQoL/8QAtRAAAgEDAwIEAwUEBAQAAQJ3AAECAxEEBSExBhJBUWFxBhMigQcykaGxFELB0fAVIzNS4RZicoKSorLxJDRDU2Nzg5Oj0kVERkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqCg4SFhoeIiYqSk5SVlpeYmZqio6Slpqeoqaqys7S1tre4ubrCw8TFxsfIycrS09TV1tfY2dri4+Tl5ufo6ery8/T19vf4+fr/xAAfAQADAQEBAQEBAQEBAAAAAAAAAQIDBAUGBwgJCgv/xAC1EQACAQIDAQcDBAcEAAABAncAAQIDEQQFEiExQVEGE2FxIjKBFEKRobEHIzNSwfAVYnLRFiRDU4KSorLhJTRERUZHSElKU1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6goOEhYaHiImKkpOUlZaXmJmaoqOkpaanqKmqsrO0tba3uLm6wsPExcbHyMnK0tPU1dbX2Nna4uPk5ebn6Onq8vP09fb3+Pn6/9oADAMBAAIRAxEAPwD9/KKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooA//Z";

    public static void setupDefaultImage() {
        try {
            File saveFile = new ClassPathResource("static/img").getFile();
            Path productImgDir = Paths.get(saveFile.getAbsolutePath() + File.separator + "product_img");
            Path categoryImgDir = Paths.get(saveFile.getAbsolutePath() + File.separator + "category_img");
            
            // Create directories if they don't exist
            if (!Files.exists(productImgDir)) {
                Files.createDirectories(productImgDir);
            }
            if (!Files.exists(categoryImgDir)) {
                Files.createDirectories(categoryImgDir);
            }

            // Create default image
            byte[] imageBytes = Base64.getDecoder().decode(DEFAULT_IMAGE);
            
            // Save default image for products
            Path defaultProductImage = productImgDir.resolve("default.jpg");
            Files.write(defaultProductImage, imageBytes);
            
            // Convert any existing .jfif files to .jpg
            convertJfifToJpg(productImgDir);
            convertJfifToJpg(categoryImgDir);
            
            // Copy default image for all product images
            String[] productImages = {
                "blue-shirt.jpg", "canvas.jpg", "cross.jpg", "default.jpg",
                "fridge.jpg", "grinder.jpg", "hp-laptop.jpg", "iphone-14.jpg",
                "laptop.jpg", "mobile.jpg", "monitor.jpg", "pant.jpg"
            };
            
            for (String image : productImages) {
                if (!Files.exists(productImgDir.resolve(image))) {
                    Files.copy(defaultProductImage, productImgDir.resolve(image), StandardCopyOption.REPLACE_EXISTING);
                }
            }
            
            // Save default image for categories
            String[] categoryImages = {
                "appli.jpg", "beauty.jpg", "blue-shirt.jpg", "book.jpg",
                "canvas.jpg", "groccery.jpg", "laptop.jpg", "mobile.jpg",
                "monitor.jpg", "pant.jpg"
            };
            
            for (String image : categoryImages) {
                if (!Files.exists(categoryImgDir.resolve(image))) {
                    Files.copy(defaultProductImage, categoryImgDir.resolve(image), StandardCopyOption.REPLACE_EXISTING);
                }
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void convertJfifToJpg(Path directory) {
        try {
            Files.list(directory)
                .filter(path -> path.toString().toLowerCase().endsWith(".jfif"))
                .forEach(jfifPath -> {
                    try {
                        String fileName = jfifPath.getFileName().toString();
                        String newFileName = fileName.substring(0, fileName.lastIndexOf(".")) + ".jpg";
                        Path jpgPath = directory.resolve(newFileName);
                        
                        // Copy the file with new extension
                        Files.copy(jfifPath, jpgPath, StandardCopyOption.REPLACE_EXISTING);
                        // Delete the old .jfif file
                        Files.deleteIfExists(jfifPath);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
} 