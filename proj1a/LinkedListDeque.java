public class LinkedListDeque<T> {

    private class IntNode<T> {
        IntNode prev;
        T item;
        IntNode next;
        public IntNode(IntNode p, T i, IntNode n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    private IntNode sentinel;
    private int size;


    /**Create an empty Deque*/
    public LinkedListDeque() {
        sentinel = new IntNode(null, "start", null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }


    /**public LinkedListDeque(T item) {
        sentinel = new IntNode(null, "start", null);
        sentinel.next = new IntNode(sentinel, item, sentinel);
        sentinel.prev = sentinel.next;
        size = 1;
    }*/

    public void addFirst(T item) {
        //set original first node prev to the new node (insert new "First node").
        sentinel.next.prev = new IntNode(sentinel, item, sentinel.next);
        //set sentinal.next to the new "First node".
        sentinel.next = sentinel.next.prev;
        size += 1;
    }

    public void addLast(T item) {
        //set original last node next to the new node (insert new "Last node").
        sentinel.prev.next = new IntNode(sentinel.prev, item, sentinel);
        //set sentinal.prev to the new "Last node".
        sentinel.prev = sentinel.prev.next;
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
            p = p.next;
        }
        System.out.println();
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T p = (T) sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size -= 1;
        return p;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T p = (T) sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size -= 1;
        return p;
    }

    public T get(int index) {
        IntNode p = sentinel.next;
        while (index != 0) {
            p = p.next;
            index -= 1;
        }
        T pout = (T) p.item;
        if (pout == null) {
            return null;
        }
        return pout;
    }

    /**public LinkedListDeque(LinkedListDeque other) {
        sentinel = new IntNode(null,"start", null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
        for (int i = 0; i < other.size(); i += 1) {
            this.addLast((T) other.get(i));
        }
    }*/

    private T getRecursivehelper(IntNode p, int index) {
        if (index == 0) {
            return (T) p.item;
        } else {
            return getRecursivehelper(p.next, index - 1);
        }
    }

    public T getRecursive(int index) {
        return getRecursivehelper(sentinel.next, index);
    }

/**    public static void main(String[] args) {
        LinkedListDeque<String> a0 = new LinkedListDeque<>();
        LinkedListDeque<String> a1 = new LinkedListDeque<>("1st");
        //test addFirst
        a1.addFirst(("first2"));
        a1.addFirst("first3");
        a1.addFirst("first4");
        //test addLast
        a1.addLast("last2");
        a1.addLast("last3");
        a1.addLast("last4");
        String testr = a1.getRecursive(2);
        //a1.removeFirst();
        //a1.removeLast();
        //String test = a1.get(2);
        //LinkedListDeque<String> a2 = new LinkedListDeque<>(a1);
        //a1.printDeque();
    }*/
}
