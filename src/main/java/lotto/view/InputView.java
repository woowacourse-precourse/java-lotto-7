package lotto.view;


import camp.nextstep.edu.missionutils.Console;
import java.util.function.Supplier;

public class InputView {
    public static int readFee() {
        System.out.println("구입금액을 입력해 주세요.");
        return readInt();
    }

    public static String readWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return read();
    }

    public static int readBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return readInt();
    }

    private static int readInt() {
        return getInputWithSpace(() -> Integer.parseInt(Console.readLine()));
    }

    private static String read() {
        return getInputWithSpace(Console::readLine);
    }

    private static <T> T getInputWithSpace(Supplier<T> supplier) {
        T input = supplier.get();
        printEmptySpace();
        return input;
    }

    private static void printEmptySpace() {
        System.out.println();
    }

}
