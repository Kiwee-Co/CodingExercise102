package exercise.coding102.kiwee.hashing;

import java.util.List;

import exercise.coding102.kiwee.shared.item.Book;

public class Hashing {

    public static void main(String[] args) {
        var booklist = List.of(
                new Book("Peppa Pig", "How to jump in the muddy puddles!"),
                new Book("George", "Dinasour!!"),
                new Book("Elsa", "Why does cold not bother me?"),
                new Book("Anna", "Build snowman 1-2-3"),
                new Book("Nemo's Dad", "Guidebook of Pacific Ocean"),
                new Book("Willy Wonka", "Secret Recipe of Oompa Loompa's Purple Chocolate"));

        for (var b: booklist) {
            System.out.println("book name: " + b.getBookName() + " hash: " + hashCode(b, 3));
        }
        
        for (var b: booklist) {
            System.out.println("book name: " + b.getBookName() + " hash: " + hashCode(b, 37));
        }

    }

    public static int hashCode(Book book, int hashSize) {
        int hash = 0;

        for (char c : book.getAuthor().toCharArray()) {
            hash = (hash * 31 + c) % hashSize;
        }

        return hash;
    }
}
