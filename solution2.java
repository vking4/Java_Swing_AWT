public class solution2{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode n1 = l1;
        ListNode n2 = l2;
        ListNode fakeHead = new ListNode(-1);
        ListNode result = fakeHead;
        int toAdd = 0;
        while(!(n1 == null && n2 == null)){
            int v1 = 0;
            int v2 = 0;
            if (n1 != null){
                v1 = n1.val;
                n1 = n1.next;
            }
            if (n2 != null){
                v2 = n2.val;
                n2 = n2.next;
            }
            int tmp = v1 + v2 + toAdd;
            result.next = new ListNode(tmp % 10);
            result = result.next;
            toAdd = tmp / 10;

        }
        if (toAdd > 0){
            result.next = new ListNode(toAdd);
        }
        return fakeHead.next;
    }
}