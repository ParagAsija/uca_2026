public class Conditional {
    public static int conditional(int x, int y, int z) {
    int mask = (x | (~x + 1)) >> 31;
    return (mask & y) | (~mask & z);
}
    public static void main(String[] args) {
        System.out.println(conditional(2, 4, 5));
    }
}
