import java.util.Stack;

public class TransferTest {

    // transfer method
    // push: add to top (last)
    // pop: remove from top (last)
    public static <E> void transfer(Stack<E> S, Stack<E> T) {
        while(!S.isEmpty()) {
            T.push(S.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> S = new Stack<>();
        Stack<Integer> T = new Stack<>();

        S.push(1);
        S.push(2);
        S.push(3);
        S.push(4);

        // So now S stack looks like this (LIFO: Last In First Out)
        // 4
        // 3
        // 2
        // 1

        transfer(S, T);

        System.out.println("Elements in T:");

        while(!T.isEmpty()) {
            System.out.println(T.pop());
        }
    }
}