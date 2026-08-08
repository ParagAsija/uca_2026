public class IsPower2 {
    public static int isPower2(int x) {
    int zero = ((x | (~x + 1)) >> 31) + 1;
    int nonZero = zero ^ 1;

    int negative = x >> 31;
    int positive = (negative + 1) & nonZero;

    int xm1 = x + ~0;
    int zeroCheck = ((x & xm1) | (~(x & xm1) + 1)) >> 31;
    int isZero = zeroCheck + 1;

    return positive & isZero;
}

    public static void main(String[] args) {
        System.out.println(isPower2(8));
    }
}
