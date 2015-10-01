import java.util.NoSuchElementException;

public class MyLinkedList<E> {
  private MyNode head;
  private MyNode tail;
  private MyNode current;
  private int size;

  public MyLinkedList() {
    head = null;
    tail = null;
    size = 0;
    current = null;
  }

  public boolean empty() {
    return head == null;
  }

  public void insert(E value) {
    MyNode<E> newNode = new MyNode<E>(value);

    if (head == null) {
      current = newNode;
      tail = newNode;
      head = newNode;
    } else {
      tail.setNext(newNode);
      tail = newNode;
    }

    size++;
  }

  public E deleteFirst() {
    if (head != null) {
      MyNode<E> firstNode = head;
      head = head.getNext();
      current = current.getNext();
      return firstNode.getValue();
    } else {
      System.out.println("List is empty!");
      return null;
    }
  }

  public E deleteLast() {
    MyNode<E> lastNode;
    current = head;

    if (head != null) {
      if(current.getNext() != null) {
        while (current.getNext().getNext() != null)
          current = current.getNext();
        lastNode = current.getNext();
        tail = current;
        current.setNext(null);
        current = head;
      } else {
        lastNode = current;
        tail = null;
        head = null;
        current = null;
      };

      size--;
      return lastNode.getValue();
    } else {
      System.out.println("List is empty!");
      return null;
    }
  }
  public int getSize() {
    return size;
  }

  public void clear(){
      tail = null;
      head = null;
      current = null;
  }
}
