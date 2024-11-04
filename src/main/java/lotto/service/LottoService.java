package lotto.service;

import lotto.Lotto;
import lotto.model.IssuedLotto;

import java.util.ArrayList;
import java.util.List;

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

    public List<List<Integer>> lottoIssues(int numberOfLottoes) {
        return issuedLotto.lottoIssues(numberOfLottoes);
    }

    public void winningNumber(String winningNum) {
        List<Integer> number = new ArrayList<>();
        List<String> numString = List.of(winningNum.split(","));

        for (String num : numString) {
            number.add(Integer.parseInt(num.trim()));
        }

        Lotto lotto = new Lotto(number);
    }
}
