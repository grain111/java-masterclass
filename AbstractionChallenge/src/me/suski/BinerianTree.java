package me.suski;

public class BinerianTree extends GenericList {

    @Override
    public void add(Comparable value) {
        if (this.root == null) {
            this.root = new ListItem(null, null, value);
            return;
        }

        ListItem node = this.root;
        while (true) {
            int compareValue = node.compareTo(value);
            if (compareValue == 0) {
                return;
            } else if (compareValue > 0) {
                if (node.getRight() == null) {
                    node.setRight(new ListItem(null, null, value));
                    return;
                } else {
                    node = node.right();
                }
            } else {
                if (node.getLeft() == null) {
                    node.setLeft(new ListItem(null, null, value));
                    return;
                } else {
                    node = node.left();
                }
            }
        }
    }

    @Override
    public Comparable get(Comparable value) {
        return null;
    }

    @Override
    public void remove(Comparable value) {
        ListItem node = this.root;
        while (true) {
            if (node == null) {
                break;
            }
            int compareValue = node.compareTo(value);
            if (compareValue == 0) {
                ListItem replacementNode = getMaxLeafNode(node);
                Comparable val = replacementNode.getValue();
                node.setValue(val);
                removeLeafNode(replacementNode);
            } else if (compareValue > 0) {
                node = node.right();
            } else {
                node = node.left();
            }

        }
    }

    private ListItem getMaxLeafNode(ListItem node) {
        ListItem currentNode = node;
        while (currentNode.getLeft() != null) {
            currentNode = currentNode.left();
        }
        if (currentNode.getRight() != null) {
            return currentNode.getRight();
        } else {
            return currentNode;
        }
    }

    private void removeLeafNode(ListItem node) {
        ListItem currentNode = this.root;
        while (true) {
            if (currentNode.getRight() == node) {
                currentNode.setRight(null);
                return;
            } else if (currentNode.getLeft() == node) {
                currentNode.setLeft(null);
                return;
            } else {
                int compareValue = currentNode.compareTo(node.getValue());
                if (compareValue > 0) {
                    currentNode = currentNode.right();
                } else {
                    currentNode = currentNode.left();
                }
            }

        }
    }
}
