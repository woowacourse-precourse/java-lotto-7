package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String PURCHASE_PROMPT = "구입금액을 입력해 주세요.";
    private static final String LOTTO_NUMBER_PROMPT = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요.";

    public String getPurchaseAmount() {
        System.out.println(PURCHASE_PROMPT);
        return Console.readLine().strip();
    }

    public String getLottoNumbers() {
        System.out.println(LOTTO_NUMBER_PROMPT);
        return Console.readLine().strip();
    }

    public String getBonusNumber() {
        System.out.println(BONUS_NUMBER_PROMPT);
        return Console.readLine().strip();
    }
}
