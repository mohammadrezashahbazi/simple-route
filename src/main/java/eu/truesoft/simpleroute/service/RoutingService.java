package eu.truesoft.simpleroute.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import eu.truesoft.simpleroute.model.RoutingModel;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;

@Service
public class RoutingService {


    ObjectMapper objectMapper = new ObjectMapper();

    private final String JSON_URL = "https://raw.githubusercontent.com/mledoze/countries/master/countries.json";
//    private final String JSON_FILE = "F:\\countries.json";

    List<RoutingModel> routingModels = objectMapper.readValue(new URL(JSON_URL)
            , new TypeReference<List<RoutingModel>>() {

            });

    public RoutingService() throws IOException {

    }

    public Map<String, List<String>> getRouting(String origin, String destination) {
        origin = origin.toUpperCase();
        destination = destination.toUpperCase();

        List<String> originBorders = findCountryBordersIterator(origin, routingModels);
        List<String> destinationBorders = findCountryBordersIterator(destination, routingModels);

        List<String> differences = new ArrayList<>(originBorders);
        differences.retainAll(destinationBorders);

        if (differences.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        } else {
            List<String> result = new ArrayList<>();
            result.add(origin);
            result.add(differences.listIterator().next());
            result.add(destination);

            Map<String, List<String>> map = new HashMap<>();
            map.put("route", result);
            return map;
        }
    }

    public List<String> findCountryBordersIterator(String name, List<RoutingModel> list) {
        for (RoutingModel object : list) {
            if (object.getCca3().equals(name)) {
                return object.getBorders();
            }
        }
        return null;
    }
}
