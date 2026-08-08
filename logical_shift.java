public class logical_shift {
    public static int logicalShift(int x, int n) {
    return x >>> n;
}

    public static void main(String[] args) {
        System.out.println(logicalShift(0x87654321, 4));
    }
}
