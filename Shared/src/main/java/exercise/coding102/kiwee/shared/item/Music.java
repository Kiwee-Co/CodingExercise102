package exercise.coding102.kiwee.shared.item;

public class Music extends Media {

    public Music(String artist, String song) {
        super(artist, song);
    }

    public String getSong() {
        return getTitle();
    }

    public String getArtist() {
        return getAuthor();
    }

}
