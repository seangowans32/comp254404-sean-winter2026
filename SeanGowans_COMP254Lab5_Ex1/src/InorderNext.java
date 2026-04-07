//Worst-case running time: O(h)

public class InorderNext {
    public static <E> Position<E> inorderNext(BinaryTree<E> T, Position<E> p) {
        if(p == null) {
            return null;
        }

        // Case 1: p has a right subtree
        if(T.right(p) != null) {
            Position<E> walk = T.right(p);

            while(T.left(walk) != null) {
                walk = T.left(walk);
            }

            return walk;
        }

        // Case 2: move upward until we come from a left child
        Position<E> walk = p;

        while(!T.isRoot(walk)) {
            Position<E> parent = T.parent(walk);

            if(T.left(parent) == walk) {
                return parent;
            }

            walk = parent;
        }

        // p is the last node in inorder traversal
        return null;
    }

    public static void main(String[] args) {
        LinkedBinaryTree<Integer> T = new LinkedBinaryTree<>();

        Position<Integer> p10 = T.addRoot(10);
        Position<Integer> p5 = T.addLeft(p10, 5);
        Position<Integer> p15 = T.addRight(p10, 15);
        Position<Integer> p3 = T.addLeft(p5, 3);
        Position<Integer> p7 = T.addRight(p5, 7);
        Position<Integer> p12 = T.addLeft(p15, 12);
        Position<Integer> p18 = T.addRight(p15, 18);

        Position<Integer>[] nodes = new Position[]{p3, p5, p7, p10, p12, p15, p18};

        for(Position<Integer> p : nodes) {
            Position<Integer> next = inorderNext(T, p);

            System.out.print("inorderNext(" + p.getElement() + ") = ");

            if(next == null) {
                System.out.println("null");

            } else {
                System.out.println(next.getElement());
            }
        }
    }
}