# HexagonalSpring_Modular

HexagonalSpring_Modular is a sample project that demonstrates the implementation of a Modular Monolith with Modular compiles.  The proposed architecture that the example is based upon aims for a single runtime
and provides the project with the ability to later **cooperate** with Service Oriented Architectures.


## Table of Contents

- [Introduction](#introduction)
- [Architecture Overview](#architecture-overview)
- [Modules](#modules)
- [Implementation Strategy](#implementation-strategy)
- [Getting Started](#getting-started)
- [License](#license)

## Introduction

Hexagonal architecture is a good starting point to identify the surrounding functionalites of a project being build in a Distributed context. By already having interfaces as ports, the indetification of the modules-to-be-created becomes easier.
 This means, that apart from the domain, there is the need for persistence and code that enables the communication with other systems, and those are seperated from each other.  
For more information about the arising questions see:  
- [M. Tsechelidis, N. Nikolaidis, T. Maikantis, and A. Ampatzoglou, "Modular Monoliths the Way to Standardization", 3rd Eclipse Security, AI, Architecture and Modelling Conference on Cloud to Edge Continuum (ESAAM 2023), Germany, 2023.](https://www.researchgate.net/publication/373195134_Modular_Monoliths_the_way_to_Standardization)
- [M. Tsechelidis, "Developing Distributed Systems with Modular Monoliths and Microservices", psepheda, University of Macedonia, Greece, 2023.](#BSc-link-TBA)
<a name="esaam-link-TBA"></a><a name="BSc-link-TBA"></a>

## Architecture Overview

![Example project as implementation of proposed architecture](https://github.com/tsechelidisMichail/HexagonalSpring_Modular/assets/82568995/08b2e58d-6e5d-4d7e-8ed3-5ab5895abf9c)  
  
  
While it may not seem apparent at first, with the help of Dependency Injection and a couple of patterns, the diagram is enforced to resemble a tree-like structure.  
The internal functionalities remain hidden from developers since those are provided at runtime and not compile time.

![Figure 1 - Modular Monolith vs Monolith drawio](https://github.com/tsechelidisMichail/HexagonalSpring_Modular/assets/82568995/af7b7cae-1e05-488a-a755-5933bb5c226a)


## Modules

- `main`: Initializer scanning in runtime the dependencies/services. It is the executable.
- `domain`: Global/core logic that any service can use (interface definitions only - like API).
- `domain_imp`: Implementation of domain, and any other class to support the exposed domain to the services.
- `web_account`: Inbound and outbound handling for account (service).
- `web_movies`: Inbound and outbound handling for movies (service).
- `queries`: Global/core queries that any service can use (interface definitions - like API).
- `databasePrimary`: Schemas, and queries implemention (used by account and movie).
- `databaseSecondary`: Schemas, and queries implemention (used by movie).

## Implementation Strategy

[HSMB-v3](https://github.com/tsechelidisMichail/HSMB-v3)  
The referenced repository is the implementation startegy of HexagonalSpring_Modular that aims to resolve all the remaining development requirements by introducing Git branches and Github packages.

## Getting Started

To run the example a mysql database needs to be running with user:root and password:pass123 (a 2 sample databases will be created).

To run the project (From project folder - HexagonalSpring_Modular):
```
./mvnw install
```
```
cd main;../mvnw spring-boot:run
```
OR  
(For using -Pnative flag and the .bat file make sure you have graalvm)
```
./mvnw package -Pnative
```
```
cd main;./spring-native.bat
```
```
cd target/native;./main-2.0-SNAPSHOT.exe
```
OR  
(For using -Pnative flag make sure you have graalvm)
```
./mvnw package -Pnative OR ./mvnw package
```
```
cd main/target;java -jar main-2.0-SNAPSHOT.jar
```

## License

This project is licensed under the [MIT License](LICENSE).
