package lotto.system.lottoGetter;

public class LottoPaymentValidator { // 로또 구매 금액을 검증하는 객체

    public static final String ERROR_INVALID_MULTIPLE_OF_TICKET_PRICE = "[ERROR] 로또 구매 금액은 로또 한 장의 가격의 배수여야 합니다.";
    public static final String ERROR_INSUFFICIENT_PAYMENT = "[ERROR] 로또 구매 금액은 로또 한 장의 가격보다 커야 합니다.";
    private static final int TICKET_PRICE = 1000;

    public static void validate(int totalPayment) {
        validateSufficientPayment(totalPayment);
        validateMultipleOfTicketPrice(totalPayment);
    }

    private static void validateMultipleOfTicketPrice(int totalPayment) {
        if (totalPayment % TICKET_PRICE != 0) {
            throw new IllegalArgumentException(ERROR_INVALID_MULTIPLE_OF_TICKET_PRICE);
        }
    }

    private static void validateSufficientPayment(int totalPayment) {
        if (totalPayment < TICKET_PRICE) {
            throw new IllegalArgumentException(ERROR_INSUFFICIENT_PAYMENT);
        }
    }
}
