package lotto.validator;

public class Money implements InputTypeValidator {
    private final String amount;

    public Money(String amount) {
        this.amount = amount;
    }

    @Override
    public boolean isNaturalNumber() {
        try {
            Long.parseLong(amount);
            return true;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 금액은 자연수로 입력해 주세요.");
        }
    }

    public boolean isMultipleOfLottoPrice() {
        if ((Long.parseLong(amount) >= 1000) && (Long.parseLong(amount) % 1000 == 0)) {
            return true;
        }
        throw new IllegalArgumentException("[ERROR] 금액은 최소 1000원부터 1000원 단위로 입력이 가능합니다.");
    }

    public String getAmount() {
        return amount;
    }
}
