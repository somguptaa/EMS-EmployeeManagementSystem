package com.som.ems.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.som.ems.dto.ResponseMessageDto;
import com.som.ems.entity.Manager;
import com.som.ems.service.ManagerService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "EmployeeController", description = "Employee CRUD Operations")
@RestController
@RequestMapping("/api/managers")
public class ManagerController {

    private static final Logger logger = LoggerFactory.getLogger(ManagerController.class);

    @Autowired
    private ManagerService managerService;

    // CREATE 
    @Operation(summary = "Create New Manager")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Manager Created Successfully"),
            @ApiResponse(responseCode = "400", description = "Manager Creation Failed")
    })
    @PostMapping
    public ResponseEntity<ResponseMessageDto> createNewManager(@RequestBody Manager manager) {

        logger.info("START: Create Manager Request Received: {}", manager);

        Manager saved = managerService.create(manager);

        logger.info("SUCCESS: Manager Created with ID: {}", saved.getId());

        ResponseMessageDto response = new ResponseMessageDto(
                201,
                "SUCCESS",
                "Manager created successfully",
                saved
        );

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // GET ALL 
    @Operation(summary = "Get All Managers")
    @GetMapping
    public ResponseEntity<ResponseMessageDto> getAllManagers() {

        logger.info("START: Fetching All Managers");

        List<Manager> managers = managerService.getAll();

        logger.info("SUCCESS: {} Managers Retrieved", managers.size());

        ResponseMessageDto response = new ResponseMessageDto(
                200,
                "Managers fetched successfully",
                managers
        );

        return ResponseEntity.ok(response);
    }

    // GET BY ID 
    @Operation(summary = "Get Manager By ID")
    @GetMapping("/{id}")
    public ResponseEntity<ResponseMessageDto> getManagerById(@PathVariable Long id) {

        logger.info("START: Fetching Manager with ID: {}", id);

        Manager manager = managerService.getById(id);

        if (manager == null) {
            logger.error("ERROR: Manager Not Found with ID: {}", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ResponseMessageDto(404, "Employee not found"));
        }

        logger.info("SUCCESS: Manager Found with ID: {}", id);

        ResponseMessageDto response = new ResponseMessageDto(
                200,
                "SUCCESS",
                "Manager fetched successfully",
                manager
        );

        return ResponseEntity.ok(response);
    }

    // UPDATE
    @Operation(summary = "Update Manager")
    @PutMapping("/{id}")
    public ResponseEntity<ResponseMessageDto> updateManager(@PathVariable Long id, @RequestBody Manager manager) {

        logger.info("START: Updating Manager with ID: {}, Updated Data: {}", id, manager);

        Manager updated = managerService.update(id, manager);

        if (updated == null) {
            logger.error("ERROR: Cannot Update — Manager Not Found with ID: {}", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ResponseMessageDto(404, "Manager not found"));
        }

        logger.info("SUCCESS: Manager Updated with ID: {}", id);

        ResponseMessageDto response = new ResponseMessageDto(
                200,
                "SUCCESS",
                "Manager updated successfully",
                updated
        );

        return ResponseEntity.ok(response);
    }

    // DELETE BY ID 
    @Operation(summary = "Delete Manager By ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseMessageDto> deleteManager(@PathVariable Long id) {

        logger.info("START: Deleting Manager with ID: {}", id);

        boolean deleted = managerService.deleteById(id);

        if (!deleted) {
            logger.error("ERROR: Cannot Delete — Manager Not Found with ID: {}", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ResponseMessageDto(404, "Manager not found"));
        }

        logger.info("SUCCESS: Manager Deleted with ID: {}", id);

        ResponseMessageDto response = new ResponseMessageDto(
                200,
                "SUCCESS",
                "Manager deleted successfully",
                null
        );

        return ResponseEntity.ok(response);
    }

    // DELETE ALL
    @Operation(summary = "Delete All Managers")
    @DeleteMapping
    public ResponseEntity<ResponseMessageDto> deleteAllManagers() {

        logger.warn("WARNING: Request Received to Delete ALL Managers");

        managerService.deleteAll();

        logger.info("SUCCESS: All Managers Deleted");

        ResponseMessageDto response = new ResponseMessageDto(
                200,
                "SUCCESS",
                "All Managers deleted successfully",
                null
        );

        return ResponseEntity.ok(response);
    }
}
