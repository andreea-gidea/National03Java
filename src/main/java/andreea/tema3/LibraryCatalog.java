package andreea.tema3;

import java.util.ArrayList;
import java.util.List;

public class LibraryCatalog {
    private List<Book> books = new ArrayList<>();//generez lista goala

    public LibraryCatalog() {//costructor pt a face instanta pe obiect
    }

    public List<Book> getBooks() {//ma ajuta sa imi iau ce am creat in lista
        return books;
    }

    public void setBooks(List<Book> books) {//setez lista initiala
        this.books = books;
    }

    public void addBook(Book book) {//adaug in lista
        books.add(book);
        System.out.println("Book added " + book.toString());

    }

//    public void deleteBook(Book book) {//sterg din lista
//        if (books.contains(book)) {
//            books.remove(book);
//            System.out.println("Book deleted " + book.toString());
//        } else
//            System.out.println("Book not existent");
//    }

    public Book findByName(String name) {//cautare in lista de carti
        for (Book book : books) {
            if (name.equals(book.getName())) {
                return book;
            }
        }
        return null;
    }

    public void deleteByName(String name) {
        Book bookToBeDeleted = null;
        for (Book book : books) {
            if (name.equals(book.getName())) {
                bookToBeDeleted = book;

            }
        }
        if (bookToBeDeleted != null) {
            books.remove(bookToBeDeleted);
            System.out.println("Book deleted"+bookToBeDeleted);
        }
        else {
            System.out.println("Book not foud");
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("LibraryCatalog{");
        for (Book book : books) {
            result.append(book.toString());
        }
        result.append("}");
        return result.toString();
    }
}
