package flux.logistic.presentation.controllers;

import flux.logistic.application.services.IBranchService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/branches")
public class BranchController {
  private final IBranchService branchService;

  public BranchController(IBranchService branchService) {
    this.branchService = branchService;
  }
}
