public class singlyLnkdListImpl {

    public static void main(String[] args) {
        singlyLinkedList<Integer> singlyList = new singlyLinkedList<>();
        singlyList.addAtFront(25);
        singlyList.addAtFront(26);
        singlyList.addAtFront(27);
        singlyList.addAtFront(28);
        for(Integer item : singlyList){
            System.out.print(item + ", ");
        }
        System.out.println();
        System.out.println(singlyList.deleteAtEnd());
        for(Integer item : singlyList){
            System.out.print(item + ", ");
        }
    }
}
