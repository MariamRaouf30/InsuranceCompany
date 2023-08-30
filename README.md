 <a name="readme-top"></a>

<!-- PROJECT LOGO -->
<br />
<div align="center">
    <img src="Documents/logo.png" alt="Logo" width="80" height="80">

  <h3 align="center">Project-README</h3>

</div>

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
          <li><a href="#built-with">Methodologies</a></li>
          <li><a href="#built-with">Domains</a></li>
          <li><a href="#built-with">Microservices</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project
The Insurance Company System is a comprehensive solution designed to manage customer information, policy creation, and customer requests using a powerful blend of REST and gRPC communication protocols. The project leverages a combination of Spring Boot, REST, gRPC, Lombok, and MongoDB to provide a seamless and user-friendly experience for both administrators and customers.
Built on a microservices architecture, the project leverages the speed and efficiency of gRPC, combined with the familiarity of REST. This dynamic combination enables efficient and high-performance interactions between microservices while ensuring broad accessibility and easy integration for external clients.


<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Built With

This section should list any major frameworks/libraries used to bootstrap your project. Leave any add-ons/plugins for the acknowledgements section. Here are a few examples.

* [![Spring][Spring.io]][Spring-url]
* [![React][React.js]][React-url]
* [![Vue][Vue.js]][Vue-url]
* [![Angular][Angular.io]][Angular-url]
* [![Svelte][Svelte.dev]][Svelte-url]
* [![Laravel][Laravel.com]][Laravel-url]
* [![Bootstrap][Bootstrap.com]][Bootstrap-url]
* [![JQuery][JQuery.com]][JQuery-url]

### Methodologies
* Microservices Architecture:
The system is designed as a collection of loosely coupled microservices, each focused on specific business functionalities. This architecture ensures independent deployment of services.

* Domain-Driven Design (DDD):
The project follows domain-driven design principles to align software design with the business domain, making the software more accurate and easier to maintain.

* Query-First Approach:
The system adopts a query-first approach, ensuring that data retrieval and presentation are optimized for efficient user experiences. This approach enhances the performance and responsiveness of customer interactions.

### Domains
Key Domains of the system:
* Customer:
  
Customers interact with the system to view policies, make requests, and manage their information.

* Policy:

This domain focuses on policy management. Policies are created and viewed by Customers.
  
* Request:

The request domain enables customers to submit various types of requests to update personal details.

### Microservices
Microservices that access domains:

* Registration.
* Login.
* CreatePolicy.
* GetCustomers.
* GetPolicies.
* MakeRequest.
* CustomerPolicy. (to create both customers and policies)

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started

Get started with the project

### Prerequisites

* Java 11 or higher
* MongoDB 
* npm
  ```sh
  npm install npm@latest -g
  ```

### Installation

1. Clone the repo
   ```sh
   git clone [https://github.com/your_username_/Project-Name.git](https://github.com/MariamRaouf30/InsuranceCompany)
   ```
2. Install NPM packages
   ```sh
   npm install
   ```
(For Frontend)
3. Springboot Extension to run the application
4. Configure port connections
5. Start your application after building

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- USAGE EXAMPLES -->
## Usage
The system is designed for scalability, adaptability and enhanced performance. It accommodates evolving business needs. Additional microservices can be seamlessly integrated to enhance functionality, keeping the system responsive to industry needs and customer expectations.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- ROADMAP -->
## Roadmap

- [x] ER Diagram
- [x] Use Cases for the system
- [x] Add Main Domains
- [x] Connect to Database (MongoDB) 
- [x] Add Microservices.
- [x] Frontend Project.
- [ ] Test project performance. 
    - [x] RESTful API 
    - [ ] gRpc


<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTACT -->
## Contact

Mariam Raouf - mariam.shenouda303@gmail.com

Project Link: [https://github.com/MariamRaouf30/InsuranceCompany](https://github.com/your_username/repo_name)

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- ACKNOWLEDGMENTS -->
## Acknowledgments
List of resources found helpful.

* (https://start.spring.io/)
* [Rest template](https://spring.io/projects/spring-data-rest)
* [gRPC and Spring boot example](https://www.north-47.com/grpc-communication-basic-configuration-for-spring-boot-microservices/)
* [MongoRepository Interface](https://docs.spring.io/spring-data/mongodb/docs/current/api/org/springframework/data/mongodb/repository/MongoRepository.html)
* [Lombok](https://www.baeldung.com/intro-to-project-lombok)
* [Services](https://www.tutorialspoint.com/spring_boot/spring_boot_service_components.htm)
* [Jmeter](https://jmeter.apache.org/)
  

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/othneildrew/Best-README-Template.svg?style=for-the-badge
[contributors-url]: https://github.com/othneildrew/Best-README-Template/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/othneildrew/Best-README-Template.svg?style=for-the-badge
[forks-url]: https://github.com/othneildrew/Best-README-Template/network/members
[stars-shield]: https://img.shields.io/github/stars/othneildrew/Best-README-Template.svg?style=for-the-badge
[stars-url]: https://github.com/othneildrew/Best-README-Template/stargazers
[issues-shield]: https://img.shields.io/github/issues/othneildrew/Best-README-Template.svg?style=for-the-badge
[issues-url]: https://github.com/othneildrew/Best-README-Template/issues
[license-shield]: https://img.shields.io/github/license/othneildrew/Best-README-Template.svg?style=for-the-badge
[license-url]: https://github.com/othneildrew/Best-README-Template/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/othneildrew
[product-screenshot]: images/screenshot.png
[Next.js]: https://img.shields.io/badge/next.js-000000?style=for-the-badge&logo=nextdotjs&logoColor=white
[Next-url]: https://nextjs.org/
[React.js]: https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB
[React-url]: https://reactjs.org/
[Vue.js]: https://img.shields.io/badge/Vue.js-35495E?style=for-the-badge&logo=vuedotjs&logoColor=4FC08D
[Vue-url]: https://vuejs.org/
[Angular.io]: https://img.shields.io/badge/Angular-DD0031?style=for-the-badge&logo=angular&logoColor=white
[Angular-url]: https://angular.io/
[Svelte.dev]: https://img.shields.io/badge/Svelte-4A4A55?style=for-the-badge&logo=svelte&logoColor=FF3E00
[Svelte-url]: https://svelte.dev/
[Laravel.com]: https://img.shields.io/badge/Laravel-FF2D20?style=for-the-badge&logo=laravel&logoColor=white
[Laravel-url]: https://laravel.com
[Bootstrap.com]: https://img.shields.io/badge/Bootstrap-563D7C?style=for-the-badge&logo=bootstrap&logoColor=white
[Bootstrap-url]: https://getbootstrap.com
[JQuery.com]: https://img.shields.io/badge/jQuery-0769AD?style=for-the-badge&logo=jquery&logoColor=white
[JQuery-url]: https://jquery.com 
[Spring.io]:
[Spring-url]:https://spring.io
