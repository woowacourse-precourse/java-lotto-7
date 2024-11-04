package lotto.service;

import lotto.model.Lotto;

import java.util.List;

public class LottoResultService {
    private List<Lotto> lottos;
    private Lotto winningLotto;
    private int bonusNumber;

    public LottoResultService(List<Lotto> lottos, Lotto winningLotto, int bonusNumber) {
        this.lottos = lottos;
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }



}
