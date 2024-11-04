package lotto.shop.bandingmachine;

import java.util.List;
import lotto.MessageCenter;

public class TrialHistory {

    private Integer payment;
    private Integer totalCount;
    private List<DrawnNumbers> drawnNumberPacks;

    void savePayment(Integer money) {
        validatePayment(money);
        this.payment = money;
    }

    void saveTotalCount(Integer totalCount) {
        validateCount(totalCount);
        this.totalCount = totalCount;
    }

    void saveDrawnNumberPacks(List<DrawnNumbers> drawnNumberPacks) {
        validatePacks(drawnNumberPacks);
        this.drawnNumberPacks = drawnNumberPacks;
    }

    public Integer getPayment() {
        validatePaymentNotNull();
        return payment;
    }

    public Integer getTotalCount() {
        validateCountNotNull();
        return totalCount;
    }

    public List<DrawnNumbers> getDrawnNumberPacks() {
        validatePacksNotNull();
        return drawnNumberPacks;
    }

    void clean() {
        this.payment = null;
        this.totalCount = null;
        this.drawnNumberPacks = null;
    }

    private void validatePayment(Integer money) {
        if (payment != null || money == null
                || money <= 0 || (money % 1000) != 0) {
            throw new IllegalArgumentException(MessageCenter.ERROR_PAID.get());
        }
    }

    private void validateCount(Integer count) {
        if (totalCount != null || count == null || count <= 0)  {
            throw new IllegalArgumentException(MessageCenter.ERROR_PAID.get());
        }
    }

    private void validatePacks(List<DrawnNumbers> drawnNumberPacks) {
        if (this.drawnNumberPacks != null || drawnNumberPacks == null) {
            throw new IllegalArgumentException(MessageCenter.ERROR_DRAWN.get());
        }
    }

    private void validatePaymentNotNull() {
        if (payment == null) {
            throw new IllegalArgumentException(MessageCenter.ERROR_PAYMENT.get());
        }
    }

    private void validateCountNotNull() {
        if (totalCount == null) {
            throw new IllegalArgumentException(MessageCenter.ERROR_COUNT.get());
        }
    }

    private void validatePacksNotNull() {
        if (drawnNumberPacks == null || drawnNumberPacks.isEmpty()) {
            throw new IllegalArgumentException(MessageCenter.ERROR_SAVE.get());
        }
    }

}
