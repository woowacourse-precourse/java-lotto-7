package lotto.dto;

import java.util.Map;
import lotto.model.win.Prize;

public record LottoResult(double rate, Map<Prize, Long> prizeTable) {

    public static LottoResultBuilder builder() {
        return new LottoResultBuilder();
    }

    @Override
    public double rate() {
        return rate;
    }
}
