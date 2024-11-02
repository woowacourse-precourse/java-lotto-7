package lotto.ui;

import camp.nextstep.edu.missionutils.Console;

public class InputViewImpl implements InputView {
    @Override
    public String userInput() {
        System.out.print("구매 금액을 입력하세요: ");
        return Console.readLine();
    }
}
