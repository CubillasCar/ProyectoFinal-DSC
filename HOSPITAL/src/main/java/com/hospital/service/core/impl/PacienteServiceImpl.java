package com.hospital.service.core.impl;


import com.hospital.dto.PacienteDto;
import com.hospital.model.Paciente;
import com.hospital.repository.IPacienteRepo;
import com.hospital.service.aws.AmazonS3PacienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;


@Service
@Slf4j
public class PacienteServiceImpl {


	private IPacienteRepo iPacienteRepo;
	private AmazonS3PacienteService s3PacienteService;

	@Autowired
	public PacienteServiceImpl(IPacienteRepo iPacienteRepo, AmazonS3PacienteService s3PacienteService) {
		this.iPacienteRepo = iPacienteRepo;
		this.s3PacienteService = s3PacienteService;
	}
public void createPaciente(PacienteDto pacienteDto, MultipartFile image) throws Exception{
		String nombres=pacienteDto.getNombres();
		String apellidos=pacienteDto.getApellidos();
		String dni=pacienteDto.getDni();
		String direccion=pacienteDto.getDireccion();
		String telefono=pacienteDto.getTelefono();
		String email=pacienteDto.getEmail();

		String key=image.getOriginalFilename();
		String imgUrl=s3PacienteService.upload(convert(image), image.getOriginalFilename()).toString();
		log.info("url: " + imgUrl);
		Paciente paciente = new Paciente(
				nombres
				, apellidos
				, dni
				, direccion
				, telefono
				, email
				, imgUrl
				, key);
	iPacienteRepo.save(paciente);
}

	public List<Paciente> findAll(){
		return iPacienteRepo.findAll();
	}

	public void deleteById(Integer id){
		Paciente paciente=iPacienteRepo.findById(id).get();
		iPacienteRepo.deleteById(id);
		s3PacienteService.deleteFoto(paciente.getKey());

	}


	public Paciente findById(Integer id) {
		return iPacienteRepo.findById(id).orElse(null);
	}



	public static File convert(MultipartFile file) throws IOException {
		File convFile = new File(file.getOriginalFilename());
		convFile.createNewFile();
		FileOutputStream fos = new FileOutputStream(convFile);
		fos.write(file.getBytes());
		fos.close();
		return convFile;
	}



}
