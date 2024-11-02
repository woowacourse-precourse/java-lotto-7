package lotto.message;

public enum Place {

    TRUE(1),
    FALSE(0);

    private final Integer number;

    Place(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }
}
