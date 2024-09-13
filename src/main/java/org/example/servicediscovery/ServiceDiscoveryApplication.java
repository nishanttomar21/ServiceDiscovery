/**
 1. API Gateway
    Best suited for scenarios where you need comprehensive API management, including security, monitoring, and request routing. It is ideal for microservices architectures where multiple services are exposed to clients.

 2. Load Balancer
    More effective for scenarios focused solely on distributing traffic efficiently among multiple servers, ensuring high availability and reliability without the additional overhead of API management features.

 3. Service Registry
     - A service registry is a centralized database that maintains information about all available services and their instances within a microservices architecture. It acts as a directory where services register themselves upon startup, providing details such as their network location (IP address and port), health status, and other metadata. This registry is essential for managing service instances, as it allows for dynamic updates and health monitoring, ensuring that clients interact only with healthy services.
     - This is a specific component or tool that is often used as part of a service discovery solution.
     - It's essentially a database that keeps track of available service instances.

     Key functions of a service registry include:
         A. Helps in communication between different microservices
         B. Service Registration: Services register themselves with the registry when they start, providing necessary metadata.
         C. Service Lookup: Clients query the registry to discover the available instances of a service they wish to communicate with.
         D. Health Monitoring: The registry can monitor the health of registered services and remove any that are unhealthy from its records.
         E. Load Balancing: Some service registries also support load balancing by distributing requests among multiple service instances.

 4. Service Discovery
     - It refers to the process by which a client or service locates and connects to other services in a microservices architecture.
     - This is the overall process or mechanism of finding and connecting to services in a distributed system.
     - It's a broader concept that encompasses various techniques and components.
     - Adapts to changes in service instances and locations and minimal manual configuration required

 It can be categorized into two main types:
     A. Client-side Discovery (our implementation): The client is responsible for determining the network location of the service it wants to call. It queries the service registry to get the service's address and then makes the call directly.
     B. Server-side Discovery: The client sends a request to a load balancer or API gateway, which then queries the service registry and forwards the request to the appropriate service instance. This approach abstracts the service location from the client.

 Load Balancing: Distributes incoming requests across multiple service instances

 Relationship Between Service Registry and Service Discovery:
 The service registry is a crucial component enabling service discovery. It provides the necessary information that clients and services need to locate each other. While the service registry stores the details of all services, service discovery mechanisms utilize this information to facilitate communication between services. Thus, effective service discovery relies heavily on a well-maintained service registry.

 In summary, while the service registry serves as the database of service instances, service discovery encompasses the methods and processes used to locate and connect to those services.

 Service Discovery (Process/Technique)
 ├── Service Registry (Database/Component)
 ├── Load Balancer/Router
 ├── Health Checking
 └── Other supporting components

 5. How Service Discovery Works for Communication
     A. Service Registration: When a microservice starts, it registers itself with a service registry, providing essential information such as its name, IP address, port number, and health status. This registry acts as a central database that keeps track of all service instances in the network.
     B. Service Discovery: When a client (another service) needs to communicate with a specific service, it queries the service registry to obtain the current location of the desired service instance. This process allows the client to discover the available instances dynamically, ensuring it can connect to the correct service without prior knowledge of its location.
     C. Load Balancing: Service discovery often includes load balancing capabilities. Once the client retrieves the list of available service instances from the registry, it can distribute requests among them, optimizing resource utilization and enhancing performance.
     D. Health Monitoring: Service discovery systems continuously monitor the health of registered services. If a service becomes unhealthy or goes offline, the registry automatically removes it from the list of available services, preventing clients from attempting to communicate with it.
     E. Dynamic Configuration: As microservices are added, removed, or scaled, service discovery provides a dynamic way to configure client applications. This adaptability is essential in environments where service instances can change frequently, such as in cloud deployments

 6. Spring Cloud
    It is a framework designed to facilitate the development of cloud-native applications, particularly those built using microservices architecture. It provides a suite of tools and services that help developers manage various aspects of distributed systems.

    Key Features of Spring Cloud:
         A. Service Registration and Discovery: Spring Cloud enables microservices to register themselves with a service registry (like Netflix Eureka) and discover other services. This process decouples service consumers from service providers, allowing for dynamic service discovery without hardcoding network locations.
         B. Distributed Configuration: It offers a centralized configuration management system through Spring Cloud Config, allowing applications to externalize and manage configuration properties across different environments. This ensures consistency and ease of management for configuration settings.
         C. Routing: Spring Cloud provides intelligent routing capabilities, allowing incoming requests to be forwarded to the appropriate service based on various criteria, which enhances the overall efficiency of service interactions.
         D. Load Balancing: The framework includes load balancing features to distribute incoming requests across multiple service instances, optimizing resource utilization and improving response times.
         E. Circuit Breakers: Spring Cloud integrates circuit breaker patterns (e.g., using Resilience4j) to prevent calls to services that are likely to fail, thus improving the resilience of applications by avoiding unnecessary resource consumption.
         F. Service-to-Service Calls: It facilitates communication between microservices, allowing them to call each other efficiently through service discovery mechanisms.
         G. Global Locks and Leadership Election: Spring Cloud provides mechanisms for global locks to prevent concurrent access to shared resources and for leadership election to coordinate actions among instances in a cluster.
         H. Distributed Messaging: It supports reliable messaging systems, enabling asynchronous communication between services, which is crucial for building resilient microservices.

    Components of Spring Cloud:
         A. Spring Cloud Config: For distributed configuration management.
         B. Netflix Eureka: For service registration and discovery.
         C. Spring Cloud Gateway: For API routing and load balancing.
         D. Resilience4j: For circuit breaker functionality.
         E. Spring Cloud Stream: For building event-driven microservices with messaging.

    Conclusion
         Spring Cloud simplifies the development of microservices by providing essential tools for configuration management, service discovery, routing, load balancing, and resilience. Its integration with the Spring ecosystem makes it a powerful choice for building cloud-native applications that are scalable, maintainable, and efficient.

    7. Drawback of using Microservice Architecture
         A. Increased Complexity: Microservices introduce more complexity compared to monolithic architectures. Breaking an application into numerous smaller services makes the overall system more intricate. Understanding the interactions between different services can be challenging.
         B. Communication Overhead: Communication between microservices often occurs over a network, leading to latency, network failures, and increased traffic. This can degrade performance, especially for latency-sensitive operations.
         C. Data Management Challenges: Microservices may have their own databases, complicating data consistency across services. Maintaining data integrity requires additional effort, especially during updates or migrations.
         D. Versioning and Compatibility Issues: As microservices interact through APIs, changes in one service may have implications for others. This can lead to versioning challenges and potential compatibility problems during upgrades or service changes.
         E. Increased Resource Usage: Running multiple microservice instances consumes more resources than a single monolithic application in most cases. This can increase infrastructure costs if not managed efficiently.
         F. Debugging and Monitoring Complexity: Debugging issues across a distributed system with many moving parts is more difficult than in a monolithic architecture. Monitoring the health and performance of individual services also requires additional tooling and processes.
         G. Organizational and Cultural Challenges: Adopting microservices requires changes to team structures, processes, and tooling. It may necessitate investments in training and recruiting specialized DevOps talent to manage the increased complexity.

         While microservices offer benefits like scalability and flexibility, organizations must carefully weigh these advantages against the drawbacks, especially for smaller projects where the complexity may outweigh the benefits. Proper planning, automation, and monitoring are key to successfully managing a microservices architecture.

    8. Eureka
     It is a service discovery and registration framework developed by Netflix as part of their open-source software stack. Let me provide a more comprehensive overview:

    Key aspects of Eureka:
        A. Purpose:
            - Primarily used for locating services in a distributed system, especially in cloud environments.
            - Facilitates automatic detection of services without hardcoding network locations.
        B. Components:
            - Eureka Server: Acts as the registry and discovery server.
            - Eureka Client: Used by services to register themselves and to query for other services.
        C. Functionality:
            - Service Registration: Services register their network locations and other metadata.
            - Service Discovery: Clients can query for available service instances.
            - Health Checking: Monitors the health of registered services.
        D. Architecture:
            - Typically deployed as a cluster of Eureka servers for high availability.
            - Supports both client-side and server-side service discovery patterns.
        E. Integration:
            - Part of Netflix OSS (Open Source Software) stack.
            - Often used with other Netflix tools like Ribbon (client-side load balancing) and Hystrix (circuit breaker).
        F. Key Features:
            - Self-preservation mode: Protects registry data during network partitions.
            - REST API: For service registration, de-registration, and querying.
            - Dashboard: Provides a web-based view of registered services.
         G. Use Cases:
            - Microservices architectures
            - Cloud-native applications
            - Dynamically scaling environments
         H. Advantages:
            - Simplifies service-to-service communication in distributed systems.
            - Supports multiple data centers and regions.
            - Provides near real-time updates on service health and locations.

 */

package org.example.servicediscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer     // Add this annotation to enable Eureka server (Implemented Client-side Service Discovery)
public class ServiceDiscoveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceDiscoveryApplication.class, args);
    }
}
