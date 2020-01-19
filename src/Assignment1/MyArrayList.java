package Assignment1;

public class MyArrayList<E> {

    /*
     * Do not change this initial capacity; it is used by our test cases
     */
    private static final int INITIAL_CAPACITY = 4;

    /*
     *  These are protected so that test cases can access them.
     *  Please do not change the visibility of these fields!
     */
    protected E[] data;
    protected int size = 0;

    public MyArrayList() {
        data = (E[]) new Object[INITIAL_CAPACITY];
    }

    /*
     * Need to implement this in step 5
     */
    public MyArrayList(E[] arr) {

    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        else return data[index];
    }

    private void increaseCapacity() {
        E[] newData = (E[]) new Object[2 * data.length];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }

    /*
     * This method adds the element to the list.
     * Except for modifying it to use Java Generics,
     * DO NOT OTHERWISE CHANGE THIS METHOD
     * as it is used in testing your code.
     */
    public void add(E value) {
        if (size == data.length) {
            increaseCapacity();
        }
        data[size++] = value;
    }

    public void add(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (size == data.length) {
            increaseCapacity();
        }
        for (int i = size-1; i >= index; i--) {
            data[i+1] = data[i];
        }
        data[index] = element;
        size++;
    }


    /*
    Note to self: having two methods both with the same name, but having different signatures, is
    okay, as long as the parameters are different. This gave me hell in MCIT 591, but I think I've figured it out now.
     */
    public E remove(int index) {
        boolean outOfBounds = false;
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        E target = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return target;
    }


    /*
     * Need to implement this in Step 2.
     */
    public boolean remove(E obj) {
        boolean result = false;
        if(contains(obj)){
            for(int i = 0; i < data.length; i++){
                if(data[i].equals(obj)){
                    remove(i);
                    return true;
                }
            }
        }

        return false;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(i + ": " + data[i]);
        }
    }

    public boolean contains(E obj) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(obj))
                return true;
        }
        return false;
    }

    /*
     * Need to implement this in Step 4
     */
    public E set(int index, E obj) {
        return null;
    }
}