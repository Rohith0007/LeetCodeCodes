public class Merge_Two_Sorted_Lists_21 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode cur = new ListNode(-1, null);
        ListNode head = cur;

        while (list1 != null && list2 != null) {
            if (list1.val == list2.val) {
                cur.next = new ListNode(list1.val);
                cur.next.next = new ListNode(list2.val);
                cur = cur.next.next;
                list1 = list1.next;
                list2 = list2.next;
            } else {
                if (list1.val > list2.val) {
                    cur.next = new ListNode(list2.val);
                    cur = cur.next;
                    list2 = list2.next;
                } else {
                    cur.next = new ListNode(list1.val);
                    cur = cur.next;
                    list1 = list1.next;
                }
            }
        }

        cur.next = list1 != null ? list1 : list2;
        return head.next;
    }

    public static void main(String[] args) {
        Merge_Two_Sorted_Lists_21 m1 = new Merge_Two_Sorted_Lists_21();

        ListNode l1 = m1.new ListNode(1, m1.new ListNode(2, m1.new ListNode(4)));
        ListNode l2 = m1.new ListNode(1, m1.new ListNode(3, m1.new ListNode(4)));

        ListNode mergedList = m1.mergeTwoLists(l1, l2);

        while (mergedList != null) {
            System.out.print(mergedList.val + " ");
            mergedList = mergedList.next;
        }
    }
}
