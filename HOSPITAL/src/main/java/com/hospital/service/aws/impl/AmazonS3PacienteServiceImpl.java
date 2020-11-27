package com.hospital.service.aws.impl;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.CreateBucketRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.hospital.service.aws.AmazonS3PacienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.net.URL;

@Service
@Slf4j
public class AmazonS3PacienteServiceImpl implements AmazonS3PacienteService {


    String bucketName="isil-dsc-grupo5";
    private AmazonS3 s3Foto;

    public AmazonS3PacienteServiceImpl(AmazonS3 s3Foto){
        this.s3Foto =s3Foto;
    }


    @Override
    public int createBucket(){
        int reponse;

        try{
            if(!s3Foto.doesBucketExistV2(bucketName)){
                CreateBucketRequest request= new CreateBucketRequest(bucketName)
                        .withCannedAcl(CannedAccessControlList.BucketOwnerFullControl);
                s3Foto.createBucket(request);
                reponse =0;
            }else {
                reponse =1;
            }
        } catch (Exception e){
            log.error("Error creating bucket:{}", e.getMessage());
            reponse =1;
        }
        return reponse;
    }

    @Override
    public URL upload(File file, String filename){
        URL response =null;
        log.info("Inside upload method");

        try{
            log.info("Checking if object exists");
            if(!s3Foto.doesObjectExist(bucketName, filename)){
                log.info("Making request");
                PutObjectRequest request =new PutObjectRequest(bucketName,filename,file)
                        .withCannedAcl(CannedAccessControlList.PublicRead);
                log.info("sending request");
                s3Foto.putObject(request);
                log.info("getting URL");
                response =s3Foto.getUrl(bucketName, filename);
                file.delete();

            }
        }catch (Exception e){
            log.error("Error uploading file: {}", e.getMessage());
        }
        return response;
    }

    @Override
    public void deleteFoto(String key){
        s3Foto.deleteObject(bucketName, key);
    }


}
