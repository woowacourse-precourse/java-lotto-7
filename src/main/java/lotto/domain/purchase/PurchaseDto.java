package lotto.domain.purchase;

import java.util.List;
import lotto.domain.lotto.LottoDto;

public class PurchaseDto {
    private final int amount;
    private final List<LottoDto> lottos;

    public PurchaseDto(int amount, List<LottoDto> lottos) {
        this.amount = amount;
        this.lottos = lottos;
    }

    public int getAmount() {
        return amount;
    }

    public List<LottoDto> getLottoDtos() {
        return lottos;
    }
}
