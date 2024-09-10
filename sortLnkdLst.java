public class sortLnkdLst {

    int size = 0;
    Node head = null;
    public static class Node{
        int data;
        Node next;
        public Node(){}
        public Node(int data){
            this.data = data;
        }
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public void add(int element){
        if(isEmpty()){
            head = new Node(element);
        } else{
            Node newNode = new Node(element);
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
        size++;
    }

    public void sortList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        boolean swapped;
        do {
            swapped = false;
            Node ptr1 = head;

            while (ptr1.next != null) {
                Node ptr2 = ptr1.next;
                if (ptr1.data > ptr2.data) {
                    int temp = ptr1.data;
                    ptr1.data = ptr2.data;
                    ptr2.data = temp;
                    swapped = true;
                }
                ptr1 = ptr1.next;
            }
        } while (swapped);

        // Print sorted list
        printList();
    }

    private void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + (temp.next != null ? ", " : ""));
            temp = temp.next;
        }
        System.out.println(); // New line after printing the list
    }

    public void swap(int num1, int num2){
        int temp = num1;
        num1 = num2;
        num2 = temp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        Node temp = head;
        while (temp != null) {
            sb.append(temp.data);
            if (temp.next != null) {
                sb.append(", ");
            }
            temp = temp.next;
        }
        sb.append(" ]");
        return sb.toString();
    }

    public static void main(String[] args) {
        sortLnkdLst lst = new sortLnkdLst();
        lst.add(5);
        lst.add(4);
        lst.add(3);
        lst.add(2);
        lst.add(1);
        lst.sortList();
    }
}
