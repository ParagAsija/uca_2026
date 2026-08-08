public class Sign {
    public static int sign(int x) {
    int signBit = x >> 31;
    int nonZero = x != 0 ? 1 : 0;
    return signBit | nonZero;
}

    public static void main(String[] args) {
        System.out.println(sign(130));
    }
}
