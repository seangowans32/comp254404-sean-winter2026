
//import week7.LinkedPositionalList;
//import week7.PositionalList;
//import Position;

public class IndexOfTest {

    public static <E> int indexOf(PositionalList<E> list, Position<E> p) {
        Position<E> walk = list.first();
        int index = 0;

        while (walk != null) {
            if (walk == p) {
                return index;
            }
            walk = list.after(walk);
            index++;
        }

        return -1;
    }

    public static void main(String[] args) {
        LinkedPositionalList<String> list = new LinkedPositionalList<>();

        Position<String> p1 = list.addFirst("A");
        Position<String> p2 = list.addLast("B");
        Position<String> p3 = list.addLast("C");
        Position<String> p4 = list.addLast("D");

        System.out.println("Index of A: " + indexOf(list, p1));
        System.out.println("Index of B: " + indexOf(list, p2));
        System.out.println("Index of C: " + indexOf(list, p3));
        System.out.println("Index of D: " + indexOf(list, p4));
    }
}