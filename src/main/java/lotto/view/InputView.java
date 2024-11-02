package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.ErrorMessage;

public class InputView {

    public static final String ASK_MONEY_INPUT = "구입금액을 입력해 주세요.\n";
    public static final String ASK_LOTTO_NUM_INPUT = "당첨 번호를 입력해 주세요.\n";
    public static final String ASK_LOTTO_BONUS_NUM_INPUT = "보너스 번호를 입력해 주세요.\n";

    public int lottoMoneyInput() {
        System.out.printf(ASK_MONEY_INPUT);
        String rawMoney = Console.readLine();
        validateIsNumber(rawMoney);
        return Integer.parseInt(rawMoney);
    }

    public String[] lottoNumsInput() {
        System.out.printf(ASK_LOTTO_NUM_INPUT);
        String rawNumbers = Console.readLine();
        return rawNumbers.split(",");
    }

    public int lottoBonusNumInput() {
        System.out.printf(System.lineSeparator());
        System.out.printf(ASK_LOTTO_BONUS_NUM_INPUT);
        String rawNumber = Console.readLine();
        validateIsNumber(rawNumber);
        return Integer.parseInt(rawNumber);
    }

    private void validateIsNumber(String rawValue) {
        try {
            Integer.parseInt(rawValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_NOT_NUMBER.getMsg());
        }
    }
}
