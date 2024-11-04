package lotto.dto;

import java.math.BigDecimal;
import lotto.domain.LottoResult;

public class ResultMarginDTO {
    private final LottoResult lottoResult;
    private final BigDecimal margin;

    private ResultMarginDTO(LottoResult lottoResult, BigDecimal margin) {
        this.lottoResult = lottoResult;
        this.margin = margin;
    }

    public static ResultMarginDTO from(LottoResult lottoResult, BigDecimal margin) {
        return new ResultMarginDTO(lottoResult, margin);
    }

    public LottoResult getLottoResult() {
        return lottoResult;
    }

    public BigDecimal getMargin() {
        return margin;
    }
}
