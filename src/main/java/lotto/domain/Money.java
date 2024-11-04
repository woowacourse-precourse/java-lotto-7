package lotto.domain;

public record Money(int amount) {

    public Money {
        validate(amount);
        validateUnit(amount);
    }

    private void validate(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("[ERROR] 돈은 양의 정수만 가능합니다.");
        }
    }

    private void validateUnit(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 돈은 1000원 단위로 입력해주세요.");
        }
    }
}
