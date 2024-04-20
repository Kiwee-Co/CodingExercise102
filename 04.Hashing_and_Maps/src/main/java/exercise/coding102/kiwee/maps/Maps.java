package exercise.coding102.kiwee.maps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import exercise.coding102.kiwee.shared.item.Music;

public class Maps {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        var peppa = new Music("Peppa Pig", "Bing Bong Song");
        var babyShark = new Music("Pinkfong", "Baby Shark");
        var bus = new Music("Raffi    ", "Wheels on the Bus");
        var letgo = new Music("Idina Menzel", "Let It Go");

        List<Music> songs = List.<Music>of(peppa, babyShark, bus, letgo);

        System.out.println("\nHashmap: ");
        traverseMap(new HashMap<String, Music>(), songs);

        System.out.println("\nTreemap: ");
        traverseMap(new TreeMap<String, Music>(), songs);
    }


    static void traverseMap(Map<String, Music> library, List<Music> songs) {

        for (var song : songs) {
            library.put(song.getArtist(), song);
        }

        for (var entry : library.entrySet()) {
            System.out.println("singer: "+ entry.getKey() + "\t\tsong: " + entry.getValue().getSong());
        }

    }
}
