package com.leetcode.linkedlist;

public class AddTwoNumbers {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            // Initialize current node to dummy head of the returning list.
            // Initialize carry to 00.
            // Initialize pp and qq to head of l1l1 and l2l2 respectively.
            //     Loop through lists l1l1 and l2l2 until you reach both ends.
            //     Set xx to node pp's value. If pp has reached the end of l1l1, set to 00.
            //     Set yy to node qq's value. If qq has reached the end of l2l2, set to 00.
            //     Set sum = x + y + carrysum=x+y+carry.
            //     Update carry = sum / 10carry=sum/10.
            //     Create a new node with the digit value of (sum \bmod 10)(summod10)
            //     and set it to current node's next, then advance current node to next.
            //     Advance both pp and qq

            int carry = 0;
            ListNode p = l1;
            ListNode q = l2;

            // dummy is a placeholder for the head
            ListNode dummyNode = new ListNode(-1);

            // used to iterate
            ListNode currentNode = dummyNode;

            while (p != null || q != null){

                int val1 = p == null? 0 : p.val;
                int val2 = q == null? 0 : q.val;

                int sum = carry + val1 + val2;
                // 8
                // 11

                if (sum > 9){
                    carry = 1;
                    sum = sum % 10;
                    // 1
                }else{
                    carry = 0;
                }

                ListNode newNode = new ListNode(sum);

                // assign current node with new node next
                currentNode.next = newNode;
                currentNode = currentNode.next;

                // move forward with next list
                p = p == null ? p : p.next;
                q = q == null ? q : q.next;

            }

            // When Carry at the end is 1
            if(carry >0) {
                ListNode newNode = new ListNode(carry);
                currentNode.next = newNode;
            }

            // return dummy next (ignore dummy head)
            return dummyNode.next;
        }
    }
