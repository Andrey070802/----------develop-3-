package simulator;//пакет симулятора

public class Simulator {// симулятор
    protected static final char[] INPUT = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
            'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };// алфавит

    private Simulator() {
        throw new IllegalStateException("Utility Class");
    }

    public static String encoder(String message, String key) {// кодирование
        char[] messageChar = message.toCharArray();
        char[] keyChar = key.toCharArray();
        messageChar = Rotor.run(messageChar, keyChar[0]);
        messageChar = Rotor.run(messageChar, keyChar[1]);
        messageChar = Rotor.run(messageChar, keyChar[2]);
        Reflector.run(messageChar, keyChar[3]);
        messageChar = Rotor.run(messageChar, keyChar[2]);
        messageChar = Rotor.run(messageChar, keyChar[1]);
        messageChar = Rotor.run(messageChar, keyChar[0]);
        message = new String(messageChar);
        return message;
    }

    public static String decoder(String message, String key) {// декодирование
        char[] messageChar = message.toCharArray();
        char[] keyChar = key.toCharArray();
        messageChar = Rotor.reverseRun(messageChar, keyChar[0]);
        messageChar = Rotor.reverseRun(messageChar, keyChar[1]);
        messageChar = Rotor.reverseRun(messageChar, keyChar[2]);
        Reflector.run(messageChar, keyChar[3]);
        messageChar = Rotor.reverseRun(messageChar, keyChar[2]);
        messageChar = Rotor.reverseRun(messageChar, keyChar[1]);
        messageChar = Rotor.reverseRun(messageChar, keyChar[0]);
        message = new String(messageChar);
        return message;
    }
}
