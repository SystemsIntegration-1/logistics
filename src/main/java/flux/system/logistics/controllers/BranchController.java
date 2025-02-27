package flux.system.logistics.controllers;

import flux.logistic.application.requests.BranchCreateRequest;
import flux.logistic.application.responses.BranchResponse;
import flux.logistic.application.services.contracts.IBranchService;
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

  @PutMapping
  public ResponseEntity<BranchResponse> updateBranch(@RequestBody BranchCreateRequest branchCreateRequest) {
    return null;
  }
}
