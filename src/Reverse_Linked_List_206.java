public class Reverse_Linked_List_206 {

    public static void main(String[] args) {
        ListNode h1 = new ListNode(1);
        ListNode h2 = new ListNode(2);
        ListNode h3 = new ListNode(3);
        ListNode h4 = new ListNode(4);
        ListNode h5 = new ListNode(5);
        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        h4.next = h5;

        Reverse_Linked_List_206 solution = new Reverse_Linked_List_206();
        ListNode reversedList = solution.reverseList(h1);

        while (reversedList != null) {
            System.out.print(reversedList.val + " ");
            reversedList = reversedList.next;
        }
    }
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }

        return prev;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}
