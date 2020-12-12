package ss.week5;
import java.nio.charset.StandardCharsets;


import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.binary.Base64;
/**
 * A simple class that experiments with the Hex encoding
 * of the Apache Commons Codec library.
 */
public class Encoding {
    public static void main(String[] args) throws DecoderException {
        String input = "Hello World";

        // Hex encoding
        System.out.println(Hex.encodeHexString(input.getBytes()));

        // Hex decoding
        String hexString = "4d6f64756c652032";
        byte[] bytes = Hex.decodeHex(hexString.toCharArray());
        System.out.println(new String(bytes, StandardCharsets.UTF_8));


        // Base64 encoding
        String base64Input = Base64.encodeBase64String(input.getBytes());
        System.out.println(base64Input);


        String hexString2 = "010203040506";
        byte[] bytes2 = Hex.decodeHex(hexString2.toCharArray());
        System.out.println(Base64.encodeBase64String(bytes2));


        // Decoding Base64
        String base64Input2 = "U29mdHdhcmUgRGV2ZWxvcG1lbnQ=";
        byte[] bytes3 = Base64.decodeBase64(base64Input2);
        System.out.println(new String(bytes3));

        String str = "";
        for (int i = 0; i < 10; i++) {
            str += "a";
            System.out.println(Base64.encodeBase64String(str.getBytes()));
        }
    }
}
