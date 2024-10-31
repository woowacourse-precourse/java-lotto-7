package lotto.validator;

public class PriceValidator implements Validator<Integer> {

    @Override
    public void validate(Integer price) {
        validatePositive(price);
        validateThousandUnit(price);
    }

    private void validatePositive(Integer price) {
        if (price <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위의 양수를 입력해 주세요.");
        }
    }

    private void validateThousandUnit(Integer price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위의 양수를 입력해 주세요.");
        }
    }
}
