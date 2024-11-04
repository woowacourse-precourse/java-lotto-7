package lotto.dto;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.model.Lottos;

public record LottosDTO(
        List<InnerLottoNumbers> lottos
) {
    public static LottosDTO from(Lottos lottos) {
        return new LottosDTO(
                lottos.getLottos()
                        .stream()
                        .map(InnerLottoNumbers::from)
                        .toList()
        );
    }

    public record InnerLottoNumbers(List<Integer> numbers) {

        public static InnerLottoNumbers from(Lotto lotto) {
            return new InnerLottoNumbers(
                    lotto.getNumbers()
                            .stream()
                            .map(LottoNumber::getNumber)
                            .toList()
            );
        }
    }
}
