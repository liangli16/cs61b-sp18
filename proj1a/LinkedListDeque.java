public class LinkedListDeque<T> {

    public class IntNode<T> {
        public IntNode prev;
        public T item;
        public IntNode next;
        public IntNode(IntNode p, T i, IntNode n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    private IntNode sentinel;
/**    private IntNode prev;
    private IntNode item;
    private IntNode next;
    private IntNode first;
    private IntNode last;*/
    private int size;


    /**Create an empty Deque*/
    public LinkedListDeque() {
        sentinel = new IntNode(sentinel,15, sentinel);
        size = 0;
    }


    public LinkedListDeque(T item) {
        sentinel = new IntNode(sentinel,15, sentinel);
        sentinel.next = new IntNode(sentinel, item, sentinel);
        sentinel.prev = sentinel.next;
        size = 1;
    }

    public void addFirst(T item) {
        sentinel.next = new IntNode(sentinel, item, sentinel.next);
        size += 1;
    }

    public void addLast(T item) {
        sentinel.prev = new IntNode(sentinel.prev, item, sentinel);
        size += 1;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
       IntNode p = sentinel.next;
        while (p.next != sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println();
    }
/**
    public T removeFirst() {

    }*/

    public static void main(String[] args) {
       // LinkedListDeque<String> a0 = new LinkedListDeque<>();
        LinkedListDeque<String> a1 = new LinkedListDeque<>("1st");
       // a1.addFirst("2nd");
        a1.addLast(("2nd"));
        //int x = a0.size();
        //System.out.println(x);
        a1.printDeque();
    }
}
