package exercise.coding102.kiwee.hashing;

import java.util.function.Function;

import exercise.coding102.kiwee.shared.item.Book;

public class HashingFunction {
    private final int tableSize;

    private Function<String, Integer> myFunc;

    public HashingFunction(Function<String, Integer> myFunc, int tableSize) {
        this.tableSize = tableSize;
        this.myFunc = myFunc;
    }

    public HashingFunction(int tableSize) {
        this(key -> key.chars().reduce(0, (h, c) -> (h * 31 + c) % tableSize), tableSize);
    }

    public int hash(String key) {
        return myFunc.apply(key).intValue();
    }

    public int bookhash(Book book) {
        return (myFunc.apply(book.getAuthor()) + myFunc.apply(book.getBookName())) % tableSize;
    }

    public int getTableSize() {
        return tableSize;
    }
}
