package lotto.view;


import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static int readFee() {
        System.out.println("구입금액을 입력해 주세요.");
        return readInt();
    }

    private static int readInt() {
        return Integer.parseInt(Console.readLine());
    }
}
