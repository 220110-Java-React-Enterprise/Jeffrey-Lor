package collections;

import java.util.Iterator;

/**
 * A fairly simple arraylist implementation extending custom list interface.
 * Default size is 2, grows by size * 2 when needed.
 * When an element is added or removed at an index other elements are not
 * re-arranged.
 *
 * @param <e>
 */
public class CustomArrayList<E> implements CustomListInterface<E> {
    private Object[] array;
    private int size;
    private int maxSize;

    /**
     * Default constructor, creates an empty underlying array with maxSize 2
     */
    public CustomArrayList() {
        maxSize = 2;
        size = 0;
        array = new Object[maxSize];
    }

    /**
     * Sized constructor, creates an empty object with maxSize size
     * 
     * @param size the initial size of the underlying array
     */
    public CustomArrayList(int size) {
        maxSize = size;
        size = 0;
        array = new Object[size];
    }

    /**
     * Element list constructor, takes in variable number of objects and creates an
     * underlying
     * array large enough to fit them.
     * 
     * @param e
     */
    @SuppressWarnings("unchecked")
    public CustomArrayList(E... e) {
        maxSize = size = e.length;
        array = new Object[size];

        for (int i = 0; i < size; ++i) {
            array[i] = e[i];
        }
    }

    /**
     * Adds an object to the underlying array after all previously added objects.
     * If array needs to grow, it invokes grow method.
     * 
     * @param o object to be added
     */
    @Override
    public void add(Object o) {
        // if size >= maxSize we need to grow array
        if (size >= maxSize) {
            growArray();
        }
        array[size++] = o;
    }

    /**
     * Adds object at specified index, advancing the size of the underlying array.
     * This will
     * overwrite an existing element, rather than shift them
     * 
     * @param index index location where object will be inserted
     * @param e     element to be inserted
     * @throws IndexOutOfBoundsException
     */
    @Override
    public void add(E e, int index) throws IndexOutOfBoundsException {
        if (size >= maxSize) {
            growArray();
        }
        if (index <= size) {
            // Shift all elements
            for (int i = size; i >= index; i--) {
                array[i] = array[i - 1];
            }
            array[index] = e;
            size++;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * gets the object located at supplied index
     * 
     * @param index index of object to get
     * @return object located at index
     * @throws IndexOutOfBoundsException
     */
    @Override
    @SuppressWarnings("unchecked")
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < size) {
            return (E) array[index];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Emptys the underlying array by setting it's private reference to null and
     * allowing
     * the old array to be garbage collected.
     */
    @Override
    public void clear() {
        maxSize = 2;
        size = 0;
        array = new Object[maxSize];
    }

    /**
     * Check if object o is found within underlying array, using Object.equals()
     * method
     * 
     * @param o object to search for
     * @return index location of first instance of matching object. -1 if not found.
     */
    @Override
    public int contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Removes object at specified index from underlying array, setting to null.
     * 
     * @param index index of object to remove from array
     */
    @Override
    public void remove(int index) {
        if (index < size) {
            array[index] = null;
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[size - 1] = null;
        size--;
    }

    /**
     * returns size of array. This is the one greater than the index of the most
     * advanced stored object,
     * not the maxSize which controls growth of the underlying array.
     * 
     * @return one greater than index of most advanced stored object
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Doubles the size of the underlying array by creating a new array and copying
     * the
     * contents of the previous array into it.
     */
    private void growArray() {
        // System.out.println("Growing Array from " + maxSize + " to " + maxSize * 2);
        // set up new array
        maxSize = maxSize * 2;
        Object[] tempArray = array;
        array = new Object[maxSize];

        // copy to new array
        for (int i = 0; i < size; i++) {
            array[i] = tempArray[i];
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new CustomIterator<E>();
    }

    class CustomIterator<T> implements Iterator<E> {

        int cursor;

        public CustomIterator() {
            cursor = 0;
        }

        @Override
        public boolean hasNext() {
            if (cursor < size) {
                return true;
            }
            return false;
        }

        @SuppressWarnings("unchecked")
        @Override
        public E next() {
            return (E)array[cursor++];
        }

    }
}
