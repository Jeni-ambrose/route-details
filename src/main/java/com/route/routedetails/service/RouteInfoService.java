package com.route.routedetails.service;

import com.route.routedetails.domain.RouteInfo;
import com.route.routedetails.repository.RouteInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class RouteInfoService {
    @Autowired
    private RouteInfoRepository routeInfoRepository;

    public Mono<RouteInfo> addRouteInfo(RouteInfo routeInfo) {
        log.info("Recieved Route Object :{}", routeInfo);
        return routeInfoRepository.save(routeInfo).log();
    }

    public Mono<RouteInfo> getRouteListForSourceToDestination(String source, String destination) {
        log.info("At Service :Recieved Route List Request for {}:{}", source, destination);
        return routeInfoRepository.findRouteListBySourceAndDestination(source,destination).log();
    }
}
