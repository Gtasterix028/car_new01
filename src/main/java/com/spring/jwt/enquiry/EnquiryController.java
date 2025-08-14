package com.GTasteriX.demo.Controller;

import com.GTasteriX.demo.DTO.EnquiryDTO;
import com.GTasteriX.demo.Entity.Enquiry;
import com.GTasteriX.demo.Service.EnquiryService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enquiry")
public class EnquiryController {

    @Autowired
    private  EnquiryService enquiryService;

    @PostMapping("/createEnquiry")
    public ResponseEntity createEnquiry(@RequestBody EnquiryDTO enquiryDTO){
        try {
            EnquiryDTO enquiryDTO1 = enquiryService.createEnquiry(enquiryDTO);
            return new ResponseEntity<>(enquiryDTO1, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Integer id) {
        try {
            Enquiry enquiry = enquiryService.getById(id);
            return new ResponseEntity<>(enquiry, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    // GET all
    @GetMapping
    public ResponseEntity<?> getAll() {
        try {
            List<Enquiry> products = enquiryService.getAll();
            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // UPDATE by ID
    @PutMapping("/{id}")
    public ResponseEntity<?> updateById(@PathVariable Integer id, @RequestBody EnquiryDTO enquiryDTO) {
        try {
            Enquiry updatedEnquiry = enquiryService.updateById(id, enquiryDTO);
            return new ResponseEntity<>(updatedEnquiry, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // DELETE by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id) {
        try {
            enquiryService.deleteById(id);
            return new ResponseEntity<>("Product deleted successfully with id: " + id, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


}
