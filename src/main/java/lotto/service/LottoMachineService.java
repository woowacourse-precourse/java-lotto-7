package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.Money;

import java.util.ArrayList;
import java.util.List;

public class LottoMachineService {
    private final LottoMachine lottoMachine;

    public LottoMachineService(LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    public List<Lotto> purchaseLottos(Money money) {
        int lottoCnt = getPurchaseAvailableCnt(money.getAmount());

        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoCnt; i++) {
            lottos.add(lottoMachine.generateLotto());
        }
        return lottos;
    }

    private int getPurchaseAvailableCnt(int amount) {
        return amount / LottoMachine.LOTTO_UNIT_PRICE;
    }

}
