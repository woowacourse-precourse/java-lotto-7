package lotto.service;

import lotto.domain.Lottoes;
import lotto.domain.Money;

public class LottoService {

    public Lottoes createLottoes(Money money) {
        return Lottoes.from(money);
    }
}
