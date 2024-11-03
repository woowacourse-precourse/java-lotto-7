package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputPaymentView {
    private final String payment;

    public InputPaymentView() {
        System.out.println("구매금액을 입력해 주세요.");
        this.payment = readLine();
    }

    public String getPayment() {
        return payment;
    }
}
