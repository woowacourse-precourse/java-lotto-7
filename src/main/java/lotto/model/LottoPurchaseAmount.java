package lotto.model;

public class LottoPurchaseAmount {

    private static final int MIN_VALUE = 1000;

    private Integer value;

    public LottoPurchaseAmount(String value) {
        this(LottoPurchaseAmount.parseString(value));
    }

    public LottoPurchaseAmount(Integer value) {
        validate(value);
        this.value = value;
    }

    private static Integer parseString(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("로또 구입 금액을 입력해주세요.");
        }
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("로또 구입 금액은 숫자만 입력해주세요.");
        }
    }

    private void validate(Integer value) {
        if (value == null) {
            throw new IllegalArgumentException("로또 구입 금액을 입력해주세요.");
        }
        if (value < MIN_VALUE) {
            throw new IllegalArgumentException("로또 구입 금액은 1000 이상의 숫자를 입력해주세요.");
        }
        if (value % MIN_VALUE != 0) {
            throw new IllegalArgumentException("로또 구입 금액은 1000 단위의 숫자를 입력해주세요.");
        }
    }

    public Integer getValue() {
        return this.value;
    }
}
