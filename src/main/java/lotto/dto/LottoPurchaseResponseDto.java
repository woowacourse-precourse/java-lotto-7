package lotto.dto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoBundle;

public class LottoPurchaseResponseDto {

    private final int purchaseCount;
    private final List<List<Integer>> lottoBundle;

    public LottoPurchaseResponseDto(LottoBundle lottoBundle) {
        this.purchaseCount = lottoBundle.getLotteriesSize();
        this.lottoBundle = lottoBundle.getLotteries().stream()
                .map(Lotto::getNumbers)
                .toList();
    }

    public int getPurchaseCount() {
        return purchaseCount;
    }

    public List<List<Integer>> getLottoBundle() {
        return lottoBundle;
    }
}