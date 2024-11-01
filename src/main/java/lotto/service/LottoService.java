package lotto.service;

import lotto.domain.Consumer;
import lotto.domain.Lotto;
import lotto.util.Utils;

import java.util.List;

public class LottoService {

    private final static Integer LOTTO_START_NUMBER = 1;
    private final static Integer LOTTO_END_NUMBER = 45;
    private final static Integer LOTTO_MAX_LENGTH = 6;

    public void buyLottoes(Consumer consumer, int numberLimit) {
        int count = consumer.getMoney() / numberLimit;
        for (int i = 0; i < count; i++) {
            buyLotto(consumer);
        }
    }

    private void buyLotto(Consumer consumer) {
        Lotto lottoNumber = createLottoNumber();
        consumer.buyLotto(lottoNumber);
    }
    private Lotto createLottoNumber() {
        List<Integer> lottoNumbers = Utils.randomLottoNumbers(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_MAX_LENGTH);
        return new Lotto(lottoNumbers);
    }


}
