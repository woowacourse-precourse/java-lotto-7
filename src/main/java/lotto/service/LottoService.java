package lotto.service;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoService {
    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoService(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public List<Lotto> generateLotteryTickets(int quantity) {
        List<Lotto> lotteryTickets = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lotteryTickets.add(generateLotto());
        }
        return Collections.unmodifiableList(lotteryTickets);
    }

    private Lotto generateLotto() {
        return new Lotto(lottoNumberGenerator.getLottoNumber());
    }

}