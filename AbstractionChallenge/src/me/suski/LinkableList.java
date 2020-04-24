package me.suski;

public class LinkableList extends GenericList {


    @Override
    public void add(Comparable value) {
        if (this.root == null) {
            this.root = new ListItem(null, null, value);
        }
        ListItem currentNode = this.root;
        ListItem previousNode = null;
        while (true) {

            if (currentNode == null) {
                previousNode.setRight(new ListItem(previousNode, null, value));
                return;
            }
            int compareValue = currentNode.compareTo(value);
            if (compareValue == 0) {
                return;
            } else if (compareValue > 0) {
                previousNode = currentNode;
                currentNode = currentNode.right();
            } else {
                if (previousNode != null) {
                    previousNode.setRight(new ListItem(previousNode, currentNode, value));
                    currentNode.setLeft(previousNode.getRight());
                } else {
                    currentNode.setLeft(new ListItem(null, currentNode, value));
                    this.root = currentNode.getLeft();
                }
                return;
            }
        }
    }

    @Override
    public void remove(Comparable value) {
        ListItem node = this.root;
        while (node != null) {
            if (node.getValue() == value) {
                if (node.getLeft() == null) {
                    node.getRight().setLeft(null);
                    this.root = node.getRight();
                } else if (node.getRight() == null) {
                    node.getLeft().setRight(null);
                } else {
                    node.getLeft().setRight(node.getRight());
                    node.getRight().setLeft(node.getLeft());
                }
                return;

            }
            node = node.right();
        }
    }

    @Override
    public String toString() {
        ListItem node = this.root;
        String output = "";
        while (node != null) {
            output += node.getValue() + " ";
            node = node.right();
        }
        return output;
    }

    @Override
    public Comparable get(Comparable value) {
        return null;
    }
}
