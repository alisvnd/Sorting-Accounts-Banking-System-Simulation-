# Sorting-Accounts-Banking-System-Simulation-
This project is a Java console-based banking system simulation that manages users, multiple account types, and currency conversions. Each user has a unique 9-digit ID, personal information, and multiple bank accounts holding balances in different currencies.

The system supports four currency types, each with a configurable conversion rate to a common currency. A user’s total balance is calculated by converting all account balances into this common currency, allowing meaningful comparisons between users.

The application can generate large sets of random users, each with randomly assigned accounts and balances, making it suitable for performance testing. Users can be listed, searched by ID, and their detailed account information can be displayed with proper exception handling when invalid IDs are provided.

A key feature of the project is a hybrid sorting algorithm that combines Quick Sort and Insertion Sort. Users can be sorted either by user ID or by total balance in common currency, and the sorting behavior is controlled by a configurable threshold that determines when insertion sort is used. The program measures and reports sorting execution time, enabling performance comparisons with different thresholds and data states (unsorted vs. already sorted).

The system also allows resetting to the original unsorted data, updating currency conversion rates dynamically, and re-sorting users to observe how these changes affect ordering.

This project demonstrates data structures, custom sorting algorithms, performance analysis, exception handling, and object-oriented design in Java.
