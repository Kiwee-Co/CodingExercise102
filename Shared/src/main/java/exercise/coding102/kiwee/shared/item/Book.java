package exercise.coding102.kiwee.shared.item;

public class Book extends Media {

    public Book(String author, String title) {
        super(author, title);
    }

    public String getBookName() {
        return this.getTitle();
    }
    
    public String getAuthor() {
        return this.getAuthor();
    }
}
