public class LinkedList {

    public Node start;

    public LinkedList(){
        this.start = null;
    }

    public void add(String word){
        if(start == null){
            start = new Node(word);
        }
        else {
            Node temp = start;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = new Node(word);
        }
    }

    public String get(int index){
        int current = 0;
        Node temp = start;
        while(temp != null && current != index){
            temp = temp.next;
            current++;
        }
        return temp.word;
    }

    public int indexOf(String word){
        int current = 0;
        Node temp = start;
        while(temp.next != null){
            if(temp.word.equals(word)){
                return current;
            }
            temp = temp.next;
            current++;
        }
        return -1;
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
            System.out.print(temp.word + " ");
            temp = temp.next;
        }
        System.out.print("\n");
    }

    private class Node{
        private String word;
        private Node next;

        private Node(String word){
            this.word = word;
            this.next = null;
        }
    }

}
