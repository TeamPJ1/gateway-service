package com.mak.gatewayservice;

import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    @Bean
    DiscoveryClientRouteDefinitionLocator discoveryClientRouteDefinitionLocator(
            ReactiveDiscoveryClient reactiveDiscoveryClient, DiscoveryLocatorProperties discoveryLocatorProperties){
        // Configuration dynamique pour la decouverte de service via bean
        // on prend le nom de service depuis l'url de la requete.
        return new DiscoveryClientRouteDefinitionLocator(reactiveDiscoveryClient,discoveryLocatorProperties);
    }



/*	//@Bean
	RouteLocator routeStaticLocator (RouteLocatorBuilder builder){
		// Configuration statique via bean /or apllication.yml
		// on utilise lorsqu' on a des IP fixes exemple lorsque vous appelez des service publiques (api horaires prieres)
		// Pour des services ayant des IP dynamiques, utilisez Eureka Server
		return builder.routes()
				.route((r)-> r.path("/customers/**").uri("http://localhost:8081/"))
				.route((r)-> r.path("/products/**").uri("http://localhost:8082/"))
				.build();
	}

	//@Bean
	RouteLocator routeLocatorBasedLoadBalancer (RouteLocatorBuilder builder){
		// Configuration statique via bean /
		// on utilise lorsqu'on a des services enregistres sur Eureka Server et on connait juste les noms des services
		return builder.routes()
				.route((r)-> r.path("/customers/**").uri("lb://CUSTOMER-SERVICE/"))
				.route((r)-> r.path("/products/**").uri("lb://INVENTORY-SERVICE/"))
				.build();
	}*/


}