package GameMap;

import java.util.Iterator;
import java.util.Random;

public class LocalList {
    //holds data for some local rooms, otherwise dumps old data

    private int MAX, MIN;
    // i'd like to think there are at most going to be 4 doors to a room
    private Node[] localNodes = new Node[5];
    private int current;

    public LocalList(int listSize, int largest, int smallest) {
        this(largest, smallest);
        localNodes = new Node[listSize];
    }

    public LocalList(int largest, int smallest) {
        MAX = largest;
        MIN = smallest;
    }

    public LocalList() {
        this(20, 5);//default size const
    }

    public Node getCurrentNode() {
        return localNodes[current];
    }

    public Node next() {
        createNode();
        current++;
        if (current >= localNodes.length) {
            current = 0;
        }
        return getCurrentNode();
    }

    private void createNode() {
        int sv = 0;
        if (current + 1 >= localNodes.length) {
            sv = 0;
        } else {
            sv = current + 1;
        }
        localNodes[sv] = new Node(getRandomSize(), getRandomSize());
    }

    private int getRandomSize() {
        Random rand = new Random();
        boolean badSizes = true;
        int x = 0;
        while (badSizes) {
            x = rand.nextInt(MAX);
            if (x > MIN) {
                badSizes = false;
            }
        }
        return x;
    }

    public int size() {
        return localNodes.length;
    }

    public Iterator iterator() {
        return new Iterator() {

            @Override
            public boolean hasNext() {
                //call new node 
                createNode();
                return true;
            }

            @Override
            public Object next() {
                current++;
                if (current >= localNodes.length) {
                    current = 0;
                }
                return localNodes[current];
            }

            @Override
            public void remove() {
                localNodes[current] = null;
            }
        };
    }

    public void clear() {
        for (Node n : localNodes) {
            n = null;
        }
    }
}
