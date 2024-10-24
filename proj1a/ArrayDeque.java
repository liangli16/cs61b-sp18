public class ArrayDeque<T> {

    private Object[] sentinel;
    private int size;
    //private int front;
    //private int end;

    public ArrayDeque() {
        sentinel = (T[]) new Object[8];
        //front = 0;
        //end = 0;
        size = 0;
    }

    private void resize(int capacity) {
        Object[] p = (T[]) new Object[capacity];
        System.arraycopy(sentinel, 0, p, 1, size);
        sentinel = p;
    }

    public void addFirst(T item) {
        resize(sentinel.length + 1);
        sentinel[0] = item;
        size += 1;
    }

    public void addLast(T item) {
        if (size == sentinel.length) {
            resize(size + 1);
        }
        sentinel[size] = item;
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
        for (int i = 0; i < size; i++) {
            System.out.println(sentinel[i] + " ");
        }
        System.out.println();
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T p = (T) sentinel[0];
        //Remove first item and update sentinel.
        Object[] temp = new Object[sentinel.length - 1];
        System.arraycopy(sentinel, 1, temp, 0, sentinel.length - 1);
        sentinel = temp;
        size -= 1;
        return p;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T p = (T) sentinel[size - 1];
        //Remove last item and update sentinel.
        Object[] temp = new Object[sentinel.length - 1];
        System.arraycopy(sentinel, 0, temp, 0, sentinel.length - 1);
        //temp[size - 1] = 0;
        sentinel = temp;
        size -= 1;
        return p;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return (T) sentinel[index];
    }


     /**public ArrayDeque(ArrayDeque other) {
        sentinel = new Object[]{0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0; i < other.size(); i++) {
            this.addLast((T) other.get(i));
        }
     }*/


    public static void main(String[] args) {
        ArrayDeque<Integer> a0 = new ArrayDeque();
        a0.addLast(8);
        a0.addFirst(1);
        a0.addLast(9);
        //ArrayDeque<Integer> a1 = new ArrayDeque(a0);
        int z = a0.get(2);
        int x = a0.removeFirst();
        int y = a0.removeLast();
    }
}