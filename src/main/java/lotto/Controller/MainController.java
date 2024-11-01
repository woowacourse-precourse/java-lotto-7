package lotto.Controller;

import lotto.View.InputView;

public class MainController {

    public void run() {
        promptUserInput();
    }

    /* 사용자로부터 입력을 받아 초기설정을 하는 프로시져 */
    private void promptUserInput() {
        InputView inputView = new InputView();

        int purchaseAmount = inputView.getLottoPurchaseAmount();
        List<Integer> lottoNumbers = inputView.getLottoNumbers(purchaseAmount);
    }

}
