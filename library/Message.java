package library;//пакет библиотек

public class Message {//сообщения
    private Message() {
        throw new IllegalStateException("Utility Class");
    }

    public static boolean check(String message) {//проверка сообщения
        char[] messageChar = message.toCharArray();
        for (int i = 0; i < messageChar.length; i++) {
            if (((messageChar[i] < 65) || (messageChar[i] > 90)) && (messageChar[i] != 32)) {
                return false;
            }
        }
        return true;
    }
}
