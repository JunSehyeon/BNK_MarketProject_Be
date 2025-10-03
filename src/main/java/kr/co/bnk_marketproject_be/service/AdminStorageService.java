package kr.co.bnk_marketproject_be.service;

import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Slf4j
@Service
public class AdminStorageService {

    @Value("${app.upload.dir:upload}")
    private String uploadDir;

    @Value("${app.base-url:http://localhost:8080}")
    private String baseUrl;


    public String saveAndReturnUrl(MultipartFile file, String prefix) throws Exception {
        String ext = Optional.ofNullable(file.getOriginalFilename())
                .filter(f -> f.contains("."))
                .map(f -> f.substring(f.lastIndexOf(".")))
                .orElse(".png");

        String filename = prefix + "_" + System.currentTimeMillis() + ext;
        Path dest = Paths.get(uploadDir).toAbsolutePath().resolve(filename);
        Files.createDirectories(dest.getParent());
        file.transferTo(dest.toFile());

        String url = baseUrl + "/uploads/" + filename;
        log.info("Saved file: {} -> {}", dest, url);
        return url;
    }
}


