/**
 * Created With IntelliJ IDEA.
 * Description:
 * User:ZouSS
 * Date:2020-08-07
 * Time:8:58
 **/
class Node{
    private Node next;
    private int data;
    public Node(int data){
        this.data = data;
        this.next = null;
    }
    public void setNext(Node next){
        this.next = next;
    }
    public Node getNext(){
        return next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

}

public class TestDemo {
    public Node head;
    public void addLast(int data){
        Node node  = new Node(data);
        if (this.head == null){
            this.head = node;
            return;
        }
        Node cur = this.head;
        while(cur.getNext() != null){
            cur = cur.getNext();
        }
        cur.setNext(node);
    }
    public Node findPrev(int key){
        Node prev = this.head;
        while(prev.getNext() != null){
            if (prev.getNext().getData() == key){
                return prev;
            }
            prev = prev.getNext();
        }
        return null;
    }
    public void remove(int key){
        if (this.head.getData() == key){
            this.head = this.head.getNext();
            return;
        }
        Node prev = findPrev(key);
        if (prev == null){
            return;
        }
        Node del = prev.getNext();
        prev.setNext(del.getNext());
    }
    public void addFirst(int data){
        Node node = new Node(data);
        if (this.head == null){
            this.head = node;
            return;
        }
        node.setNext(head);
        this.head = node;
    }
    public void display(){
        Node cur = this.head;
        while(cur != null){
            System.out.print(cur.getData()+" ");
            cur = cur.getNext();
        }
    }

    public static void main(String[] args) {
        TestDemo testDemo = new TestDemo();
        testDemo.addLast(12);
        testDemo.addLast(45);
        testDemo.addLast(78);
        testDemo.display();
        System.out.println();
        testDemo.remove(12);
        testDemo.display();
    }
}
