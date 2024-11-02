package lotto.purchase;

import java.util.Objects;

public class PurchaseNumber {
    private static final String INVALID_LOTTO_PRICE = "로또 금액은 1000단위로 떨어져야 합니다.";
    private static final int LOTTO_PRICE = 1000;

    private final int number;

    public PurchaseNumber(String money) {
        this(parse(money));
    }

    public PurchaseNumber(int number) {
        this.number = number;
    }

    public static int parse(String input) {
        int money = 0;
        try{
            money = Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException){
            throw new IllegalArgumentException(INVALID_LOTTO_PRICE);
        }

         return isValid(money) / LOTTO_PRICE;
    }

    public int getNumber() {
        return number;
    }

    public static int isValid(int money) {
        if (money % LOTTO_PRICE == 0) {
            return money;
        }

        System.out.println(INVALID_LOTTO_PRICE);
        throw new IllegalArgumentException(INVALID_LOTTO_PRICE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseNumber that = (PurchaseNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

}
