package lotto.service;

import lotto.Lotto;
import lotto.model.IssuedLotto;

import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoService {
    public static int LOTTO_PRICES = 1000;
    public static List<Integer> NUMBER = new ArrayList<>();
    public static int BONUS_NUMBER = 0;
    public static Map<String, Integer> MATCHING_NUMBERS = new HashMap<>();

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

    public Map<String, Integer> winningStatistics() {
        List<List<Integer>> issuedLottoNumbers = issuedLotto.ISSUED_LOTTO_NUMBERS;

        MATCHING_NUMBERS.put("3",0);
        MATCHING_NUMBERS.put("4",0);
        MATCHING_NUMBERS.put("5",0);
        MATCHING_NUMBERS.put("5,bonus",0);
        MATCHING_NUMBERS.put("6",0);

        for (int i=0; i<issuedLottoNumbers.size(); i++) {
            List<Integer> issuedLottoNum = issuedLottoNumbers.get(i);
            int matchingNumCount = 0;

            checkNumberOfMatchingNumber(issuedLottoNum, checkMatchingNumber(issuedLottoNum, matchingNumCount));
        }
        return MATCHING_NUMBERS;
    }

    public int checkMatchingNumber(List<Integer> issuedLottoNum, int matchingNumCount) {
        for (Integer num : NUMBER) {
            if (issuedLottoNum.contains(num)) {
                matchingNumCount++;
            }
        }
        return matchingNumCount;
    }

    public void checkNumberOfMatchingNumber(List<Integer> issuedLottoNum, int matchingNumCount) {
        if (matchingNumCount == 3) {
            int count = MATCHING_NUMBERS.get("3");
            MATCHING_NUMBERS.put("3", count+1);
        }
        if (matchingNumCount == 4) {
            int count = MATCHING_NUMBERS.get("4");
            MATCHING_NUMBERS.put("4", count+1);
        }
        if (matchingNumCount == 5 && issuedLottoNum.contains(BONUS_NUMBER)) {
            int count = MATCHING_NUMBERS.get("5,bonus");
            MATCHING_NUMBERS.put("5,bonus", count+1);
        }
        if (matchingNumCount == 5) {
            int count = MATCHING_NUMBERS.get("5");
            MATCHING_NUMBERS.put("5", count+1);
        }
        if (matchingNumCount == 6) {
            int count = MATCHING_NUMBERS.get("6");
            MATCHING_NUMBERS.put("6", count+1);
        }
    }
}
