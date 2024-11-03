package lotto.global.dto.response;

import java.util.List;
import lotto.back.domain.Lotto;

public record LottoPurchaseResponseDTO(List<List<Integer>> lottoNumberSets) {

    public static LottoPurchaseResponseDTO from(List<Lotto> lottos) {
        return new LottoPurchaseResponseDTO(lottos.stream().map(Lotto::getLottoNumbers).toList());
    }
}
