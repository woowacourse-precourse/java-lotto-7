package lotto.global.dto.response;

import java.util.List;
import lotto.back.lotto.domain.result.LottoResult;
import lotto.global.status.LottoStatus;

public record LottoResultResponseDTO(List<Integer> numbers, LottoStatus lottoStatus) {

    public static LottoResultResponseDTO from(LottoResult lottoResult) {
        return new LottoResultResponseDTO(lottoResult.getLotto().getNumbers(), lottoResult.getLottoStatus());
    }
}
