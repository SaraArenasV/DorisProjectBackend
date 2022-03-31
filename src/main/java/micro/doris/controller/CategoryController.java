package micro.doris.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import micro.doris.entity.Category;
import micro.doris.viewmodel.CategoryRequest;
import micro.doris.services.CategoryServices;
import micro.doris.to.Convert;

@Validated
@Controller
@RequestMapping("/api")

public class CategoryController {

	@Autowired
	CategoryServices callService;

	// Find By ID
	@GetMapping("/getCategoryByIdAndName/")
	public ResponseEntity<Category> findByNameIdJpa(@RequestBody CategoryRequest nameId) {
		return new ResponseEntity<>(callService.getRecordByNameId(nameId), HttpStatus.OK);
	}

	// Delete By Id
	@DeleteMapping("/deleteCategoryByIdJpa")
	public ResponseEntity<Convert> deleteJpa(@RequestBody CategoryRequest nameId) {
		return new ResponseEntity<>(callService.deleteRecordJpa(nameId), HttpStatus.OK);
	}
    // save
    @PostMapping ("/category")
    public ResponseEntity<Category> save(@RequestBody Category request) {
        return new ResponseEntity<>(callService.save(request), HttpStatus.OK);
    }

}
