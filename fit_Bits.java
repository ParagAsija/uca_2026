public class fit_Bits {

    public static int fitsBits(int x, int n) {
        int shift = 32 + (~n + 1);
        return (x ^ ((x << shift) >> shift)) == 0 ? 1 : 0;
    }
    public static void main(String[] args) {
        System.out.println(fitsBits(-4, 3));
    }
}
