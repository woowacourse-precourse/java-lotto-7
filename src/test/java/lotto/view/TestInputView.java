package lotto.view;

import java.util.ArrayList;
import java.util.List;

public class TestInputView implements InputView {
    private static final String PURCHASE_AMOUNT_PROMPT = "구입 금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_PROMPT = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요.";

    private final List<String> testInputs;
    private final List<String> printedMessages = new ArrayList<>();
    private int currentIndex = 0;

    public TestInputView(List<String> testInputs) {
        this.testInputs = testInputs;
    }

    @Override
    public String getPurchaseAmountInput() {
        printedMessages.add(PURCHASE_AMOUNT_PROMPT);
        return testInputs.get(currentIndex++);
    }

    @Override
    public String getWinningNumbersInput() {
        printedMessages.add(WINNING_NUMBERS_PROMPT);
        return testInputs.get(currentIndex++);
    }

    @Override
    public String getBonusNumberInput() {
        printedMessages.add(BONUS_NUMBER_PROMPT);
        return testInputs.get(currentIndex++);
    }

    public List<String> getPrintedMessages() {
        return printedMessages;
    }
}