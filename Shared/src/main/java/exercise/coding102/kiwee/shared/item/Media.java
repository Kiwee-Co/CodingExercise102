package exercise.coding102.kiwee.shared.item;

abstract class Media {
    private String author;
    private String title;
    
    Media(String author, String title) {
        this.author = author;
        this.title= title;
    }

    protected String getAuthor() {
        return this.author;
    }
    
    protected String getTitle() {
        return this.title;
    }
    
}
