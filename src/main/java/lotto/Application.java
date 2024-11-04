package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.LottoInputHandler;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoInputHandler inputHandler = new LottoInputHandler();
        inputHandler.getTotalPurchase();
        Console.close();
    }
}