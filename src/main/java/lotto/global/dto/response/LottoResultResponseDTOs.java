package lotto.global.dto.response;

import java.util.List;
import lotto.back.lotto.domain.result.LottoResults;

public record LottoResultResponseDTOs(List<LottoResultResponseDTO> lottoResults, Double profitRate) {

    public static LottoResultResponseDTOs from(LottoResults lottoResults, Double profit) {
        return new LottoResultResponseDTOs(
                lottoResults.getLottoResults().stream()
                        .map(LottoResultResponseDTO::from)
                        .toList(),
                profit
        );
    }
}
