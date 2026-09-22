# Java Online Food Ordering System

A console-based Online Food Ordering System developed in Java. The project demonstrates practical Java programming through object-oriented design, collections, inheritance, polymorphism, exception handling, input validation, CRUD-style operations, and file handling.

## Features

- Display food menu
- Search food by name
- Filter food by category
- Add food items to cart
- Remove items from cart
- Update cart quantities
- View cart
- Calculate subtotal, discount, and final bill
- Apply a simple discount based on order value
- Place an order
- Generate an order summary
- Save order history to a local file
- Input validation and exception handling

## Java Concepts Used

- Classes and Objects
- Encapsulation
- Inheritance
- Polymorphism
- Interfaces
- ArrayList and Collections
- CRUD-style operations
- Exception Handling
- File I/O
- String handling
- Loops and conditional statements

## Project Structure

```text
Java-Online-Food-Ordering-System/
├── src/
│   ├── FoodItem.java
│   ├── VegItem.java
│   ├── NonVegItem.java
│   ├── CartItem.java
│   ├── Cart.java
│   ├── Order.java
│   ├── FoodOrderingSystem.java
│   └── Main.java
├── data/
│   ├── menu.txt
│   └── orders.txt
└── README.md
```

## How to Run

Make sure Java JDK 8 or later is installed.

### Compile

Open a terminal in the project folder:

```bash
javac -d out src/*.java
```

### Run

```bash
java -cp out Main
```

## Sample Menu

The application starts with sample food items such as:

- Vegetable Biryani
- Paneer Pizza
- Masala Dosa
- Chicken Biryani
- Chicken Burger
- French Fries
- Gulab Jamun
- Fresh Lime Soda

The menu is stored in `data/menu.txt`.

## Discount Rule

- Orders of 1000 or more receive a 10% discount.
- Orders below 1000 receive no discount.

## Example Workflow

```text
1. View Menu
2. Search Food
3. Filter by Category
4. Add Food to Cart
5. View Cart
6. Remove Item
7. Update Quantity
8. Place Order
9. View Last Order
10. Exit
```

## Sample Output

```text
========================================
       ONLINE FOOD ORDERING SYSTEM
========================================
1. View Menu
2. Search Food
3. Filter by Category
4. Add Food to Cart
5. View Cart
6. Remove Item
7. Update Quantity
8. Place Order
9. View Last Order
10. Exit

Enter your choice: 1

ID    Name                    Category        Price
----------------------------------------------------
101   Vegetable Biryani       VEG             180.00
102   Paneer Pizza            VEG             250.00
103   Masala Dosa             VEG             120.00
104   Chicken Biryani         NON-VEG         280.00
105   Chicken Burger          NON-VEG         220.00
106   French Fries            VEG              90.00
107   Gulab Jamun             VEG              80.00
108   Fresh Lime Soda         VEG              70.00
```

## Author

Varshini Chinta
