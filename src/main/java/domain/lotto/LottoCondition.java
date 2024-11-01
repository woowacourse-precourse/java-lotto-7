package domain.lotto;

public enum LottoCondition {
    START_INCLUSIVE(1),
    END_INCLUSIVE(45),
    COUNT(6)
    ;

    private int conditionNumber;

    private LottoCondition(int number) {
        conditionNumber = number;
    }

    public int getConditionNumber() {
        return conditionNumber;
    }
}
