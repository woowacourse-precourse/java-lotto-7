package lotto.model.vo;

public record Percent(Double value) {
    public Percent {
        validate(value);
    }

    private static void validate(double value) {
        if (value < 0) {
            throw new IllegalArgumentException("퍼센트는 음수가 될 수 없습니다.");
        }
    }

    @Override
    public String toString() {
        return value + "%";
    }
}
