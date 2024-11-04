package lotto.dto;

import java.util.List;

public class PurchaseResponse {
    private Integer purchaseLottoCount;
    private List<List<Integer>> purchaseLottos;

    public PurchaseResponse(Integer purchaseLottoCount, List<List<Integer>> purchaseLottos) {
        this.purchaseLottoCount = purchaseLottoCount;
        this.purchaseLottos = purchaseLottos;
    }

    public Integer getPurchaseLottoCount() {
        return purchaseLottoCount;
    }
    public List<List<Integer>> getPurchaseLottos() {
        return purchaseLottos;
    }
}
