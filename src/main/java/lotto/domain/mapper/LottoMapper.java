package lotto.domain.mapper;

import java.util.Map.Entry;
import lotto.domain.rank.LottoPrice;
import lotto.domain.util.LottoStatistics;
import lotto.view.dto.LottoCountResponse;
import lotto.view.dto.LottoErrorResponse;
import lotto.view.dto.LottoRankResponse;

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
}
