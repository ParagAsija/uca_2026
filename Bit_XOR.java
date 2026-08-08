public class Bit_XOR{

    public static int bitXor(int x, int y) {
    return ~(~(x & ~y) & ~(~x & y));
}
    public static void main(String[] args) {
        System.out.println(bitXor(4, 5));
    }
}