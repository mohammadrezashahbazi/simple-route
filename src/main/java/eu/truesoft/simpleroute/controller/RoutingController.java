package eu.truesoft.simpleroute.controller;

import eu.truesoft.simpleroute.service.RoutingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "routing")
public class RoutingController {

    private final RoutingService routingService;

    public RoutingController(RoutingService routingService) {
        this.routingService = routingService;
    }

    @GetMapping(path = "/{origin}/{destination}")
    public @ResponseBody
    Map<String, List<String>> getRouting(@PathVariable("origin") String origin,
                                         @PathVariable("destination") String destination) {
        return routingService.getRouting(origin,destination);
    }
}
