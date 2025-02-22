# Spending Tracker List Application

## Project Overview
The **Spending Tracker List Application** is a command-line-based tool designed for avid command-line power users. It helps users store and manage records of products they have purchased, utilizing a **Singly Linked List (SList)** for data management and a **binary file** for persistent storage.

## Features
The application includes the following core functionalities:

- **writeProductItemToFile**: Appends a new `ProductItem` to the binary file.
- **readProductItemsFromFile**: Reads all objects from the binary file and loads them into a **Singly Linked List (SList)**.
- **addAfter**: Adds an element after a specified node in the linked list.
- **addBefore**: Inserts an element before a specified node in the linked list.
- **remove**: Removes a specified node from the list and returns the removed element.
- **search**: Searches for a node that contains a specified element.
- **toString**: Overrides the default `toString` method to provide a formatted display of all items in the list.

## Implementation Details
The project will be implemented in **Java** and will involve the following components:

- **Binary File Handling**: Storing and retrieving product data in a binary format.
- **Singly Linked List (SList)**: A custom implementation to manage product records dynamically.
- **Command-Line Interface**: A user-friendly CLI for interacting with the spending tracker.

## Getting Started
### Prerequisites
- Java Development Kit (JDK 11 or higher)
- Any Java-compatible IDE (e.g., IntelliJ IDEA, Eclipse, or VS Code)
- Basic understanding of **File I/O** and **Linked Lists** in Java

### Installation
 Clone this repository:
   ```sh
   git clone https://github.com/MAVUNDL/Java-LinkedList-with-Binary-IO.git
   ```

## Usage
Once the application is running, users can add, search, remove, and manage their spending records through simple command-line inputs.

## Contributing
If you would like to contribute to this project, feel free to fork the repository and submit a pull request.
