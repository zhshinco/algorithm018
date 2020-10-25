public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return null;
        }

        ListNode head = new ListNode(-1);
        ListNode currentNode = null;
        while(l1 != null || l2 != null){
            if(currentNode == null){
                currentNode = new ListNode(-1);
                head.next = currentNode;
            }

            if(l1 == null){
                currentNode.next = l2;
                l2 = l2.next;
            }else if(l2 == null ){
                currentNode.next = l1;
                l1 = l1.next;
            }else if(l1.val <= l2.val){
                currentNode.next = l1;
                l1 = l1.next;
            }else{
                currentNode.next = l2;
                l2 = l2.next;
            }

            currentNode = currentNode.next;
        }
        return head.next.next;
    }