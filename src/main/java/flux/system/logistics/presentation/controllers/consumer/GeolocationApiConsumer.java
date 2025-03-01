package flux.system.logistics.presentation.controllers.consumer;

import flux.system.logistics.domain.entities.Address;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class GeolocationApiConsumer {
    private static String HOST = "localhost:8080/localization/";

    public int measureDistanceTwoPoints(Address origin, Address target) {
        RestTemplate restTemplate = new RestTemplate();
        // TODO: use a request body to pass origin and target
        String path = "measure-distance?origin=%s&target=%s";
        ResponseEntity<Integer> response = restTemplate.getForEntity(String.format("%s/%s", HOST, path), Integer.class);

        if (response.getStatusCode().isError()) {
            System.out.printf("x_x culdn't not connect to %s%n", HOST);
        }
        return response.getBody();
    }


    // TODO: use this method if branch has customer address available
    // pivot = customer's address
    public Integer measureDistanceThreePoints(Address origin, Address target, Address pivot) {
        RestTemplate restTemplate = new RestTemplate();
        // TODO: use a request body to pass origin and target
        String path = "measure-distance?origin=%s&target=%s&pivot=%s";
        ResponseEntity<Integer> response = restTemplate.getForEntity(String.format("%s/%s", HOST, path), Integer.class);

        if (response.getStatusCode().isError()) {
            System.out.printf("x_x culdn't not connect to %s%n", HOST);
        }
        return response.getBody();
    }
}