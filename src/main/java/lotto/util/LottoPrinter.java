package lotto.util;

import lotto.console.ConsoleOutput;
import lotto.domain.Lottos;

public class LottoPrinter {

    public static void print(Lottos lottos) {
        ConsoleOutput.print(StringMaker.make(lottos));
    }

    public static void print(Double earningRate, int[] countPerRank) {
        ConsoleOutput.print(StringMaker.make(earningRate, countPerRank));
    }

    public static void printError(Exception e) {
        ConsoleOutput.print(e.getMessage());
    }
}
