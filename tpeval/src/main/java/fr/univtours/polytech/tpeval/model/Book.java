package fr.univtours.polytech.tpeval.model;

public class Book {
    private String ISBN;
    private String title;
    private String author;
    private Integer available_copies;
    private String description;
    private String format;

    public Book(String isbn, String ttl, String a, Integer copies, String desc, String form) {
        ISBN = isbn;
        title = ttl;
        author = a;
        available_copies = copies;
        description = desc;
        format = form;
    }

    public String getIsbn() { return ISBN; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public Integer getAvailableCopies() { return available_copies; }
    public String getDescription() { return description; }
    public String getFormat() { return format; }

    public void setIsbn(String isbn) { ISBN = isbn; }
    public void setTitle(String ttl) { title = ttl; }
    public void setAuthor(String a) { author = a; }
    public void setAvailableCopies(Integer copies) { available_copies = copies; }
    public void setDescription(String desc) { description = desc; }
    public void setFormat(String from) { format = from; }
}