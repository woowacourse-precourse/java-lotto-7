package lotto.dto;

import java.util.List;
import lotto.model.MyLotto;

public record EarnedLottos(List<EarnedLotto> lottosDto) {
    public static EarnedLottos from (MyLotto myLotto) {
        return new EarnedLottos(myLotto.getLottos().stream()
                .map(lotto -> new EarnedLotto(lotto.getNumbers()))
                .toList());
    }
}
