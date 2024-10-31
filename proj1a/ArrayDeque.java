public class ArrayDeque<T> {

    private Object[] sentinel;
    private int size;
    private int nextFirst;
    private int nextLast;
    private int capacity = 8;

    public ArrayDeque() {
        sentinel = (T[]) new Object[capacity];
        nextLast = 1;
        nextFirst = 0;
        size = 0;
    }

    private void resize(int cap) {
        //size up
        if (capacity < cap) {
            Object[] p = (T[]) new Object[cap];
            int firstindex = (nextFirst + 1) % capacity;
            int firstlength = capacity - firstindex;
            int newfirst = cap - firstlength;
            int lastlength = nextLast;
            System.arraycopy(sentinel, 0, p, 0, lastlength);
            System.arraycopy(sentinel, firstindex, p, newfirst, firstlength);
            sentinel = p;
            nextFirst = newfirst - 1;
            capacity = cap;
        }
        //size down
        if (capacity > cap) {
            Object[] p = (T[]) new Object[cap];
            int firstindex = (nextFirst + 1) % capacity;
            int firstlength = capacity - firstindex;
            int newfirst = cap - firstlength;
            int lastlength = (nextLast - 1) % cap;
            System.arraycopy(sentinel, 0, p, 0, lastlength);
            System.arraycopy(sentinel, firstindex, p, newfirst, firstlength);
            sentinel = p;
            nextFirst = newfirst - 1;
            nextLast = nextLast % cap;
            capacity = cap;
        }
    }

    public void addFirst(T item) {
        if (size == sentinel.length) {
            resize(sentinel.length * 2);
        }
        sentinel[nextFirst] = item;
        nextFirst = (nextFirst - 1) % capacity;
        if (nextFirst < 0) {
            nextFirst += capacity;
        }
        size += 1;
    }

    public void addLast(T item) {
        if (size == sentinel.length) {
            resize(sentinel.length * 2);
        }
        sentinel[nextLast] = item;
        nextLast = (nextLast + 1) % capacity;
        size += 1;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i = (nextFirst + 1); i < size; i++) {
            int index = i % capacity;
            System.out.println(sentinel[index] + " ");
        }
        System.out.println();
    }


    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        int first_index = (nextFirst + 1) % capacity;
        T p = (T) sentinel[first_index];
        sentinel[first_index] = null;
        size -= 1;
        nextFirst = (nextFirst + 1) % capacity;

        if ((size * 4 < capacity) && (capacity > 8)) {
            resize(capacity / 2);
        }

        return p;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        int last_index = (nextLast - 1) % capacity;
        if (last_index < 0) {
            last_index += capacity;
        }
        T p = (T) sentinel[last_index];
        sentinel[last_index] = null;
        size -= 1;
        nextLast = (nextLast - 1) % capacity;
        if (nextLast < 0) {
            nextLast += capacity;
        }

        if ((size * 4 < capacity) && (capacity > 8)) {
            resize(capacity / 2);
        }
        return p;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        int pos = (index + nextFirst + 1) % capacity;
        return (T) sentinel[pos];
    }


     /**public ArrayDeque(ArrayDeque other) {
        sentinel = new Object[]{0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0; i < other.size(); i++) {
            this.addLast((T) other.get(i));
        }
     }*/

//    public static void main(String[] args) {
//        ArrayDeque<Integer> a0 = new ArrayDeque();
//        a0.addLast(0);
//        a0.addFirst(1);
//        a0.addLast(8);
//        a0.addFirst(2);
//        a0.addFirst(3);
//        a0.addFirst(4);
//        a0.addFirst(5);
//        a0.addFirst(6);
//        a0.addFirst(7);
//        a0.removeLast();
//        a0.removeFirst();
//        a0.removeLast();
//        a0.removeLast();
//        a0.removeLast();
//        a0.removeLast();
//        a0.removeLast();
//        a0.removeFirst();
//        int m = a0.get(4);
//        ArrayDeque<Integer> a1 = new ArrayDeque(a0);
//        int z = a0.get(2);
//        int x = a0.removeFirst();
//        int y = a0.removeLast();
//    }
}