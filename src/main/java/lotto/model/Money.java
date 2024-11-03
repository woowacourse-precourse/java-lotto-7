package lotto.model;

import java.text.DecimalFormat;

public class Money {
    private final long purchaseAmount;

    public Money(long purchaseAmount) {
        checkPurchaseAmountIsThousandUnit(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public long getThousandUnitCount() {
        return purchaseAmount / 1000;
    }

    public String calculateReturnRate(long totalPrizeMoney) {
        double returnRate = ((double) totalPrizeMoney / purchaseAmount) * 100.0;
        returnRate = Math.round(returnRate * 100) / 100.0; // 소수점 둘째 자리 반올림
        // 천 단위 구분 기호와 소수점 둘째 자리까지 포맷 설정
        DecimalFormat df = new DecimalFormat("#,##0.0");
        return df.format(returnRate) + "%";
    }

    private void checkPurchaseAmountIsThousandUnit(long purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 천원 단위로만 입력해주세요.");
        }
    }
}
