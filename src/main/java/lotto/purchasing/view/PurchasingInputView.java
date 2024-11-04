package lotto.purchasing.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class PurchasingInputView {
    private String payment;

    public String getPayment() {
        if (payment == null) {
            System.out.println("구매금액을 입력해 주세요.");
            this.payment = readLine();
            System.out.println();
            return payment;
        }
        return payment;
    }

    public void setPaymentNull() {
        payment = null;
    }
}
