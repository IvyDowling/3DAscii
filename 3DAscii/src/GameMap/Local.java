package GameMap;

import java.util.Iterator;

public class Local {
    //holds data for some local rooms, otherwise dumps old data

    private Node[] localNodes;
    private int current;

    public Local(int memory) {
        localNodes = new Node[memory];
    }
    /*
     If no arguement is present, defaults to array of length 5
     @return
     */

    public Local() {
        // i'd like to think there are at most going to be 4 doors to a room
        //current + 4
        localNodes = new Node[5];
        current = 0;
    }

    public Iterator getIterator() {
        return new Iterator() {

            @Override
            public boolean hasNext() {
                for (Node n : localNodes) {
                    if (n != null) {
                        return true;
                    }
                }
                return false;
            }

            @Override
            public Object next() {
                current++;
                if (current >= localNodes.length) {
                    current = 0;
                }
                return getCurrentNode();
            }

            @Override
            public void remove() {
                localNodes[current] = null;
                current++;
            }

        };
    }

    public Node getCurrentNode() {
        return localNodes[current];
    }

    public Node nextNode() {
        current++;
        if (current >= localNodes.length) {
            current = 0;
        }
        return getCurrentNode();
    }

    public void add(Node n) {
//        cleanMem();
        if (n != null) {
            //lets see if there are any un-used slots
            for (Node node : localNodes) {
                if (node == null) {
                    node = n;
                }
            }
            //whoops!
        }
    }

    public boolean contains(Node n) {
        for (Node node : localNodes) {
            if (node == n || node.equals(n)) {
                return true;
            }
        }
        return false;
    }

    public Node remove() {
        Node temp = localNodes[current];
        localNodes[current] = null;
        return temp;
    }

    public Node remove(Node n) {
        for (Node node : localNodes) {
            if (node.equals(n)) {
                Node temp = node;
                node = null;
                return temp;
            }
        }
        return null;
    }

    public Node remove(int i) {
        Node temp = localNodes[i];
        localNodes[i] = null;
        return temp;
    }

    public int size() {
        return localNodes.length;
    }

    public void clear() {
        for (Node n : localNodes) {
            n = null;
        }
    }
}
