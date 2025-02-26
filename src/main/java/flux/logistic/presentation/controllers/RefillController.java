package flux.logistic.presentation.controllers;



import flux.logistic.application.requests.BranchRefillRequest;
import flux.logistic.application.dto.response.RefillResponse;
import flux.logistic.application.services.contracts.IRefillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/refills")
@RequiredArgsConstructor
public class RefillController {

    private final IRefillService refillService;

    @PostMapping
    public ResponseEntity<RefillResponse> createRefill(@RequestBody BranchRefillRequest refillRequest) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(refillService.create(refillRequest));
    }

    @GetMapping("/{refillId}")
    public ResponseEntity<RefillResponse> getRefillById(@PathVariable("refillId") UUID refillId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(refillService.getById(refillId));
    }
}