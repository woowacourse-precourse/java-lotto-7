package lotto.shop.bandingmachine;

import java.util.List;

public class TrialHistory {

    private Integer payment;
    private Integer totalCount;
    private Integer printCount;
    private List<DrawnNumbers> drawnNumberPacks;

    void savePayment(Integer money) {
        this.payment = money;
    }

    void saveTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    void savePrintCount(Integer printCount) {
        this.printCount = printCount;
    }

    void saveDrawnNumberPacks(List<DrawnNumbers> drawnNumberPacks) {
        this.drawnNumberPacks = drawnNumberPacks;
    }

    Integer getPayment() {
        return payment;
    }

    Integer getTotalCount() {
        return totalCount;
    }

    Integer getPrintCount() {
        return printCount;
    }

    List<DrawnNumbers> getDrawnNumberPacks() {
        return drawnNumberPacks;
    }

}
