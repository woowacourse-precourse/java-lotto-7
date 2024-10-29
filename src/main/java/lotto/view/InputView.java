package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    // 사용자 입력을 받는 메서드
    private String readInput(String message) {
        System.out.println(message);
        return Console.readLine();
    }

    public String inputPurchaseAmount() {
        return readInput(ViewMessage.INPUT_PURCHASE_AMOUNT.getMessage());
    }

    public String inputLottoNumbers() {
        return readInput(ViewMessage.INPUT_LOTTO_NUMBERS.getMessage());
    }

    public String inputBonusNumber() {
        return readInput(ViewMessage.INPUT_BONUS_NUMBER.getMessage());
    }

    // 콘솔 자원 해제
    public void close() {
        Console.close();
    }
}
