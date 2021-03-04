package uaslp.ingenieria.labs.list;

public class List {

    public static final int BEFORE = 0;
    public static final int AFTER = 1;

    private Node first;
    private Node last;
    private int size;


    /**
     * Insertar al final de la lista
     * @param data dato a insertar uwu
     */
    public void add(int data){
        Node newNode = new Node(data);
        newNode.previous = last;

        last = newNode;

        if(first == null)
        {
            first = newNode;
        }

        size++;
    }

    public void delete(int fact) {
        Node currentNode = first;
        while (currentNode.getNext() != null && currentNode.getData() != fact)
        {
            currentNode = currentNode.getNext();
        }
        if(currentNode.getData() == fact)
        {
            if(currentNode.getPrevious() == null)
            {
                first = currentNode.getNext();
                first.previous = null;
            }
            else if(currentNode.getNext() == null)
            {
                last = currentNode.getPrevious();
                last.next = null;
            }
            else {
                currentNode.next.previous = currentNode.getPrevious();
                currentNode.previous.next = currentNode.getNext();
            }
        }
    }

    public void insert(int data, int position, Iterator it){
        Node newNode = new Node(data);
        Node currentNode = it.getCurrentNode();

        if(position == AFTER){
        newNode.setNext(currentNode.getNext());
        newNode.setPrevious(currentNode);
        currentNode.setNext(newNode);
            if(newNode.getNext() != null){
                newNode.getNext().setPrevious(newNode);
            }

        }else if(position == BEFORE){
            newNode.setPrevious(currentNode.getPrevious());
            newNode.setNext(currentNode);
            currentNode.setPrevious(newNode);
            if(newNode.getPrevious() != null){
                newNode.getPrevious().setNext(newNode);
            }

        }
    }

    public int getSize() {
        return size;
    }

    public Iterator getIterator(){
        return new Iterator(first);
    }

    public ReverseIterator getReverseIterator(){
        return new ReverseIterator(last);
    }

public int get(int index){
        Node currentNode =first;
        int currentIndex = 0;

        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("El indice");

        }

        while(currentNode != null && currentIndex != index){
            currentNode = currentNode.getNext();
            currentIndex++;
        }
        return currentNode.getData();
    }
}
