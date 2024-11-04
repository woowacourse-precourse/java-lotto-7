package lotto.domain;

import java.math.BigDecimal;
import java.util.List;

public record LottoPurchaseInfo(BigDecimal purchaseAmount, Lotto lottoNumbers, int bonusNumber) {

    public LottoPurchaseInfo(BigDecimal purchaseAmount, List<Integer> lottoNumbers, int bonusNumber) {
        this(purchaseAmount, new Lotto(lottoNumbers), bonusNumber);
    }
}
