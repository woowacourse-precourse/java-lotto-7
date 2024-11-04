package lotto.dto;

import java.util.List;
import lotto.dto.data.Lotto;
import lotto.dto.data.Receipt;

public class ReceiptAndLottoDto {
    private Receipt receipt;
    private List<Lotto> lottos;

    public ReceiptAndLottoDto(Receipt receipt, List<Lotto> lottos) {
        this.receipt = receipt;
        this.lottos = lottos;
    }

    public Receipt getReceipt() {
        return receipt;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
