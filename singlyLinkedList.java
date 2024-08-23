import java.util.Iterator;

public class singlyLinkedList<T> implements Iterable<T>{

    private int size = 0;
    private Node<T> head = null;
    private Node<T> tail = null;

    public class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString(){
            return data.toString();
        }
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public void addAtFront(T element){
        if(isEmpty()){
            head = tail = new Node<T>(element, null);
        } else{
            Node<T> newNode = new Node<>(element, head);
            head = newNode;
        }
        size++;
    }

    public void addAtEnd(T element){
        if(isEmpty()){
            head = tail = new Node<>(element, null);
        } else{
            Node<T> newNode = new Node<>(element, null);
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void addAt(T element, int position) throws Exception{
        if (position > size || position < 0) {
            throw new Exception("ILLEGAL ADDRESS");
        }
        if(position == 0){
            addAtFront(element);
            return;
        }
        if(position == size){
            addAtEnd(element);
        }
        Node<T> temp = head;
        for(int i = 0; i < position-1; i++){
            temp = temp.next;
        }
        Node<T> newNode = new Node<>(element, temp.next);
        temp.next = newNode;
        size++;
    }

    public T deleteAtFront(){
        if(isEmpty()){
            throw new RuntimeException("Empty List");
        }
        T data = head.data;
        head = head.next;
        --size;

        if(isEmpty()){
            tail = null;
        }

        return data;
    }

    public T deleteAtEnd(){
        if(isEmpty()){
            throw new RuntimeException("Empty List");
        }
        if(head.next == null){
            T data = head.data;
            head = tail = null;
            --size;
            return data;
        }
        Node<T> curr = head;
        while(curr.next != tail){
            curr = curr.next;
        }
        T data = tail.data;
        tail = curr;
        tail.next = null;
        --size;
        return data;
    }

    public T deleteAtPos(int pos){
        if(isEmpty()){
            throw new RuntimeException("Empty List");
        }
        if(pos < 0 || pos > size){
            throw new RuntimeException("ILLEGAL ADDRESS");
        }
        if(pos == 0){
            return deleteAtFront();
        }
        if(pos == size-1){
            return deleteAtEnd();
        }
        Node<T> temp = head;
        for(int i = 0; i < pos-1; i++){
            temp = temp.next;
        }
        T curr = temp.next.data;
        temp.next = temp.next.next;
        --size;
        return curr;
    }

    public T deleteAtFromEnd(int pos){
        if(isEmpty()){
            throw new RuntimeException("Empty List");
        }
        if(pos < 0 || pos > size){
            throw new RuntimeException("ILLEGAL ADDRESS");
        }
        if(pos == 0 || pos == 1){
            return deleteAtEnd();
        }
        if(pos == size - 1 || pos == size){
            return deleteAtFront();
        }

        Node<T> fast, slow;
        fast = slow = head;
        while(pos-- > 0 ){
            fast = fast.next;
        }
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        T data = slow.next.data;
        slow.next = slow.next.next;
        --size;
        return data;
    }

    public void deleteAllOccurence(T element){
        while(head != null && head.data == element){
            head = head.next;
        }
        Node<T> temp = head;
        while(temp != null && temp.next != null){
            if(temp.next.data == element){
                temp.next = temp.next.next;
            } else{
                temp = temp.next;
            }
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> trav = head;
            @Override
            public boolean hasNext() {
                return trav != null;
            }

            @Override
            public T next() {
                T data = trav.data;
                trav = trav.next;
                return data;
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        Node<T> trav = head;
        while (trav != null) {
            sb.append(trav.data);
            if (trav.next != null) {
                sb.append(", ");
            }
            trav = trav.next;
        }
        sb.append(" ]");
        return sb.toString();
    }
}
