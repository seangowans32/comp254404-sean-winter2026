public class TestSortedTableMap {
    public static void main(String[] args) {
        SortedTableMap<Integer, String> map = new SortedTableMap<>();

        map.put(10, "A");
        map.put(20, "B");
        map.put(30, null);

        System.out.println("containsKey(10): " + map.containsKey(10));
        System.out.println("containsKey(20): " + map.containsKey(20));
        System.out.println("containsKey(30): " + map.containsKey(30));
        System.out.println("containsKey(40): " + map.containsKey(40));

        System.out.println("get(30): " + map.get(30));
        System.out.println("get(40): " + map.get(40));
    }
}