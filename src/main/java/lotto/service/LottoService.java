package lotto.service;

import lotto.Lotto;
import lotto.model.IssuedLotto;

import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.util.ArrayList;
import java.util.List;

public class LottoService {
    public static int LOTTO_PRICES = 1000;
    public static List<Integer> NUMBER = new ArrayList<>();
    public static int BONUS_NUMBER = 0;

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
        List<String> numString = List.of(winningNum.split(","));

        for (String num : numString) {
            NUMBER.add(Integer.parseInt(num.trim()));
        }

        Lotto lotto = new Lotto(NUMBER);
    }

    public void bonusNumber(String bonusNum) {
        BONUS_NUMBER = Integer.parseInt(bonusNum);
    }
}
