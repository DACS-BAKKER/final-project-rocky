public class LinkedList {

    public Node start;

    public LinkedList(){
        this.start = null;
    }

    public void add(int number){
        if(start == null){
            start = new Node(number);
        }
        else {
            Node temp = start;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = new Node(number);
        }
    }

    public int get(int index){
        int current = 0;
        Node temp = start;
        while(temp != null && current != index){
            temp = temp.next;
            current++;
        }
        return temp.number;
    }

    public int size(){
        if (start == null){
            return 0;
        }
        else {
            int count = 1;
            Node temp = start;
            while(temp.next != null){
                temp = temp.next;
                count++;
            }
            return count;
        }
    }

    public void print(){
        Node temp = start;
        while(temp != null){
            System.out.print(temp.number + " ");
            temp = temp.next;
        }
        System.out.print("\n");
    }

    private class Node{
        private int number;
        private Node next;

        private Node(int number){
            this.number = number;
            this.next = null;
        }
    }

}
