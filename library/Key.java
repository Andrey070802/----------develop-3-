package library;//пакет библиотек

import java.util.Random;

public class Key {//ключи
    private static Random random = new Random();

    private Key() {
        throw new IllegalStateException("Utility Class");
    }

    public static String generate() {//генератор ключей
        char[] key = new char[4];
        for (int i = 0; i < key.length - 1; i++) {
            key[i] = (char) (random.nextInt(10) + 65);
        }
        key[3] = (char) (random.nextInt(4) + 65);
        return new String(key);
    }

    public static boolean check(String key) {//проверка ключей
        char[] keyChar = key.toCharArray();
        for (int i = 0; i < keyChar.length     - 1; i++) {
            if ((keyChar[i] < 65) || (keyChar[i] > 74)) {
                return false;
            }
        }
        if ((keyChar[3] < 65) || (keyChar[3] > 68)) {
            return false;
        }
        return true;
    }
}
