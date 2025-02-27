package flux.system.logistics.presentation.controllers;

import flux.system.logistics.application.requests.BranchCreateRequest;
import flux.system.logistics.application.requests.BranchUpdateRequest;
import flux.system.logistics.application.responses.BranchResponse;
import flux.system.logistics.application.services.IBranchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/branches")
public class BranchController {
  private final IBranchService branchService;

  public BranchController(IBranchService branchService) {
    this.branchService = branchService;
  }

  @GetMapping("/{branchId}")
  public ResponseEntity<?> getBranchById(@PathVariable("branchId") UUID branchId) {
    return ResponseEntity
            .status(HttpStatus.OK)
            .body(branchService.getBranchById(branchId));
  }

  @GetMapping
  public ResponseEntity<?> getAllBranches() {
    return ResponseEntity
            .status(HttpStatus.OK)
            .body(branchService.findAllBranches());
  }

  @PostMapping
  public ResponseEntity<BranchResponse> createBranch(@RequestBody BranchCreateRequest branchCreateRequest) {
    BranchResponse createdBranch = branchService.createBranch(branchCreateRequest);
    return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(createdBranch);
  }

  @PutMapping("/{branchId}")
  public ResponseEntity<BranchResponse> updateBranch(@PathVariable("branchId") UUID branchId, @RequestBody BranchUpdateRequest branchUpdateRequest) {
    BranchResponse updatedBranch = branchService.updateBranchById(branchId, branchUpdateRequest);

    return ResponseEntity
            .status(HttpStatus.OK)
            .body(updatedBranch);
  }

  @DeleteMapping("/{branchId}")
  public ResponseEntity<?> deleteBranch(@PathVariable("branchId") UUID branchId) {
    boolean isBranchDeleted = branchService.deleteBranchById(branchId);

    if (!isBranchDeleted) {
      return ResponseEntity
              .status(HttpStatus.NOT_FOUND)
              .body("Branch with id " + branchId + " not found");
    }

    return ResponseEntity
            .status(HttpStatus.OK)
            .body("Branch deleted successfully");
  }
}