package lotto.io.input;

import camp.nextstep.edu.missionutils.Console;

public class WinningNumbersInputConsoleHandler {

    public static final String RAW_NUMBER_SEPARATOR = ",";

    public void showWinningNumberGuideMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public String[] askWinningNumber() {
        String rawWinningNumber = Console.readLine();
        String[] rawWinningNumberSplit = rawWinningNumber.split(RAW_NUMBER_SEPARATOR);

        for (int i = 0; i < rawWinningNumberSplit.length; i++) {
            rawWinningNumberSplit[i] = rawWinningNumberSplit[i].trim();
        }

        return rawWinningNumberSplit;
    }
}
