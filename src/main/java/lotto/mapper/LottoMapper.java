package lotto.mapper;

import java.util.Map.Entry;
import lotto.domain.LottoPrice;
import lotto.domain.Number;
import lotto.domain.lotto.Lotto;
import lotto.domain.util.LottoStatistics;
import lotto.view.dto.LottoCountResponse;
import lotto.view.dto.LottoErrorResponse;
import lotto.view.dto.LottoRankResponse;
import lotto.view.dto.LottoResponse;
import lotto.view.dto.ReturnRateResponse;

public class LottoMapper {

    public static LottoRankResponse toLottoRankResponse(Entry<LottoPrice, Integer> entry) {
        return new LottoRankResponse(
                entry.getKey().getLottoCount(),
                LottoStatistics.makeKoreaMoneyForm(entry.getKey().getLottoPrice()),
                entry.getValue(),
                entry.getKey().isBonus()
        );
    }

    public static LottoErrorResponse tolottoErrorResponse(String errorMessage) {
        return new LottoErrorResponse(errorMessage);
    }

    public static LottoCountResponse toLottoCountResponse(int lottoCount) {
        return new LottoCountResponse(lottoCount);
    }

    public static ReturnRateResponse toReturnRateResponse(double returnRate) {
        return new ReturnRateResponse(returnRate);
    }

    public static LottoResponse toLottoResponse(Lotto lotto) {
        return new LottoResponse(
                lotto.displayLotto()
                        .stream()
                        .map(Number::getNumber)
                        .toList()
        );
    }
}
