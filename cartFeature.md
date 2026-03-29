# Problem Statement
---
You are building a simple Cart Price Calculator module for an e-commerce application.
The system should calculate the final payable amount based on the following rules:

1. Each cart contains multiple items.
2. Each item has:
  -  name
  -  price
  -  quantity
3. Apply discounts
  -  If total cart value > ₹5000 → Apply 10% discount
  -  If total cart value > ₹10000 → Apply 20% discount
4. If coupon code "FLAT500" is applied:
  - Deduct ₹500 (only if total after discount ≥ ₹2000)
5. Add GST of 18% on the final discounted amount.

---

You are expected to provide:
- Data model (entities and relationships)
- Class design (well-structured object model)
- Basic implementation structure (core classes and method signatures)
- Unit test cases (JUnit-style test scenarios for key classes)
- You may implement the solution for any three high-level components.

---

## 1. CLASS DESIGN (Object Model)

---

## 2. CLASS DESIGN (Object Model)

Cart
  - List<CartItem> items
  - CouponCode coupon
  + getCartTotal(): double
  + applyDiscounts(double total): double
  + applyCoupon(double amount): double
  + applyGST(double amount): double
  + getFinalPayableAmount(): double

CartItem
  - String name
  - double price
  - int quantity
  + getTotalPrice(): double

CouponCode
  - String code
  + isApplicable(double amount): boolean
  + getCouponDiscount(): double

CartPriceCalculator (main service)
  + calculateFinalAmount(Cart cart): double

---

  ## 3. BASIC IMPLEMENTATION STRUCTURE (Core Java Classes)

---

  ## 4. UNIT TEST CASES (JUnit 5)

---

  ## 5. THREE HIGH-LEVEL COMPONENTS IMPLEMENTED

The solution covers 3 main components end-to-end:

1. Domain Layer (Entities / Data Model)
Cart
CartItem
CouponCode
2. Service Layer
CartPriceCalculator (Core calculation engine)
3. Unit Testing Layer
JUnit tests verifying discount, coupon, GST, and rounding logic.

---
