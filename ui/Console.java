package ui;//пакет интерфейсов пользователя

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import library.Key;
import library.Message;
import simulator.Simulator;

public class Console {// консольный интерфейс пользователя
    private static Logger logger = Logger.getLogger(Console.class.getName());
    private static Scanner scanner = null;

    private Console() {
        throw new IllegalStateException("Utility Class");
    }

    public static void console() {
        String code = coding();
        String message = input();
        String choose = choose();
        String key = key(choose);
        run(message, key, code);
        scanner.close();
    }

    private static String coding() {// механизм выбора кодировки/декодеровки
        logger.log(Level.INFO, "(E)ncode/(D)ecode?");

        String code = null;
        while (true) {
            scanner = new Scanner(System.in);
            code = scanner.nextLine();
            if ((code.equals("E")) || (code.equals("D"))) {
                break;
            } else {
                logger.log(Level.WARNING, "Wrong code");
            }
        }
        return code;
    }

    private static String input() {// механизм ввода сообщения
        logger.log(Level.INFO, "Input message:");
        String message = null;
        while (true) {
            scanner = new Scanner(System.in);
            message = scanner.nextLine();
            if (Message.check(message)) {
                break;
            } else {
                logger.log(Level.WARNING, "Wrong message");
            }
        }
        return message;
    }

    private static String choose() {// механизм выбора ввода ключа
        logger.log(Level.INFO, "(I)nput/(G)enerate key:");
        String choose = null;
        while (true) {
            scanner = new Scanner(System.in);
            choose = scanner.nextLine();
            if ((choose.equals("I")) || (choose.equals("G"))) {
                break;
            } else {
                logger.log(Level.WARNING, "Wrong choose");
            }
        }
        return choose;
    }

    private static String key(String choose) {// механизм ввода ключа
        String key = null;
        if (choose.equals("I")) {
            logger.log(Level.INFO, "Input key:");
            while (true) {
                scanner = new Scanner(System.in);
                key = scanner.nextLine();
                if (Key.check(key)) {
                    break;
                } else {
                    logger.log(Level.WARNING, "Wrong key");
                }
            }
        } else {
            key = Key.generate();
            logger.log(Level.INFO, "Key = {0}", key);
            return key;
        }
        return key;
    }

    private static void run(String message, String key, String choose) {// механизм
        if (choose.equals("E")) {
            String encoder = Simulator.encoder(message, key);
            logger.log(Level.INFO, "Encoder: {0}", encoder);
        } else {
            String decoder = Simulator.decoder(message, key);
            logger.log(Level.INFO, "Decoder: {0}", decoder);
        }

    }
}