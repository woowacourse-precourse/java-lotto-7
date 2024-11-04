package lotto.purchasing.model;

public class Payment {
    private static int PAYMENT_OF_UNIT = 1_000;
    private int numberOfTickets;

    public Payment(String inputPayment) {
        numberOfTickets = purchasingLottoTickets(inputPayment);
    }

    private int purchasingLottoTickets(String inputPayment) {
        validPaymentNumber(inputPayment);
        validPaymentMultipleOf1_000(inputPayment);
        return Integer.parseInt(inputPayment) / PAYMENT_OF_UNIT;
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
        if (payment % PAYMENT_OF_UNIT != 0 || payment <= 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위의 금액을 입력하세요.");
        }
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }
}
