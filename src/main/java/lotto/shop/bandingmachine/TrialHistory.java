package lotto.shop.bandingmachine;

import java.util.List;

public class TrialHistory {

    private Integer wonInput;
    private Integer totalCount;
    private Integer printCount;
    private List<List<Integer>> tempMainPacks;
    private List<Integer> tempBonusPacks;

    void savePayment(Integer money) {
        this.wonInput = money;
    }

    void saveTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    void savePrintCount(Integer printCount) {
        this.printCount = printCount;
    }

    void saveTempMain(List<Integer> mainNumbers) {
        tempMainPacks.add(mainNumbers);
    }

    void saveTempBonus(Integer bonusNumber) {
        tempBonusPacks.add(bonusNumber);
    }

    Integer getWonInput() {
        return wonInput;
    }

    Integer getTotalCount() {
        return totalCount;
    }

    Integer getPrintCount() {
        return printCount;
    }

    List<List<Integer>> getTempMainPacks() {
        return tempMainPacks;
    }

    List<Integer> getTempBonusPacks() {
        return tempBonusPacks;
    }

}
