package lotto.dto;

import java.util.HashMap;
import lotto.dto.data.Receipt;
import lotto.utils.LottoMatchStatus;

public class ProfitDto {
    private HashMap<LottoMatchStatus, Integer> lottoResult;
    private Receipt receipt;

    public ProfitDto(HashMap<LottoMatchStatus, Integer> lottoResult, Receipt receipt) {
        this.lottoResult = lottoResult;
        this.receipt = receipt;
    }

    public HashMap<LottoMatchStatus, Integer> getLottoResult() {
        return lottoResult;
    }

    public Receipt getReceipt() {
        return receipt;
    }
}
