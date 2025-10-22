Practical Evaluation - Architecture of Information Systems
Environment: VS Code, JDK 11, Maven, Tomcat 10
Context - Online Book Borrowing System
You are required to develop a mini web application for an Online Book Borrowing /
Reservation System, based on the MVC (Model – View – Controller) architecture using
Jakarta Servlets, JSP/JSTL, and JavaBeans/EJBs (conceptually, though Tomcat supports only
standard JavaBeans).
The system simulates a small library website where users can:
• View a catalog of available books
• Reserve (borrow) a book (data stored in memory)
• View the list of borrowed books
• Return a borrowed book
• View a summary page (“checkout”) of all borrowed books
Note:
Basically for this evaluation you are not required to do database connection.
Regulation & Submission Information:
• The complete project zip file (including target/tpeval.war), along with short report
must be submitted on Celene before October 26 at 22:00.
• Late submissions by email will not be accepted.
• You roughly need to build and deploy a working project.
• Use of Generative AI tools (ChatGPT, Copilot, Gemini, etc.) or copied project from
Github or any other external source is not authorized.
• A short report is required. The report should explain the important part of your work
and must include browser screenshots showing the completion of each exercise
(not code screenshots).
Project implementation Information:
• Your Maven project:
o Group ID: fr.univtours.polytech
o Artifact ID / Project name: tpeval
• You must strictly follow the MVC pattern:
o Servlets → Controller
o JavaBeans/EJBs → Model
o JSP/JSTL → View
Business Scenario:
Each Book has the following attributes:
• Id/ISBN (String)
• title (String)
• author (String)
• available Copies (int)
• description (String)
Pricing for Book Reservations: Physical book reservation: €10 per month per book, and for
PDF/online book reservation: €5 per month per book. Note: Limits on PDF/online book copies simulate
digital licensing restrictions, ensuring controlled access like physical books.
A user can borrow (reserve) a book, which decreases its available copies by one. Borrowed
books are stored in the user session. The user can view, return, and finalize their borrowed
list.
Note: For the above book information/attributes as you need, you can choose any arbitrary
book information from Amazon or any other online sources.
Example Books:
- ISBN: "1234567890", Title: "Java Programming", Author: "John Doe", Available Copies: 3, Description: "A guide to Java",
Format: "physical"
- ISBN: "0987654321", Title: "Web Development", Author: "Jane Smith", Available Copies: 2, Description: "Learn web
basics", Format: "online"
You may hardcode the sample book data in the CatalogServlet (Controller) or initialize it in
a helper JavaBean class such as Library.
REQUIRED COMPONENTS
Servlets (Controllers):
• CatalogServlet — displays the book catalog
• BorrowServlet — handles book reservations and returns
• CheckoutServlet — handles the checkout page and business rules
JavaBeans (Models):
• Book — represents a book entity
• BorrowedList — maintains a list of borrowed books
• (Optional) Library — manages the in-memory collection of available books
JSP Pages (Views):
• index.jsp — homepage
• catalog.jsp — displays available books
• borrowed.jsp — displays borrowed books list
• checkout.jsp — final checkout/summary page
Suggested URL Endpoints
/tpeval/
/tpeval/catalog
/tpeval/reserve
/tpeval/borrowed
/tpeval/return
/tpeval/checkout
EXERCISES
Exercise 1 — Display the Book Catalog
Create the Book JavaBean and CatalogServlet.
Tasks:
• In the servlet, instantiate a list of 3–5 sample books.
• Forward the list to catalog.jsp.
• Display the books using JSTL <c:forEach> tag.
• Add a “Borrow” button for each book.
Deliverable:
http://localhost:8080/tpeval/catalog displays the catalog with reserve buttons.
Exercise 2 — Session Handling and Model Logic
Create a BorrowedList bean to manage reserved books stored in the session.
Tasks:
• Use HttpSession to maintain a per-user borrowed list.
• When a book is reserved, decrease its availableCopies by 1.
• Prevent reservations when availableCopies == 0.
Deliverable:
Borrowed books persist during navigation.
Exercise 3 — Borrowed Books Page
Create the BorrowServlet and borrowed.jsp.
Tasks:
• Handle /reserve and /return (POST) actions.
• /borrowed displays the list of borrowed books.
• Add a “Return” button for each borrowed book.
Deliverable:
http://localhost:8080/tpeval/borrowed shows the current borrowed books.
Exercise 4 — Checkout Page (Business Logic)
Create the CheckoutServlet and checkout.jsp.
Tasks:
• Retrieve the borrowed list from session.
• If the user has borrowed more than 2 books, display an error message.
• Otherwise, display a summary of borrowed books including the total monthly cost
according to the format (10 € for physical, 5 € for online). If the user borrows 1
physical book (€10) and 1 online book (€5), the checkout page should display a total
monthly cost of €15.
• After checkout confirmation, clear the session.
Deliverable:
http://localhost:8080/tpeval/checkout shows the summary and clears the session.
Exercise 5 — Short Report
Preparing a short PDF report including:
• Description of essential parts of your MVC design &/or related Java EE components.
• One browser screenshot per exercise (catalog, borrowed, checkout)
• An additional screenshot demonstrating full functionality (e.g., a sequence of
actions across all pages).
