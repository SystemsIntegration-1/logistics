package flux.system.logistics.presentation.controllers.consumer;

import flux.system.logistics.application.responses.BranchMedQueryResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

public class BranchApiConsumer {
    private static String HOST = "localhost:8080/stock";


    public BranchMedQueryResponse medBranchQuery(String address, UUID medId) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<BranchMedQueryResponse> response = restTemplate.getForEntity(String.format("%s/%s/%s", address, HOST, medId), BranchMedQueryResponse.class);

        if (response.getStatusCode().isError()) {
            System.out.printf("x_x culdn't not connect to %s%n", address);
        }

        return response.getBody();
    }

}
