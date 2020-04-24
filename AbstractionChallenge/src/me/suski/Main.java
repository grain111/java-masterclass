package me.suski;

public class Main {

    public static void main(String[] args) {

        LinkableList aList = new LinkableList();
        aList.add(5);
        aList.add(7);
        aList.add(4);
        System.out.println(aList);
        aList.remove(4);
        System.out.println(aList);

        LinkableList aListString = new LinkableList();
        aListString.add("Dad");
        aListString.add("Mom");
        aListString.add("Son");
        System.out.println(aListString);

        BinerianTree aTree = new BinerianTree();
        aTree.add(5);
        aTree.add(7);
        aTree.add(8);
        aTree.add(4);
        aTree.add(6);
        System.out.println(aTree.root);
        System.out.println(aTree.root.getLeft());
        System.out.println(aTree.root.getLeft().getLeft());
        System.out.println(aTree.root.getRight());
        System.out.println(aTree.root.getLeft().getRight());
        System.out.println("===========");
        aTree.remove(5);
        System.out.println(aTree.root);
        System.out.println(aTree.root.getLeft());
        System.out.println(aTree.root.getLeft().getLeft());
        System.out.println(aTree.root.getLeft().getRight());
    }
}
