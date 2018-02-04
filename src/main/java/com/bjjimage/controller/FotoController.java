package com.bjjimage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bjjimage.domain.Foto;
import com.bjjimage.service.FotoService;

@RestController
@RequestMapping("/fotos")
public class FotoController {

	@Autowired
	FotoService fotoService;

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> listarAnuncios(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer pageSize,
			@RequestParam(value = "sort", defaultValue = "desc") String sort,
			@RequestParam(value = "objOrd", defaultValue = "createdAt") String objOrd) {

		try {

			Sort sort2 = null;
			String obj = null;
			if ("createdAt".equals(objOrd) || "lastModified".equals(objOrd)) {

				obj = objOrd;

			} else {

				obj = "createdAt";

			}

			if ("asc".equalsIgnoreCase(sort)) {
				sort2 = new Sort(new Sort.Order(Sort.Direction.ASC, obj));
			} else {
				sort2 = new Sort(new Sort.Order(Sort.Direction.DESC, obj));
			}

			PageRequest pageRequest = new PageRequest(page, pageSize, sort2);

			//Page<Foto> fotos = fotoService.listarTodas(pageRequest);
			
			List<Foto> fotos = fotoService.listarTodas();

			return new ResponseEntity<List<Foto>>(fotos, HttpStatus.OK);
			
//			if (fotos != null && fotos.getTotalElements() > 0) {
//
//				return new ResponseEntity<Page<Foto>>(fotos, HttpStatus.OK);
//
//			} else {
//
//				return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
//
//			}

		} catch (Exception e) {

			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

}
