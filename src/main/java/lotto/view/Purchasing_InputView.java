package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Purchasing_InputView {
    private final String payment;

    public Purchasing_InputView() {
        System.out.println("구매금액을 입력해 주세요.");
        this.payment = readLine();
    }

    public String getPayment() {
        return payment;
    }
}
