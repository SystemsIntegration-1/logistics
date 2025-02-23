package flux.logistic.presentation.controllers;



import flux.logistic.application.dto.request.Branch_Refill_Request;
import flux.logistic.application.dto.response.RefilCreationResponse;
import flux.logistic.application.services.IRefillService;
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
    public ResponseEntity<RefilCreationResponse> createRefill(@RequestBody Branch_Refill_Request refillRequest) {
        RefilCreationResponse response = refillService.create(refillRequest);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Refill> getRefillById(@PathVariable UUID id) {
        Refill refill = refillService.getById(id);
        return ResponseEntity.ok(refill);
    }
}