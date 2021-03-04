package uaslp.ingenieria.labs.list;

public class ReverseIterator {
    private Node currentNode;

    public ReverseIterator(Node currentNode) {
        this.currentNode = currentNode;
    }

    public boolean hasPrevious() {
        return currentNode != null;
    }

    public int previous() {
        int data = currentNode.data;

        currentNode = currentNode.getPrevious();

        return data;
    }

    public Node getCurrentNode() {
        return currentNode;
    }
}
