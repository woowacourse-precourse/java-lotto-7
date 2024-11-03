package lotto.dto;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.Lottos;

public record LottosDTO(
        List<LottoNumbers> lottos
) {
    public static LottosDTO from(Lottos lottos) {
        return new LottosDTO(lottos.getLottos()
                .stream()
                .map(LottoNumbers::from)
                .toList()
        );
    }

    public record LottoNumbers(List<Integer> numbers) {

        public static LottoNumbers from(Lotto lotto) {
            return new LottoNumbers(lotto.getNumbers());
        }
    }
}
