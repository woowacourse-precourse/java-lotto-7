package lotto.shop.bandingmachine;

import java.util.List;
import lotto.MessageCenter;

public class TrialHistory {

    private Integer payment;
    private Integer totalCount;
    private Integer printCount;
    private List<DrawnNumbers> drawnNumberPacks;

    void savePayment(Integer money) {
        validatePayment();
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

    public Integer getPayment() {
        return payment;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public Integer getPrintCount() {
        return printCount;
    }

    public List<DrawnNumbers> getDrawnNumberPacks() {
        validatePacks();
        return drawnNumberPacks;
    }

    private void validatePayment() {
        if (payment != null) {
            throw new IllegalArgumentException(MessageCenter.ERROR_PAID.get());
        }
    }

    private void validatePacks() {
        if (drawnNumberPacks == null || drawnNumberPacks.isEmpty()) {
            throw new IllegalArgumentException(MessageCenter.ERROR_SAVE.get());
        }
    }

}
