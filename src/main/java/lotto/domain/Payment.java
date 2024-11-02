package lotto.domain;

public class Payment {

    private static final int PRICE = 1000;

    private final int payment;

    private Payment(int payment) {
        Validator.validateDivisibleByPrice(payment);
        this.payment = payment;
    }

    public static Payment of(int payment) {
        return new Payment(payment);
    }

    public int calculateCount() {
        return payment / PRICE;
    }

    public double divide(long profit) {
        return (double) profit / payment;
    }

    public int getPayment() {
        return payment;
    }

    private static class Validator {
        private static void validateDivisibleByPrice(int money) {
            if (isNotDivisibleByPrice(money)) {
                throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요");
            }
        }

        private static boolean isNotDivisibleByPrice(int money) {
            return money % PRICE != 0;
        }
    }
}
