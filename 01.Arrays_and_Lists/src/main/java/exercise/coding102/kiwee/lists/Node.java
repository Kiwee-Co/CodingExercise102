package exercise.coding102.kiwee.lists;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Node<E> {

    private E item;
    private Node<E> next;

    public Node(E item) {
        this.item = item;
        this.next = null;
    }

    public Node(E item, Node<E> next) {
        this.item = item;
        this.next = next;
    }

    public Node<E> next() {
        return next;
    }

    public E getItem() {
        return item;
    }

    public void setItem(E item) {
        this.item = item;
    }

    public Node<E> withItem(E item) {
        this.setItem(item);
        return this;
    }

    public Node<E> withNext(Node<E> next) {
        this.setNext(next);
        return this;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }
    
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).append("item", item).toString();
    }
}