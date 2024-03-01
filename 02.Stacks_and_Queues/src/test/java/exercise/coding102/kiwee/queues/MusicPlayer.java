package exercise.coding102.kiwee.queues;

import java.util.Collection;
import java.util.List;
import java.util.Queue;

import exercise.coding102.kiwee.shared.item.Music;

public class MusicPlayer {

    MusicPlayer(String owner) {
        this.owner = owner;
        playlist = new LinkedQueue<>();
    }

    private String owner;
    private Queue<Music> playlist;

    String getOwner() {
        return owner;
    }

    void addSongs(Collection<Music> collection) {
        playlist.addAll(collection);
    }

    void addSongs(Music... musics) {
        addSongs(List.of(musics));
    }

    Music getCurrentSong() {
        if (playlist == null || playlist.isEmpty()) {
            return null;
        }

        return playlist.peek();
    }

    Music next() {
        if (playlist == null || playlist.isEmpty()) {
            return null;
        }

        playlist.poll();

        return getCurrentSong();
    }

    void addSong(Music music) {
        playlist.add(music);
    }

}
