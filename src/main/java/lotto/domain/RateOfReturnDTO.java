package lotto.domain;

import java.math.BigDecimal;

public class RateOfReturnDTO {
    private BigDecimal rateOfReturn;

    public RateOfReturnDTO(BigDecimal rateOfReturn) {
        this.rateOfReturn = rateOfReturn;
    }

    public BigDecimal getRateOfReturn() {
        return rateOfReturn;
    }

    public void setRateOfReturn(BigDecimal rateOfReturn) {
        this.rateOfReturn = rateOfReturn;
    }
}
