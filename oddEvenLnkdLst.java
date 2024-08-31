/*Leetcode odd even linkedlist*/
public class oddEvenLnkdLst {

    int size = 0;
    ListNode head = null;
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){ this.val = val;}
        ListNode(int val, ListNode next){ this.val = val; this.next = next;}
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public void add(int element){
        if(isEmpty()){
            head = new ListNode(element, null);
        } else{
            ListNode newNode = new ListNode(element, null);
            ListNode temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
        size++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        ListNode temp = head;
        while (temp != null) {
            sb.append(temp.val);
            if (temp.next != null) {
                sb.append(", ");
            }
            temp = temp.next;
        }
        sb.append(" ]");
        return sb.toString();
    }

    public void oddEven(oddEvenLnkdLst list){
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while(even != null && even.next != null){
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;

        ListNode newHead = head;
        while(newHead != null){
            System.out.print(newHead.val+", ");
            newHead = newHead.next;
        }
    }

    public static void main(String[] args) {
        oddEvenLnkdLst lst = new oddEvenLnkdLst();
        //singlyLinkedList<Integer> lst = new singlyLinkedList<>();
        lst.add(5);
        lst.add(3);
        lst.add(7);
        lst.add(1);
        lst.add(9);
        lst.add(2);
        lst.add(11);
        System.out.println(lst);
        lst.oddEven(lst);
    }
}
