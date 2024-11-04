package lotto.view;

import lotto.util.ParseUtil;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String NEXT_LINE = "\n";
    private static final String INSERT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INSERT_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INSERT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    private final ParseUtil parseUtil;

    public InputView() {
        this.parseUtil = new ParseUtil();
    }

    public Integer getPurchaseAmountInput() {
        System.out.println(INSERT_PURCHASE_AMOUNT_MESSAGE);
        return parseUtil.parsePurchaseAmount(readLine());
    }

    public List<Integer> getWinningNumbersInput() {
        System.out.println(NEXT_LINE + INSERT_WINNING_NUMBERS_MESSAGE);
        return parseUtil.parseWinningNumbers(readLine().trim());
    }

    public Integer getBonusNumberInput(final List<Integer> winningNumbers) {
        System.out.println(NEXT_LINE + INSERT_BONUS_NUMBER_MESSAGE);
        return parseUtil.parseBonusNumber(readLine().trim(), winningNumbers);
    }

}
