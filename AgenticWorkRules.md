# SYSTEM RULES & PROJECT CONTEXT

## 1. PROJECT OVERVIEW & METADATA
- **Project Name:** [e.g., Core Billing Service]
- **Domain/Purpose:** [Brief 1-2 sentence description of what this software actually does]
- **Primary Tech Stack:** [e.g., Java 21, Spring Boot 3.x, PostgreSQL, Apache Kafka]
- **Architecture Pattern:** [e.g., Hexagonal Architecture / Clean Architecture / Microservices]

---

## 2. REPOSITORY MAP & DIRECTORY STRUCTURE
[Provide a high-level map so the AI knows where files live without having to recursively search every directory]
- `/src/main/java/.../domain`: Core business logic and entities (Zero external dependencies allowed here).
- `/src/main/java/.../ports`: Interfaces defining inbound (driving) and outbound (driven) operations.
- `/src/main/java/.../adapters`: Concrete implementations (Web controllers, JPA repositories, Kafka consumers).
- `/src/main/resources`: Configuration properties and database migration scripts (Flyway/Liquibase).
- `/src/test`: Unit tests (Mockito/JUnit 5) and Integration tests.

---

## 3. STRICT BEHAVIORAL & CODING RULES

### 3.1 Architectural Constraints
- **Rule 1:** You must strictly maintain the separation of layers. Never allow framework or infrastructure leaks into the domain layer.
- **Rule 2:** All data passing across boundary layers must use explicit Data Transfer Objects (DTOs). Never expose raw database entities directly to the Web/API layer.

### 3.2 Code Style & Idioms
- **Rule 3:** Prefer explicit composition over inheritance. 
- **Rule 4:** Dependency Injection: Always use constructor injection. Never use field injection (e.g., `@Autowired` on private fields is strictly forbidden).
- **Rule 5:** Concurrency & Asynchrony: Use non-blocking abstractions where applicable. Any manual thread management must utilize managed thread pools; never instantiate raw `new Thread()` blocks.

### 3.3 State Management & Data Flow
- **Rule 6:** Treat all event payloads (e.g., Kafka messages) as immutable. Ensure proper serialization/deserialization boundaries are explicitly defined and validated.
- **Rule 7:** Database transactions must be scoped as tightly as possible. Avoid keeping transactions open during external HTTP calls or heavy third-party API processing.

---

## 4. TESTING CRITERIA
- **Unit Testing:** Every new business logic component must have a corresponding unit test. Use mock objects to isolate dependencies. Ensure proper setup and verification of mock behaviors without over-specifying interactions.
- **Integration Testing:** Write integration tests for database adapters and messaging gateways using isolated environments (e.g., test containers or embedded profiles). Do not mock data sources in integration tests.
- **Naming Conventions:** Test classes must match the target class name suffixed with `Test`. Test methods must clearly state the condition and expected outcome (e.g., `should_ThrowException_When_PayloadIsInvalid`).

---

## 5. REFACTORING & CHANGE PROTOCOL
Before writing or modifying any code, you must execute the following cognitive steps:
1. **Analyze Context:** Read existing files in the target directory to match the local variable naming conventions, logging styles, and formatting details.
2. **Impact Assessment:** If a change impacts an interface, identify all concrete implementations across the repository and update them simultaneously.
3. **No Placeholders:** Provide complete, production-ready code implementations. Do not use comments like `// TODO: implement later` or `// ... rest of the code remains the same ...`.