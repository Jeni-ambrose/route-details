package com.route.routedetails.controller;

import com.route.routedetails.domain.RouteInfo;
import com.route.routedetails.service.RouteInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/v1")
public class RouteController {
    @Autowired
    private RouteInfoService routeInfoService;

    @PostMapping("/routeInfos")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<RouteInfo> addRouteInfo(@RequestBody RouteInfo routeInfo)
    {
        log.info("Recieved route Object :{}", routeInfo);
        return routeInfoService.addRouteInfo(routeInfo);

    }




    @GetMapping("/routeInfos")
    public Mono<RouteInfo> addRouteInfo(@RequestParam("source") String source,
                                        @RequestParam("destination") String destination)
    {
        log.info("Recieved route list request for {} :{}", source, destination);
        return routeInfoService.getRouteListForSourceToDestination(source, destination);

    }

}
