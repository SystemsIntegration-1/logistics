package flux.logistic.presentation.controllers;



import flux.logistic.application.dto.request.BranchRefillRequest;
import flux.logistic.application.dto.response.RefillResponse;
import flux.logistic.application.services.contracts.IRefillService;
import flux.logistic.domain.entities.Refill;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/refills")
@RequiredArgsConstructor
public class RefillController {

    private final IRefillService refillService;

    @PostMapping
    public ResponseEntity<RefillResponse> createRefill(@RequestBody BranchRefillRequest refillRequest) {
        RefillResponse response = refillService.create(refillRequest);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RefillResponse> getRefillById(@PathVariable UUID id) {
        RefillResponse refillResponse = refillService.getById(id);
        return ResponseEntity.ok(refillResponse);
    }
}