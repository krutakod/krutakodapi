package Test;

public class EncryptToken {
//    private static final String ALGORITHM = "AES";
//    private static final String CIPHER_SUITE = "AES/CBC/NoPadding";
//    private static final int AES_KEY_SIZE = 16;
//    private static final int AES_BLOCK_SIZE = 16;
//
//    public String encryptToken(String token, String pin) {
//        byte[] decodedToken = decodeToken(token); // декодируем токен
//        byte[] rawPin = pin.getBytes();
//
//        byte[] iv = generate(AES_BLOCK_SIZE); // генерируем вектор инициаллизации для режима CBC
//        byte[] salt = generate(AES_KEY_SIZE);  // генерируем соль для функции удлиннения ключа
//        byte[] key = kdf.deriveKey(rawPin, salt, AES_KEY_SIZE); // удлинняем пин-код до размера ключа
//
//        Cipher cipher = Cipher.getInstance(CIPHER_SUITE); // инициаллизируем нашим шифронабором
//        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key, ALGORITHM), new IvParameterSpec(iv));
//        return cipher.doFinal(token);
//    }
//
//    public byte[] decodeToken(String token) {
//        byte[] rawToken = token.getBytes();
//        return Base64.getUrlDecoder().decode(rawToken);
//    }
//
//    public final byte[] generate(int size) {
//        byte[] random = new byte[size];
//        (new SecureRandom()).nextBytes(random);
//        return random;
//    }
}
