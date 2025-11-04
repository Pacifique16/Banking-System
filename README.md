# Title: Core Banking Java Application

A Java Swing-based project that demonstrates **CRUD operations** with **PostgreSQL**. This project allows users to manage bank accounts—register, search, update, delete, and retrieve all accounts—using a graphical user interface and database connectivity.

<BR>
<br>
<br>

## 🛠️ Technologies Used

* **Java (JDK 8 or higher)**
* **Swing GUI**
* **PostgreSQL Database**
* **JDBC Driver**

  <BR>

<br>
<br>

## 👥 Author

Pacifique HARERIMANA      ID: 26937 <BR> <br> <br>

# 🧠 Application Overview, Setup, and Screenshots

<BR>

## 1. 📌 *Dataset / Database Setup*

The application uses a PostgreSQL database called **`java_thursday_2025`**. A table named `bank_account` stores all bank account data.

### Table Structure:

```sql
CREATE TABLE bank_account (
    account_number VARCHAR(50) PRIMARY KEY,
    account_name VARCHAR(100) NOT NULL,
    account_type VARCHAR(50) NOT NULL,
    amount DOUBLE PRECISION NOT NULL
);
```

<BR>
<br>
<br>

## 2. 📝 *Java Project Structure*

```
src/
 ├─ dao/BankAccountDao.java      # Handles database operations (CRUD)
 ├─ model/BankAccount.java       # BankAccount model class
 └─ view/CoreBanking.java        # Main Swing GUI for users
 └─ view/TestSwing.java          # Basic Swing test example
```

<br>
<br>

## 3. ✅ *How to Run the Application*

1. **Ensure PostgreSQL is installed and running**.
2. **Create the database and table** (see section 1).
3. **Update `BankAccountDao.java`** with your PostgreSQL credentials:

```java
private String jdbcUrl = "jdbc:postgresql://localhost:5432/java_thursday_2025";
private String dbUsername = "postgres"; // your username
private String dbPassword = "postgres"; // your password
```

4. **Add PostgreSQL JDBC driver** to your project classpath.
5. Open `CoreBanking.java` in your IDE and run as a **Java Application**.

---

## 4. 🔹 *Application Functionalities & Screenshots*

### 4.1 Register a New Bank Account

* Enter account number, name, type, and amount.
* Click **REGISTER**.
* Successful registration shows a confirmation dialog.

### 4.2 Search for an Account

* Enter account number in the search box.
* Click **SEARCH**.
* Fields populate with account details.
* Account number becomes **locked** to prevent changes.

### 4.3 Update an Account

* Modify account name, type, or amount.
* Click **UPDATE**.
* Fields are updated in the database.

### 4.4 Delete an Account

* Search for the account first.
* Click **DELETE**.
* Confirmation dialog appears.
* Account is removed if confirmed.

### 4.5 Retrieve All Accounts

* Click **RETRIEVE**.
* A table with all accounts appears in a popup dialog.

---

## 5. ⚙️ *Optional: Test Swing Application*

* Open `TestSwing.java` and run to see a basic JFrame with a text area.
* Demonstrates Swing GUI basics without database connectivity.

<br>

## 6. 📌 Notes

* Ensure PostgreSQL is running before using the application.
* Do not modify table structure unless you update DAO accordingly.
* Error handling:

  * Duplicate account → warning dialog
  * Missing data → warning dialog
  * Invalid amount → warning dialog

<br>


## 7. 📜 References / Inspiration

* Swing Tutorials for GUI: [https://docs.oracle.com/javase/tutorial/uiswing/](https://docs.oracle.com/javase/tutorial/uiswing/)
* PostgreSQL JDBC: [https://jdbc.postgresql.org/](https://jdbc.postgresql.org/)

<br>
<br>
<br>
<br>
“Managing finances is not just about numbers; it’s about giving users control, clarity, and confidence in their money.”  

---


