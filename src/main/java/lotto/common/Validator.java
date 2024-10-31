package lotto.common;

public class Validator {
    private final static int CRITERIA_PRICE = 1000;

    public void validatePrice(String input) {
        int price = Integer.parseInt(input);
        isPositivePrice(price);
        isValidPrice(price);
    }

    private void isValidPrice(int price) {
        if (price % CRITERIA_PRICE != 0) {
            throw new IllegalArgumentException(ExceptionCode.PRICE_DOES_NOT_DIVIDE.message());
        }
    }

    private void isPositivePrice(int price) {
        if (price <= 0) {
            throw new IllegalArgumentException(ExceptionCode.INVALID_POSITIVE_PRICE.message());
        }
    }

    // 2.당첨 번호 구분자 validate
    // 당첨 번호 구분자 번호는 쉼표(,)를 기준으로 구분한다.

    // 3.당첨 번호 validate
    // 1~45 까지의 번호가 아니라면 예외 처리한다.

}
