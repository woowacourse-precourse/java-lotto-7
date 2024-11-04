package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class LottoInputView {

    private static final String PRICE_REQUEST = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_REQUEST = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_REQUEST = "보너스 번호를 입력해 주세요.";
    private static final String BLANK_LINE = System.lineSeparator();

    public String getPriceInput() {
        System.out.println(PRICE_REQUEST);

        return Console.readLine();
    }

    public String getWinningNumberInput() {
        System.out.print(BLANK_LINE);
        System.out.println(WINNING_NUMBER_REQUEST);

        return Console.readLine();
    }

    public String getBonusInput() {
        System.out.print(BLANK_LINE);
        System.out.println(BONUS_REQUEST);

        return Console.readLine();
    }
}
