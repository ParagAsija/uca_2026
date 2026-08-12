// The approach is to process the ASCII string in groups of 3 characters (24 bits). Convert each character into its 8-bit ASCII value, combine the three bytes into a 24-bit number, and then divide those 24 bits into four 6-bit groups. Each 6-bit value is used as an index into the Base64 character table ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/. If fewer than 3 characters remain, add zero bits to complete the 6-bit groups and append = or == depending on whether 2 or 1 bytes remain. This can be implemented without using any built-in Base64 encoding library.


public class Base64Encoding {

    static final String BASE64 =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";

    public static String encode(String input) {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i += 3) {

            int b1 = input.charAt(i);
            int b2 = (i + 1 < input.length()) ? input.charAt(i + 1) : 0;
            int b3 = (i + 2 < input.length()) ? input.charAt(i + 2) : 0;

            int combined = (b1 << 16) | (b2 << 8) | b3;

            int index1 = (combined >> 18) & 63;
            int index2 = (combined >> 12) & 63;
            int index3 = (combined >> 6) & 63;
            int index4 = combined & 63;

            result.append(BASE64.charAt(index1));
            result.append(BASE64.charAt(index2));

            if (i + 1 < input.length()) {
                result.append(BASE64.charAt(index3));
            } else {
                result.append('=');
            }

            if (i + 2 < input.length()) {
                result.append(BASE64.charAt(index4));
            } else {
                result.append('=');
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        System.out.println(encode("Man"));          // TWFu
        System.out.println(encode("Ma"));           // TWE=
        System.out.println(encode("Cat"));          // Q2F0
        System.out.println(encode("Hello World"));  // SGVsbG8gV29ybGQ=
        System.out.println(encode("A"));            // QQ==
        System.out.println(encode(""));             // ""
    }
}