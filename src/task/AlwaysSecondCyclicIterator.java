package task;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AlwaysSecondCyclicIterator<E> implements Iterator<E> {
    private List<E> circle;
    private int numberSelectedElement;
    private boolean elementIsTaken;

    public AlwaysSecondCyclicIterator(List<E> circle) {
        if (circle == null) {
            this.circle = new ArrayList<E>();
        } else {
            this.circle = circle;
        }
        this.numberSelectedElement = - 1;
        elementIsTaken = false;
    }

    @Override
    public void remove() {
        if (!isEmpty() && elementIsTaken) {
            circle.remove(numberSelectedElement);
            this.numberSelectedElement--;
        }
    }

    @Override
    public boolean hasNext() {
        return !isEmpty();
    }

    @Override
    public E next() {
        if (hasNext()) {
            elementIsTaken = true;
            numberSelectedElement = (numberSelectedElement + 2) % circle.size();
            return circle.get(numberSelectedElement);
        }
        return null;
    }

    private boolean isEmpty() {
        return circle.size() == 0;
    }
}
