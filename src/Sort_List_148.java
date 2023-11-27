import java.util.*;
public class Sort_List_148 {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(4, new ListNode(2, new ListNode(3, new ListNode(1))));
        System.out.println(sortList(head));
    }
    public static ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        List<Integer> lit = new ArrayList<>();
        while(head != null) {
            lit.add(head.val);
            head=head.next;
        }
//        Collections.sort(lit);
        merge(lit);
        ListNode temp = new ListNode(lit.get(0));
        ListNode temp1 = temp;
        for(int i=1;i<lit.size(); i++) {
            temp.next = new ListNode(lit.get(i));
            temp = temp.next;
        }
        return temp1;
    }

    public static void merge(List<Integer> lit) {
//        int len = lit.size();
//        for(int i=0; i<len-1; i++) {
//            for(int j=i; j< len-1; j++) {
//                if(lit.get(j) > lit.get(j+1)) {
//                    int temp1 = lit.get(i);
//                    int temp2 = lit.get(i+1);
//                    lit.add(i, temp2);
//                    lit.add(i+1, temp1);
//                }
//            }
//        }
    }
}
