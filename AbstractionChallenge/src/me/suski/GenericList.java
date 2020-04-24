package me.suski;

public abstract class GenericList {

    public ListItem root = null;
    public abstract void add(Comparable value);
    public abstract Comparable get(Comparable value);
    public abstract void remove(Comparable value);



    public class ListItem {
        private ListItem left;
        private ListItem right;
        private Comparable value;

        public ListItem(ListItem left, ListItem right, Comparable value) {
            this.left = left;
            this.right = right;
            this.value = value;
        }

        public int compareTo(Comparable item) {
            return this.value.compareTo(item);
        }

        public ListItem left() {
            return this.left;
        }

        public ListItem right() {
            return this.right;
        }

        public ListItem getLeft() {
            return left;
        }

        public void setLeft(ListItem left) {
            this.left = left;
        }

        public ListItem getRight() {
            return right;
        }

        public void setRight(ListItem right) {
            this.right = right;
        }

        public Comparable getValue() {
            return value;
        }

        public void setValue(Comparable value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "" + value;
        }
    }
}
