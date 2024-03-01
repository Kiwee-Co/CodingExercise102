package exercise.coding102.kiwee.queues;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Queue;

import org.junit.jupiter.api.Test;

import exercise.coding102.kiwee.shared.item.Music;

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

        player.addSongs(peppa, babyShark, bus);

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

}
