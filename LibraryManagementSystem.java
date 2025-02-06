import java.util.Scanner;

public class LibraryManagementSystem {
    private static Scanner scanner = new Scanner(System.in);
    private static Library library;

    public static void main(String[] args) {
        library = new Library();

        System.out.println("Welcome to the Digital Library Management System");
        System.out.println("-----------------------------------------------");

        boolean quit = false;

        while (!quit) {
            System.out.println("\nMenu");
            System.out.println("------------------");
            System.out.println("1. Admin Module");
            System.out.println("2. User Module");
            System.out.println("3. Quit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    adminModule();
                    break;
                case 2:
                    userModule();
                    break;
                case 3:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("Thank you for using the Digital Library Management System. Goodbye!");
    }

    private static void adminModule() {
        System.out.println("\nAdmin Module");
        System.out.println("------------------");

        System.out.print("Enter admin username: ");
        String adminUsername = scanner.nextLine();
        System.out.print("Enter admin password: ");
        String adminPassword = scanner.nextLine();

        if (library.authenticateAdmin(adminUsername, adminPassword)) {
            boolean quit = false;

            while (!quit) {
                System.out.println("\nAdmin Menu");
                System.out.println("------------------");
                System.out.println("1. Add Book");
                System.out.println("2. Remove Book");
                System.out.println("3. Update Book Details");
                System.out.println("4. Add Member");
                System.out.println("5. Remove Member");
                System.out.println("6. Update Member Details");
                System.out.println("7. Quit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                switch (choice) {
                    case 1:
                        addBook();
                        break;
                    case 2:
                        removeBook();
                        break;
                    case 3:
                        updateBookDetails();
                        break;
                    case 4:
                        addMember();
                        break;
                    case 5:
                        removeMember();
                        break;
                    case 6:
                        updateMemberDetails();
                        break;
                    case 7:
                        quit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } else {
            System.out.println("Invalid admin username or password. Access denied.");
        }
    }

    private static void userModule() {
        System.out.println("\nUser Module");
        System.out.println("------------------");

        boolean quit = false;

        while (!quit) {
            System.out.println("\nUser Menu");
            System.out.println("------------------");
            System.out.println("1. View Books");
            System.out.println("2. Search Book");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Contact Us");
            System.out.println("6. Quit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    viewBooks();
                    break;
                case 2:
                    searchBook();
                    break;
                case 3:
                    issueBook();
                    break;
                case 4:
                    returnBook();
                    break;
                case 5:
                    contactUs();
                    break;
                case 6:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addBook() {
        System.out.println("\nAdd Book");
        System.out.println("------------------");

        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();
        System.out.print("Enter book category: ");
        String category = scanner.nextLine();

        Book newBook = new Book(title, author, category);
        library.addBook(newBook);

        System.out.println("Book added successfully.");
    }

    private static void removeBook() {
        System.out.println("\nRemove Book");
        System.out.println("------------------");

        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();

        Book book = library.searchBook(title, author);

        if (book != null) {
            library.removeBook(book);
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    private static void updateBookDetails() {
        System.out.println("\nUpdate Book Details");
        System.out.println("------------------");

        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();

        Book book = library.searchBook(title, author);

        if (book != null) {
            System.out.print("Enter new title: ");
            String newTitle = scanner.nextLine();
            System.out.print("Enter new author: ");
            String newAuthor = scanner.nextLine();
            System.out.print("Enter new category: ");
            String newCategory = scanner.nextLine();

            book.setTitle(newTitle);
            book.setAuthor(newAuthor);
            book.setCategory(newCategory);

            System.out.println("Book details updated successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    private static void addMember() {
        System.out.println("\nAdd Member");
        System.out.println("------------------");

        System.out.print("Enter member name: ");
        String name = scanner.nextLine();
        System.out.print("Enter member email: ");
        String email = scanner.nextLine();

        Member newMember = new Member(name, email);
        library.addMember(newMember);

        System.out.println("Member added successfully.");
    }

    private static void removeMember() {
        System.out.println("\nRemove Member");
        System.out.println("------------------");

        System.out.print("Enter member name: ");
        String name = scanner.nextLine();
        System.out.print("Enter member email: ");
        String email = scanner.nextLine();

        Member member = library.searchMember(name, email);

        if (member != null) {
            library.removeMember(member);
            System.out.println("Member removed successfully.");
        } else {
            System.out.println("Member not found.");
        }
    }

    private static void updateMemberDetails() {
        System.out.println("\nUpdate Member Details");
        System.out.println("------------------");

        System.out.print("Enter member name: ");
        String name = scanner.nextLine();
        System.out.print("Enter member email: ");
        String email = scanner.nextLine();

        Member member = library.searchMember(name, email);

        if (member != null) {
            System.out.print("Enter new name: ");
            String newName = scanner.nextLine();
            System.out.print("Enter new email: ");
            String newEmail = scanner.nextLine();

            member.setName(newName);
            member.setEmail(newEmail);

            System.out.println("Member details updated successfully.");
        } else {
            System.out.println("Member not found.");
        }
    }

    private static void viewBooks() {
        System.out.println("\nView Books");
        System.out.println("------------------");

        System.out.println("Books available in the library:");
        Book[] books = library.getBooks();

        if (books.length > 0) {
            for (Book book : books) {
                System.out.println(book);
            }
        } else {
            System.out.println("No books available in the library.");
        }
    }

    private static void searchBook() {
        System.out.println("\nSearch Book");
        System.out.println("------------------");

        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();

        Book book = library.searchBook(title, author);

        if (book != null) {
            System.out.println("Book details:");
            System.out.println(book);
        } else {
            System.out.println("Book not found.");
        }
    }

    private static void issueBook() {
        System.out.println("\nIssue Book");
        System.out.println("------------------");

        System.out.print("Enter member name: ");
        String name = scanner.nextLine();
        System.out.print("Enter member email: ");
        String email = scanner.nextLine();

        Member member = library.searchMember(name, email);

        if (member != null) {
            System.out.print("Enter book title: ");
            String title = scanner.nextLine();
            System.out.print("Enter book author: ");
            String author = scanner.nextLine();

            Book book = library.searchBook(title, author);

            if (book != null) {
                if (library.issueBook(member, book)) {
                    System.out.println("Book issued successfully.");
                } else {
                    System.out.println("Book is not available for issuing.");
                }
            } else {
                System.out.println("Book not found.");
            }
        } else {
            System.out.println("Member not found.");
        }
    }

    private static void returnBook() {
        System.out.println("\nReturn Book");
        System.out.println("------------------");

        System.out.print("Enter member name: ");
        String name = scanner.nextLine();
        System.out.print("Enter member email: ");
        String email = scanner.nextLine();

        Member member = library.searchMember(name, email);

        if (member != null) {
            System.out.print("Enter book title: ");
            String title = scanner.nextLine();
            System.out.print("Enter book author: ");
            String author = scanner.nextLine();

            Book book = library.searchBook(title, author);

            if (book != null) {
                if (library.returnBook(member, book)) {
                    System.out.println("Book returned successfully.");
                } else {
                    System.out.println("Book was not issued to the member.");
                }
            } else {
                System.out.println("Book not found.");
            }
        } else {
            System.out.println("Member not found.");
        }
    }

    private static void contactUs() {
        System.out.println("\nContact Us");
        System.out.println("------------------");

        System.out.println("For any queries or assistance, please send an email to library@example.com");
    }
}

class Library {
    private static final int MAX_BOOKS = 100;
    private static final int MAX_MEMBERS = 100;

    private Book[] books;
    private Member[] members;
    private Admin admin;

    public Library() {
        this.books = new Book[MAX_BOOKS];
        this.members = new Member[MAX_MEMBERS];
        this.admin = new Admin("admin", "admin123");
    }

    public boolean authenticateAdmin(String username, String password) {
        return admin.getUsername().equals(username) && admin.getPassword().equals(password);
    }

    public void addBook(Book book) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                books[i] = book;
                break;
            }
        }
    }

    public void removeBook(Book book) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] == book) {
                books[i] = null;
                break;
            }
        }
    }

    public void addMember(Member member) {
        for (int i = 0; i < members.length; i++) {
            if (members[i] == null) {
                members[i] = member;
                break;
            }
        }
    }

    public void removeMember(Member member) {
        for (int i = 0; i < members.length; i++) {
            if (members[i] == member) {
                members[i] = null;
                break;
            }
        }
    }

    public Book searchBook(String title, String author) {
        for (Book book : books) {
            if (book != null && book.getTitle().equalsIgnoreCase(title) && book.getAuthor().equalsIgnoreCase(author)) {
                return book;
            }
        }
        return null;
    }

    public Member searchMember(String name, String email) {
        for (Member member : members) {
            if (member != null && member.getName().equalsIgnoreCase(name) && member.getEmail().equalsIgnoreCase(email)) {
                return member;
            }
        }
        return null;
    }

    public Book[] getBooks() {
        return books;
    }

    public boolean issueBook(Member member, Book book) {
        if (book.isAvailable()) {
            book.setAvailable(false);
            member.issueBook(book);
            return true;
        }
        return false;
    }

    public boolean returnBook(Member member, Book book) {
        if (member.hasBook(book)) {
            book.setAvailable(true);
            member.returnBook(book);
            return true;
        }
        return false;
    }
}

class Book {
    private String title;
    private String author;
    private String category;
    private boolean available;

    public Book(String title, String author, String category) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.available = true;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Category: " + category + ", Available: " + available;
    }
}

class Member {
    private String name;
    private String email;
    private Book[] issuedBooks;

    public Member(String name, String email) {
        this.name = name;
        this.email = email;
        this.issuedBooks = new Book[5];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
       this.email = email;
    }

    public void issueBook(Book book) {
        for (int i = 0; i < issuedBooks.length; i++) {
            if (issuedBooks[i] == null) {
                issuedBooks[i] = book;
                break;
            }
        }
    }

    public void returnBook(Book book) {
        for (int i = 0; i < issuedBooks.length; i++) {
            if (issuedBooks[i] == book) {
                issuedBooks[i] = null;
                break;
            }
        }
    }

    public boolean hasBook(Book book) {
        for (Book issuedBook : issuedBooks) {
            if (issuedBook == book) {
                return true;
            }
        }
        return false;
    }
}

class Admin {
    private String username;
    private String password;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
