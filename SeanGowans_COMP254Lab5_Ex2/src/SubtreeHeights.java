public class SubtreeHeights {
    public static <E> int printSubtreeHeights(Tree<E> T, Position<E> p) {
        int maxChildHeight = -1;

        for(Position<E> child : T.children(p)) {
            // Recursive Call
            int childHeight = printSubtreeHeights(T, child);

            if(childHeight > maxChildHeight) {
                maxChildHeight = childHeight;
            }
        }

        int height = maxChildHeight + 1;
        System.out.println(p.getElement() + " -> " + height);

        return height;
    }

    public static void main(String[] args) {
        LinkedBinaryTree<Integer> T = new LinkedBinaryTree<>();

        Position<Integer> p10 = T.addRoot(10);

        Position<Integer> p5 = T.addLeft(p10, 5);
        Position<Integer> p15 = T.addRight(p10, 15);

        T.addLeft(p5, 3);
        T.addRight(p5, 7);

        T.addLeft(p15, 12);
        T.addRight(p15, 18);

        //        10 (root)
        //     5      15
        //    3 7    12 18

        printSubtreeHeights(T, T.root());
    }
}