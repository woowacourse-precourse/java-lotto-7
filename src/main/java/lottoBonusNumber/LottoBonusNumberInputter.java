package lottoBonusNumber;

import camp.nextstep.edu.missionutils.Console;

public class LottoBonusNumberInputter {
    private static final String NOTICE_TO_INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public String runAndBringInput() {
        noticeInputBonusNumber();
        String lottoBonusNumber = extractInputLottoBonusNumber();

        return lottoBonusNumber;
    }

    private String extractInputLottoBonusNumber() {
        String lottoPurchaseAmount = Console.readLine();

        return lottoPurchaseAmount;
    }

    private void noticeInputBonusNumber() {
        System.out.println(System.lineSeparator() + NOTICE_TO_INPUT_BONUS_NUMBER);
    }
}
