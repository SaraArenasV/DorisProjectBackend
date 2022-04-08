package micro.doris.controller;

import micro.doris.entity.Category;
import micro.doris.services.ICategoryService;
import micro.doris.viewmodel.CategoryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import micro.doris.to.Convert;

import java.util.List;

@Validated
@Controller

@RequestMapping("/api")

public class CategoryController {

	@Autowired
	ICategoryService callService;

	// Find By ID
	@GetMapping("/getCategoryByIdAndName")
	public ResponseEntity<?> findByNameId(@RequestBody CategoryRequest nameId) {

		Category category = callService.getRecordByNameId(nameId);
		if (category != null)
			return new ResponseEntity<>(category, HttpStatus.OK);
		else
			return new ResponseEntity<>("Category does not exist", HttpStatus.OK);
	}

	// Delete By Id
	@DeleteMapping("/deleteCategoryByIdJpa")
	public ResponseEntity<Convert> delete(@RequestBody CategoryRequest nameId) {
		return new ResponseEntity<>(callService.deleteRecordJpa(nameId), HttpStatus.OK);
	}

	// save
	@PostMapping("/category")
	public ResponseEntity<?> save(@RequestBody Category request) {
    Category category = callService.getRecordByName(request.getName()) ;
		if (category != null) {
			return new ResponseEntity<>("Category name is exist", HttpStatus.NOT_FOUND.OK);
		} else{
			return new ResponseEntity<>(callService.save(request), HttpStatus.OK);
		}

	}

	@GetMapping("/getCategoryList")
	ResponseEntity<List<Category>> getListCategory()  {
		return new ResponseEntity<>(callService.findAll(), HttpStatus.OK );
	}
}
