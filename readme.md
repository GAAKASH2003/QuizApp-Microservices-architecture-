# Quiz Microservices Project

This project is a microservices-based application for managing quizzes and questions. It consists of multiple services including an API Gateway, a Question Service, a Quiz Service, and a Service Registry.


## Services

### API Gateway

The API Gateway handles routing and forwarding requests to the appropriate microservices.

- **Path:** `api-gateway/api-gateway`
- **Main Class:** `com.example.api_gateway.ApiGatewayApplication`

### Question Service

The Question Service manages questions and provides endpoints to retrieve and add questions.

- **Path:** `question-service/question-service`
- **Main Class:** `com.example.question_service.QuestionServiceApplication`
- **Controller:** `com.example.question_service.controller.QuestionController`

### Quiz Service

The Quiz Service manages quizzes and provides endpoints to create quizzes, get quiz questions, and calculate quiz results.

- **Path:** `quiz-service/quiz-service`
- **Main Class:** `com.example.quiz_service.QuizServiceApplication`
- **Controller:** `com.example.quiz_service.controller.QuizController`
- **Service:** `com.example.quiz_service.service.QuizService`
- **Feign Client:** `com.example.quiz_service.feign.QuizInterface`

### Service Registry

The Service Registry is used for service discovery and registration.

- **Path:** `service-registry/service-registry`
- **Main Class:** `com.example.service_registry.ServiceRegistryApplication`

## Running the Project

To run the project, you need to start each service individually. You can use the following commands:

1. Navigate to the service directory.
2. Use Maven to build and run the service.

For example, to run the Quiz Service:

```sh
cd quiz-service/quiz-service
./mvnw spring-boot:run


