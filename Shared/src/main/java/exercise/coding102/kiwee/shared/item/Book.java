package exercise.coding102.kiwee.shared.item;

public class Book extends Media {

    public Book(String author, String title) {
        super(author, title);
    }

    public String getBookName() {
        return super.getTitle();
    }
    
    public String getAuthor() {
        return super.getAuthor();
    }
}
