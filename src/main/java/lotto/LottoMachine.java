package lotto;

public class LottoMachine {
    // 금액을 입력 받으면 금액이 맞는지 확인 및 로또 갯수를 알려줌
    private final static int LOTTO_AMOUNT = 1000;
    private final static String THOUSAND_NUMBER = "[ERROR] 금액은 1000원 이상만 입력 가능합니다.";
    private final static String AMOUNT_REST_ZERO = "[ERROR] 금액은 1000원 단위로 입력 가능합니다.";
    private final static String NOT_NUMBER = "[ERROR] 금액은 숫자만 입력 가능합니다.";
    private final int amount;

    public LottoMachine(String amount) {
        int amountCheck = validateNumber(amount);
        validateThousand(amountCheck);
        validateRestOfZero(amountCheck);
        this.amount = amountCheck;

    }

    public int buyLottoTickets() {
        return amount / LOTTO_AMOUNT;
    }

    private static int validateNumber(String amount) {
        try {
            return Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            System.out.println(NOT_NUMBER);
            throw new IllegalArgumentException();
        }
    }

    private void validateThousand(int amount) {
        if (amount < 1000) {
            System.out.println(THOUSAND_NUMBER);
            throw new IllegalArgumentException();
        }
    }

    private void validateRestOfZero(int amount) {
        if (amount % 1000 != 0) {
            System.out.println(AMOUNT_REST_ZERO);
            throw new IllegalArgumentException();
        }
    }

}
