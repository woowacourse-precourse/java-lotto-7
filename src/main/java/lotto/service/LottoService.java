package lotto.service;

import lotto.Lotto;

import java.util.List;

public class LottoService {
    public static final Integer LOTTO_PRICE = 1000;

    private final List<Integer> winningNumbers;
    private final Integer bonusWinningNumber;

    private List<Lotto> lottos;

    public LottoService(List<Integer> winningNumbers, Integer bonusWinningNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusWinningNumber = bonusWinningNumber;
    }
}
