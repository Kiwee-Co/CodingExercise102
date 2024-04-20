package exercise.coding102.kiwee.shared.item;

import java.util.Objects;

abstract class Media {
    private String author;
    private String title;

    Media(String author, String title) {
        this.author = author;
        this.title = title;
    }

    protected String getAuthor() {
        return this.author;
    }

    protected String getTitle() {
        return this.title;
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, title);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }
        
        Media other = (Media) obj;
        return Objects.equals(author, other.author) && Objects.equals(title, other.title);
    }
}
