package lotto;

import lotto.dto.PurchaseAmount;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        outputView.printPurchaseAmountMessage();

        InputView inputView = new InputView();

        // 테스트할 입력값들을 배열에 추가
        String[] testInputs = {"5000", "abc", "-100", "100000001"};

        for (String input : testInputs) {
            try {
                System.out.println("테스트 입력값: " + input);
                PurchaseAmount purchaseAmount = PurchaseAmount.from(input);
                System.out.println("입력된 금액: " + purchaseAmount.amount());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("------------------------");
        }
    }
}
