import java.util.Iterator;

public class doublyLinkedList<T> implements Iterable<T> {

    private int size = 0;
    private Node<T> head = null;
    private Node<T> tail = null;

    public static class Node<T>{
        private T data;
        private Node<T> prev, next;

        public Node(T data, Node<T> prev, Node<T> next){
            this.data = data;
            this.next = next;
            this.prev = prev;
        }

        @Override
        public String toString(){
            return data.toString();
        }
    }

    public int size(){
        return size;
    }

    public void clear(){
        Node<T> curr = head;
        while (curr != null) {
            Node<T> next = curr.next;
            curr.prev = curr.next = null;
            curr.data = null;
            curr = next;
        }
        head = tail = curr = null;
        size = 0;
    }

    public boolean isEmpty(){
        return size()==0;
    }

    public void add(T element){
        addLast(element);
    }

    public void addLast(T element){
        if(isEmpty()){
            head = tail = new Node<>(element, null, null);
        } else{
            tail.next = new Node<>(element, tail, null);
            tail = tail.next;
        }
        size++;
    }

    public void addFirst(T element){
        if(isEmpty()){
            Node<T> node = new Node<>(element, null, null);
            head = node;
            tail = null;
        } else{
            head.prev = new Node<>(element, null, head);
            head = head.prev;
        }
        size++;
    }

    public void addAt(T element, int position) throws Exception{
        if(position > size || position < 0){
            throw new Exception("ILLEGAL POSITION");
        }
        if(position == 0){
            addFirst(element);
            return;
        }
        if(position == size){
            addLast(element);
            return;
        }
        Node<T> temp = head;
        int i = 0;
        while(i < position-1){
            temp = temp.next;
            i++;
        }
        Node<T> newNode = new Node<>(element, temp, temp.next);
        temp.next.prev = newNode;
        temp.next = newNode;
        size++;
    }

    public T peekFirst(){
        if(isEmpty()) throw new RuntimeException("Empty List");
        return head.data;
    }

    public T peekLast(){
        if(isEmpty()) throw new RuntimeException("Empty List");
        return tail.data;
    }

    public T removeFirst(){
        if(isEmpty()){
            throw new RuntimeException("Empty List");
        }

        T data = head.data;
        head = head.next;
        size--;
        if(isEmpty()){
            tail = null;
        } else{
            head.prev = null;
        }
        return data;
    }

    public T removeLast(){
        if(isEmpty()){
            throw new RuntimeException("Empty List");
        }
        T data = tail.data;
        tail = tail.prev;
        size--;
        if(isEmpty()){
            head = null;
        } else{
            tail.next = null;
        }
        return data;
    }

    public T remove(Node<T> node){
        if(node.prev == null) return removeFirst();
        if(node.next == null) return removeLast();

        node.next.prev = node.prev;
        node.prev.next = node.next;

        T data = node.data;

        node.data = null;
        node = node.prev = node.next = null;

        --size;

        return data;
    }

    public T removeAt(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException();
        }
        int i;
        Node<T> temp;
        if(index < size/2) {
            for (i = 0, temp = head; i != index; i++) {
                temp = temp.next;
            }
        }else{
            for(i = size-1, temp = tail; i != index; i--){
                temp = temp.prev;
            }
        }
        return remove(temp);
    }

    public T removeAtFromEnd(int position){
        if(position < 0 || position >= size){
            throw new IllegalArgumentException();
        }
        Node<T> fast = head;
        Node<T> slow = head;
        //position = position-1;
        while(position-- > 0){
            fast = fast.next;
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        if(slow.prev == null) return removeFirst();
        if(slow.next == null) return removeLast();
        T data = slow.data;
        slow.prev.next = slow.next;
        slow.next.prev = slow.prev;
        --size;
        return data;
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
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

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
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
