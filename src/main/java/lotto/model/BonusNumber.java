package lotto.model;

public class BonusNumber {

    private final Integer bonusNumber;

    private BonusNumber(String userInputBonusNumber) {
        this.bonusNumber = parseUserInputBonusNumber(userInputBonusNumber);
    }

    public static BonusNumber of(String userInputBonusNumber){
        return new BonusNumber(userInputBonusNumber);
    }

    private Integer parseUserInputBonusNumber(String userInputBonusNumber){
        return 0;
    }
}
