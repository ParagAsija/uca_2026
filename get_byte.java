public class get_byte {
    public static int getByte(int x, int n) {
    return (x >> (n << 3)) & 0xFF;
}
    public static void main(String[] args) {
        System.out.println(getByte(0x12345678, 1));
    }    
}
