package Model;

import java.util.Set;

public class Book {

    private String name;
    private String isbn;
    private int pageAmount;


    public Book(String name, String isbn, int pageAmount) {
        this.name = name;
        this.isbn = isbn;
        this.pageAmount = pageAmount;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPageAmount() {
        return pageAmount;
    }

    public void setPageAmount(int pageAmount) {
        this.pageAmount = pageAmount;
    }


}
