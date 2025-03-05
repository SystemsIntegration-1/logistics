package flux.system.logistics.presentation.controllers.consumer;

import flux.system.logistics.application.responses.BranchMedQueryResponse;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

public class BranchApiConsumer {
    public static String PATH = "api/batches/shared";

    public BranchMedQueryResponse medBranchQuery(String address, UUID medId) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<BranchMedQueryResponse>> response = restTemplate.exchange(
                String.format("%s/%s/%s", address, PATH, medId),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<BranchMedQueryResponse>>() {}
        );

        if (response.getStatusCode().isError()) {
            System.out.printf("x_x culdn't not connect to %s%n", address);
        }
        List<BranchMedQueryResponse> body = response.getBody();
        if (body.isEmpty()){
            System.out.printf("Response body is empty%n");
        }

        if (body.size() > 1){
            System.out.printf("Response body ID has more than one med relationship with sharedID%n");
        }

        return response.getBody().get(0);
    }

}
