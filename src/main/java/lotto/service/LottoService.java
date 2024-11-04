package lotto.service;

import lotto.model.IssuedLotto;

public class LottoService {
    public static int LOTTO_PRICES = 1000;

    private final IssuedLotto issuedLotto;

    public LottoService(IssuedLotto issuedLotto) {
        this.issuedLotto = issuedLotto;
    }

    public int lottoPurchase(int amount) {
        int numberOfLottoes = amount / LOTTO_PRICES;
        return numberOfLottoes;
    }

    public void lottoIssues(int numberOfLottoes) {
        issuedLotto.lottoIssues(numberOfLottoes);
    }
}
