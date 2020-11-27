package com.hospital.service.aws;

import java.io.File;
import java.net.URL;

public interface AmazonS3PacienteService {

    int createBucket();
    URL upload(File file, String string);
    void deleteFoto (String key);
}
