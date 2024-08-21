public class doublyLinkedListImpl {

    public static void main(String[] args) throws Exception {
        doublyLinkedList<Integer> dll = new doublyLinkedList<>();
        dll.add(1);
        dll.add(2);
        dll.add(3);
        System.out.println(dll);
        dll.addFirst(4);
        System.out.println(dll);
        dll.addAt(5, 3);
        System.out.println(dll);
        dll.addAt(6, 5);
        System.out.println(dll);
        dll.removeAt(3);
        System.out.println(dll);

    }
}
