package lotto.view;


import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static int readFee() {
        System.out.println("구입금액을 입력해 주세요.");
        return readInt();
    }

    public static String readWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return read();
    }

    private static int readInt() {
        return Integer.parseInt(read());
    }

    private static String read() {
        return Console.readLine();
    }
}
