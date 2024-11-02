package lotto.message;

public enum Place {

    TRUE(1),
    FALSE(0),
    MIN_PLACE(1),
    MAX_PLACE(5);

    private final Integer number;

    Place(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }
}
