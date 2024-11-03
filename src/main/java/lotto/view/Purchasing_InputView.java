package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Purchasing_InputView {
    private String payment;

    public String getPayment() {
        if (payment.isBlank()) {
            System.out.println("구매금액을 입력해 주세요.");
            this.payment = readLine();
            System.out.println();
        }
        return payment;
    }
}
