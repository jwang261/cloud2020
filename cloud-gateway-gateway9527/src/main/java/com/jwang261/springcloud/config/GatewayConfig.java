package com.jwang261.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jwang261
 * @date 2020/7/29 11:58 PM
 */
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator myRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_1",
                r -> r.path("/news")
                        .uri("http://news.baidu.com/guoji")).build();

        return routes.build();
    }

}
