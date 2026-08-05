public class ANDimplement{

    public static int bitAND(int x, int y){
        return ~(~x | ~y);
    }
    public static void main(String[] args){
        int ans = bitAND(6, 5);
        System.out.println(ans);
    }
}