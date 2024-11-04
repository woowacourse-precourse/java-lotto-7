package lotto.purchasing.model;

import static lotto.common.constant.LottoConstant.PAYMENT_UNIT_WON;

public class Payment {
    private final int numberOfTickets;

    public Payment(String inputPayment) {
        numberOfTickets = purchasingLottoTickets(inputPayment);
    }

    private int purchasingLottoTickets(String inputPayment) {
        validPaymentNumber(inputPayment);
        validPaymentMultipleOf1_000(inputPayment);
        return Integer.parseInt(inputPayment) / PAYMENT_UNIT_WON;
    }

    private void validPaymentNumber(String inputPayment) {
        try {
            Integer.parseInt(inputPayment);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("[ERROR] 유효하지 않은 금액입니다.");
        }
    }
    
    private void validPaymentMultipleOf1_000(String inputPayment) {
        int payment = Integer.parseInt(inputPayment);
        if (payment % PAYMENT_UNIT_WON != 0 || payment <= 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위의 금액을 입력하세요.");
        }
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }
}
