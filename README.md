# operating-system-scheduling

# Overview:
The Restaurant Management System is a project that implements various scheduling algorithms to efficiently manage table allocation for customers. The system utilizes three different scheduling algorithms: FIFO (First-In-First-Out), LRU (Least Recently Used), and Second-Chance. These algorithms ensure fair and optimized table allocation based on customer arrivals and reentries.

# Features:
1. Table Allocation: The system assigns tables to customers based on the selected scheduling algorithm.
2. FIFO (First-In-First-Out): Tables are allocated to customers in the order they arrive.
3. LRU (Least Recently Used): Tables are allocated based on the least recently used table.
4. Second-Chance: Tables are allocated based on a reference bit, giving a second chance to tables that haven't been recently used.
5. Customer Reentry: The system handles customer reentry at the end of the business day, ensuring a seamless experience for returning customers.
6. Server Integration: The system receives notifications from the restaurant manager through a personal server, allowing for real-time updates and adjustments to table allocation.

# Usage:
1. Initialization: The system should be initialized by running the ClientAPI class, which establishes a connection with the server and sets up the necessary input and output streams.
2. Customer Arrival: As customers arrive, their unique ID is sent to the system through the send_data() method of the ClientAPI class.
3. Table Allocation: The client class, which extends the Thread class, handles the table allocation process based on the selected scheduling algorithm (FIFO, LRU, or Second-Chance). The add_page() method of the respective scheduling algorithm class is called to allocate a table to the customer.
4. Customer Reentry: At the end of the business day, a customer with ID 0 is sent to the system, indicating a reentry. The scheduling algorithm classes track the number of page faults (failed table allocations) during the day.
5. Displaying Results: The system prints the results of the table allocation for each scheduling algorithm, including the number of page faults and the current state of tables.

# Dependencies:
- The project requires a personal server to receive notifications from the restaurant manager. The server should be running on the same machine with the IP address "127.0.0.1" and port number 8080. Ensure that the server is properly configured and able to establish a connection with the ClientAPI class.
  
# Disclaimer:
- This Restaurant Management System is a sample project and may not be suitable for production environments without further modifications and enhancements. Use it as a learning resource and adapt it to meet your specific requirements.
