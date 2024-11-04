package lotto.model;

import java.util.List;

public class PrizeModel {
    public static PrizeModel prizeModel = new PrizeModel();
    private static List<Integer> prizeNumbers;
    private static int bonusNumber;

    private PrizeModel() {}

    public static List<Integer> getPrizeNumbers() {
        return prizeNumbers;
    }

    public static int getBonusNumber() {
        return bonusNumber;
    }

    public static void setPrizeNumbers(List<Integer> prizeNumbers) {
        PrizeModel.prizeNumbers = prizeNumbers;
    }

    public static void setBonusNumber(int bonusNumber) {
        PrizeModel.bonusNumber = bonusNumber;
    }
}
