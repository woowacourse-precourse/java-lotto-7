package lotto.domain;

public enum BonusBall {
    MATCH(true),
    NOT_MATCH(false),
    IRRELEVANT(false);

    private boolean status;

    BonusBall(boolean status) {
        this.status = status;
    }

    public boolean match() {
        return status;
    }
}
