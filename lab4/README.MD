# CSE 456 - Lab 04
## Architecture

### Layer Structure
- **Presentation Layer**: `Main.java` - Entry point and user interaction
- **Service Layer**: `PaymentService.java` - Business logic coordination
- **Data Layer**: Payment method implementations and repositories

### Question 1: Is the layered design as shown above reasonable? If not, how should it be revised?

**Answer:**

Yes

#### **It is reasonable because:**
- **Clear Separation of Concerns**: Each layer has distinct responsibilities
- **Dependency Injection**: Promotes loose coupling and testability
- **Open-Closed Principle**: Easy to extend with new payment methods
- **Single Responsibility**: Each class has one clear purpose
