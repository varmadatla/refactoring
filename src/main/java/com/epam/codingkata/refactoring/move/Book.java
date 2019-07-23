package com.epam.codingkata.refactoring.move;

public class Book {
    private String name;
    private String author;
    private String content;

    public boolean contains(String word){
        return content.contains(word);
    }

    public String getAuthor(){
        return author;
    }

    public String exportToPDF(){
        String pdf = convertToPDF();
    }

    public String getName() {
        return name;
    }

    public void sendContentTo(String email){
        // send content to email.
    }

    private String convertToPDF(){
        return content;
    }
}
