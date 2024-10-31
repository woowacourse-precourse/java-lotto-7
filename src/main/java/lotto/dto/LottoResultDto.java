package lotto.dto;

import lotto.Lotto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoResultDto {

    private final int purchaseQuantity;
    private final List<Lotto> lottoList;

    public LottoResultDto(int purchaseQuantity, List<Lotto> lottoList) {
        this.purchaseQuantity = purchaseQuantity;
        this.lottoList = lottoList;
    }

    public int getPurchaseQuantity() {
        return purchaseQuantity;
    }

    public List<List<Integer>> getLottoList() {
        return lottoList.stream()
                .map(lotto -> lotto.getNumbers().stream()
                        .sorted()
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }
}
