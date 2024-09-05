package Interview;

import java.util.Arrays;

public class STGLABInterview {
    static class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static boolean checkRotatedAnagram(String source, String target) {

        if(source.length() != target.length()){
            return false;
        }

        for(int i=0; i<source.length(); i++) {
            String str1 = source.substring(i, 1);
            String str2 = target.substring(target.length() - 2, target.length() - 1);
            if (str1 == str2)
                return true;
        }
        return false;

    }
    //1->2->3->4->null
    public void addNodeAtPosition(int val, int pos, Node head) {
        Node node = head;
        int count = 0;
        if(pos == 0) {
            Node newNode = new Node(val);
            newNode.next = head;
            return;
        }
        while(node != null) {
            if(count == pos)
                break;
            node = node.next;
            count++;
        }
        if(node == null){
            System.out.println("Error: position is not there");
        }
        Node newNode =  new Node(val);
        newNode.next = head;
    }


    public static void main(String[] args) {
        String str = "amrit narayan jha";
        StringBuilder sb = new StringBuilder();
        String str1 = new String();
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) != 'a') {
                //sb.append(str.charAt(i));
                str1 += str.charAt(i);
            }
        }
//        System.out.println(str1);
        String src = "abcdef";
        String str2 =  "cdefab";
        //System.out.println(checkRotatedAnagram(src, str2));

        int[] arr = {1,2,4,5,6};
        int i = 0, j=arr.length-1;
        while(i<j) {
            int tempVal = arr[i];
            arr[i] = arr[j];
            arr[j] = tempVal;
            i++;
            j--;
        }
        System.out.println(Arrays.toString(arr));

    }

}


// abcdef
// cdefab
//

// int arr[] = {33,44,33,22,44, 22}
  // {22, 22, 22, 33, 33}
