public class Bang {
    public static int bang(int x) {
    int sign = (x | (~x + 1)) >> 31;
    return sign + 1;
}

    public static void main(String[] args) {
        System.out.println(bang(3));
    }
}
