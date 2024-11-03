package lotto.model;

public enum LottoPrizeType {
    FIRST("1등",2000000000, 6, false),
    SECOND("2등",30000000, 5, true),
    THIRD("3등",1500000,5,false),
    FOURTH("4등",50000,4,false),
    FIFTH("5등",5000,3,false);


    private final String name;
    private final int prizeAmount;
    private final int requiredCorrectCount;
    private final boolean requiresBonusNumber;

    LottoPrizeType(String name, int prizeAmount, int requiredCorrectCount, boolean requiresBonusNumber) {
        this.name = name;
        this.prizeAmount = prizeAmount;
        this.requiredCorrectCount = requiredCorrectCount;
        this.requiresBonusNumber = requiresBonusNumber;
    }

    public String getName() {
        return name;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public int getRequiredCorrectCount() {
        return requiredCorrectCount;
    }

    public boolean requiresBonusNumber() {
        return requiresBonusNumber;
    }

}
