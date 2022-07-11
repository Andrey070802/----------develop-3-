package simulator;//пакет симулятора

public class Rotor {// симулирование роторов
    // роторы
    private static final char[] I = { 'E', 'K', 'M', 'F', 'L', 'G', 'D', 'Q', 'V', 'Z', 'N', 'T', 'O', 'W', 'Y', 'H',
            'X', 'U', 'S', 'P', 'A', 'I', 'B', 'R', 'C', 'J' };
    private static final char[] II = { 'A', 'J', 'D', 'K', 'S', 'I', 'R', 'U', 'X', 'B', 'L', 'H', 'W', 'T', 'M', 'C',
            'Q', 'G', 'Z', 'N', 'P', 'Y', 'F', 'V', 'O', 'E' };
    private static final char[] III = { 'B', 'D', 'F', 'H', 'J', 'L', 'C', 'P', 'R', 'T', 'X', 'V', 'Z', 'N', 'Y',
            'E', 'I', 'W', 'G', 'A', 'K', 'M', 'U', 'S', 'Q', 'O' };
    private static final char[] IV = { 'E', 'S', 'O', 'V', 'P', 'Z', 'J', 'A', 'Y', 'Q', 'U', 'I', 'R', 'H', 'X', 'L',
            'N', 'F', 'T', 'G', 'K', 'D', 'C', 'M', 'W', 'B' };
    private static final char[] V = { 'V', 'Z', 'B', 'R', 'G', 'I', 'T', 'Y', 'U', 'P', 'S', 'D', 'N', 'H', 'L', 'X',
            'A', 'W', 'M', 'J', 'Q', 'O', 'F', 'E', 'C', 'K' };
    private static final char[] VI = { 'J', 'P', 'G', 'V', 'O', 'U', 'M', 'F', 'Y', 'Q', 'B', 'E', 'N', 'H', 'Z', 'R',
            'D', 'K', 'A', 'S', 'X', 'L', 'I', 'C', 'T', 'W' };
    private static final char[] VII = { 'N', 'Z', 'J', 'H', 'G', 'R', 'C', 'X', 'M', 'Y', 'S', 'W', 'B', 'O', 'U',
            'F', 'A', 'I', 'V', 'L', 'P', 'E', 'K', 'Q', 'D', 'T' };
    private static final char[] VIII = { 'F', 'K', 'Q', 'H', 'T', 'L', 'X', 'O', 'C', 'B', 'J', 'S', 'P', 'D', 'Z',
            'R', 'A', 'M', 'E', 'W', 'N', 'I', 'U', 'Y', 'G', 'V' };
    private static final char[] BETA = { 'L', 'E', 'Y', 'J', 'V', 'C', 'N', 'I', 'X', 'W', 'P', 'B', 'Q', 'M', 'D',
            'R', 'T', 'A', 'K', 'Z', 'G', 'F', 'U', 'H', 'O', 'S' };
    private static final char[] GAMMA = { 'F', 'S', 'O', 'K', 'A', 'N', 'U', 'E', 'R', 'H', 'M', 'B', 'T', 'I', 'Y',
            'C', 'W', 'L', 'Q', 'P', 'Z', 'X', 'V', 'G', 'J', 'D' };

    private Rotor() {
        throw new IllegalStateException("Utility Class");
    }

    // запуск ротора
    public static char[] run(char[] message, char number) {
        char[] temporary = choose(number);
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

    public static char[] reverseRun(char[] message, char number) {
        char[] temporary = choose(number);
        for (int i = 0; i < message.length; i++) {
            for (int j = 0; j < temporary.length; j++) {
                if (temporary[j] == message[i]) {
                    message[i] = Simulator.INPUT[j];
                    break;
                }
            }
        }
        return message;
    }

    private static char[] choose(char number) {// выбор ротора
        char[] temporary;
        switch (number) {
            case ('A'):
                temporary = I;
                break;
            case ('B'):
                temporary = II;
                break;
            case ('C'):
                temporary = III;
                break;
            case ('D'):
                temporary = IV;
                break;
            case ('E'):
                temporary = V;
                break;
            case ('F'):
                temporary = VI;
                break;
            case ('G'):
                temporary = VII;
                break;
            case ('H'):
                temporary = VIII;
                break;
            case ('I'):
                temporary = BETA;
                break;
            case ('J'):
                temporary = GAMMA;
                break;
            default:
                throw new IllegalStateException("Incorrect reflector number");
        }
        return temporary;
    }
}