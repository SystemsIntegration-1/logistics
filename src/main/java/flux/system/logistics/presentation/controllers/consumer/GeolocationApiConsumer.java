package flux.system.logistics.presentation.controllers.consumer;

import flux.system.logistics.domain.entities.Address;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

public class GeolocationApiConsumer {
    private static String HOST = "localhost:8080/localization/";
    private Random random;

    public GeolocationApiConsumer() {
        random = new Random();
    }

    // TODO: mocked geolocation
    public int measureDistanceTwoPoints(Address origin, Address target) {
        return random.nextInt(1000, 10000);
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