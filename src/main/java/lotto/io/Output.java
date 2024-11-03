package lotto.io;

import lotto.model.Lottos;

public final class Output {
    public static void printlnMessage(final String message) {
        System.out.println(message);
    }

    public static void printlnFormattedMessage(final String format, Object... args) {
        System.out.printf((format) + "%n", args);
    }

    public static void printLottos(Lottos lottos) {
        lottos.lottos.forEach(System.out::println);
    }
}
