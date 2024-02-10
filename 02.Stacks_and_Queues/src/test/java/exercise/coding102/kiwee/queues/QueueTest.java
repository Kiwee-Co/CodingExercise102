package exercise.coding102.kiwee.queues;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collection;
import java.util.List;
import java.util.Queue;

import org.junit.jupiter.api.Test;

public class QueueTest {

    @Test
    void testQueue() {
        Queue<String> queue = new LinkedQueue<>();

        queue.add("Raymond");
        queue.add("Sahana");
        queue.add("Melody");

        assertEquals("foo", queue.poll());
        assertEquals("bar", queue.peek());

        queue.add("Remi");

        assertEquals("", queue.poll());
        assertEquals("", queue.poll());

        queue.add("Evelyn");

        assertEquals("", queue.poll());

        assertEquals(3, queue.size());
    }

    @Test
    void testMusicPlayerQueue() {
        MusicPlayer player = new MusicPlayer("Peppa Pig");
        
        var peppa = new Music("Peppa Pig", "Bing Bong Song");
        var babyShark = new Music("Pinkfong", "Baby Shark");
        var bus = new Music("Raffi", "Wheels on the Bus");
        var letgo = new Music("Idina Menzel", "Let It Go");
        
        player.addSongs(peppa, babyShark,bus);
        
        assertEquals("", player.getCurrentSong().getSong());
        assertEquals("", player.next().getSong());
        
        player.addSong(letgo);
        
        assertEquals("", player.next().getArtist());
        assertEquals("", player.next().getSong());

        
        // girls, that's what happened in your road trip!
        player.addSong(letgo);
        player.addSong(letgo);
        player.addSong(letgo);

        assertEquals("", player.next().getSong());
        assertEquals("", player.next().getSong());
        assertEquals("", player.next().getSong());
        
    }

    class MusicPlayer {
        
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
        
        void addSongs(Music...musics) {
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
    
    class Music {
        String song;
        String artist;

        Music(String artist, String song) {
            this.song = song;
            this.artist = artist;
        }

        String getSong() {
            return song;
        }

        String getArtist() {
            return artist;
        }

    }

}
