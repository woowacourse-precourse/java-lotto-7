package lotto;

import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            int money = InputView.inputMoney();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
