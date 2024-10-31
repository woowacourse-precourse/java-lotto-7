package lotto;

import view.InputView;

public class Application {
    public static void main(String[] args) {

        // 1. 구입 금액 입력
        InputView inputView = new InputView();
        int inputMoney = inputView.getInputMoney();

        // 2. 로또 구매
        int myLotto = inputMoney / 10;

        // 3. 로또 발행

        // 4. 당첨 번호 입력

        // 5. 보너스 번호 입력

        // 6. 당첨된 로또 확인

        // 7. 당첨 통계

        // 8. 당첨 금액 계산

        // 9. 수익률 계산

        // 10. 수익률 출력
    }
}
