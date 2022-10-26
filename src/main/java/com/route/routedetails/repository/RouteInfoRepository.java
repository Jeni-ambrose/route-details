package com.route.routedetails.repository;

import com.route.routedetails.domain.RouteInfo;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RouteInfoRepository extends ReactiveMongoRepository<RouteInfo, String> {
    Mono<RouteInfo> findRouteListBySourceAndDestination(String source, String destination);

}
