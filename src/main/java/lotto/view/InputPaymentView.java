package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputPaymentView {
    private static InputPaymentView inputView;
    private String payment;

    private InputPaymentView(String payment) {}

    public static InputPaymentView getInputView() {
        if(inputView == null) {
            System.out.println("구매금액을 입력해 주세요.");
            return new InputPaymentView(readLine());
        }
        return inputView;
    }

    public String getUserPayment() {
      return payment;
    }
}
