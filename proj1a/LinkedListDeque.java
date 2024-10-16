public class LinkedListDeque<T> {
    public class IntNode<T> {
        public IntNode prev;
        public T item;
        public IntNode next;
        public IntNode(IntNode m, T i, IntNode n) {
            prev = m;
            item = i;
            next = n;
        }
    }

    private IntNode sentinel;
    private IntNode first;
    private IntNode last;
    private int size;


    /**Create an empty Deque*/
    public LinkedListDeque() {
        sentinel = new IntNode(null,15, null);
        sentinel.next = sentinel.prev;
        sentinel.prev = sentinel.item;
        size = 0;
    }


    public LinkedListDeque(T item) {
        sentinel = new IntNode(null,15, null);
        sentinel.next = new IntNode(null, item, null);
        sentinel.prev = sentinel.next.next;
        size = 1;
    }

    public void addFirst(T item) {
        sentinel.next = new IntNode(null, item, null);
        first = sentinel.next;
        size += 1;
    }

    public void addLast(T item) {
        sentinel.prev = new IntNode(null, item, null);
        last = sentinel.prev;
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
        while (p.next != sentinel.next) {
            System.out.print(p.item + " ");
        }
        System.out.println();
    }

    public T removeFirst() {
        
    }
}
