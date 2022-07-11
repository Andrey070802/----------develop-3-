package simulator;//пакет симулятора

public class Reflector {// симулирование рефлектора
    // рефлекторы
    private static final char[] B = { 'Y', 'R', 'U', 'H', 'Q', 'S', 'L', 'D', 'P', 'X', 'N', 'G', 'O', 'K', 'M', 'I',
            'E', 'B', 'F', 'Z', 'C', 'W', 'V', 'J', 'A', 'T' };
    private static final char[] D = { 'F', 'V', 'P', 'J', 'I', 'A', 'O', 'Y', 'E', 'D', 'R', 'Z', 'X', 'W', 'G', 'C',
            'T', 'K', 'U', 'Q', 'S', 'B', 'N', 'M', 'H', 'L' };
    private static final char[] B_DUNN = { 'E', 'N', 'K', 'Q', 'A', 'U', 'Y', 'W', 'J', 'I', 'C', 'O', 'P', 'B', 'L',
            'M', 'D', 'X', 'Z', 'V', 'F', 'T', 'H', 'R', 'G', 'S' };
    private static final char[] D_DUNN = { 'R', 'D', 'O', 'B', 'J', 'N', 'T', 'K', 'V', 'E', 'H', 'M', 'L', 'F', 'C',
            'W', 'Z', 'A', 'X', 'G', 'Y', 'I', 'P', 'S', 'U', 'Q' };

    private Reflector() {
        throw new IllegalStateException("Utility Class");
    }

    public static char[] run(char[] message, char number) {// запуск рефлектора
        char[] temporary;
        switch (number) {
            case ('A'):
                temporary = B;
                break;
            case ('B'):
                temporary = D;
                break;
            case ('C'):
                temporary = B_DUNN;
                break;
            case ('D'):
                temporary = D_DUNN;
                break;
            default:
                throw new IllegalStateException("Incorrect reflector number");
        }
        for (int i = 0; i < message.length; i++) {
            for (int j = 0; j < Simulator.INPUT.length; j++) {
                if (Simulator.INPUT[j] == message[i]) {
                    message[i] = temporary[j];
                    break;
                }
            }
        }
        return message;
    }
}
