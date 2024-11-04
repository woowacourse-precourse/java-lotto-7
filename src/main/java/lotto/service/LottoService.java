package lotto.service;

import lotto.model.SystemLotto;
import lotto.model.UserLotto;
import lotto.util.Constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoService {
    private List<List<Integer>> purchasedLotto = new ArrayList<>();

    public void setPurchasedLotto(List<List<Integer>> purchasedLotto) {
        this.purchasedLotto = purchasedLotto;
    }

    public int calculateLottoCount(String purchaseAmount) {
        try {
            int amount = Integer.parseInt(purchaseAmount);

            if (amount == 0 || amount % Constants.LOTTO_PRICE != 0) {
                throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해 주세요.");
            }
            return amount / Constants.LOTTO_PRICE;

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주세요.");
        }
    }

    public List<String> purchaseLotto(int lottoCount) {
        List<String> sortedLotto = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            SystemLotto newLotto = new SystemLotto();
            purchasedLotto.add(newLotto.getNumbers());
            sortedLotto.add(newLotto.getSortedNumbers());
        }

        return sortedLotto;
    }

    public Map<String, Integer> matchLotto(UserLotto userLotto) {
        List<Integer> matchingCounts = new ArrayList<>();
        List<Boolean> matchingBonus = new ArrayList<>();

        for (List<Integer> systemLotto : purchasedLotto) {
            List<Integer> matchingNumbers = new ArrayList<>(userLotto.getNumbers());
            matchingNumbers.retainAll(systemLotto);
            matchingCounts.add(matchingNumbers.size());

            boolean isContainBonus = systemLotto.contains(userLotto.getBonusNumber());
            matchingBonus.add(isContainBonus);
        }

        return determineWinningRank(matchingCounts, matchingBonus);
    }

    private Map<String, Integer> determineWinningRank(List<Integer> matchingCounts, List<Boolean> matchingBonus) {
        Map<String, Integer> winningRank = new HashMap<>();

        for (int i = 0; i < matchingCounts.size(); i++) {
            String key = winningResult(matchingCounts.get(i), matchingBonus.get(i));

            int winningCount = winningRank.getOrDefault(key, 0) + Constants.WINNING_INCREMENT;
            winningRank.put(key, winningCount);
        }

        return winningRank;
    }

    private String winningResult(int count, Boolean isBonusMatched) {
        if (count == Constants.WINNING_SECOND_COUNT && isBonusMatched) {
            return Constants.WINNING_SECOND_STATUS;
        }

        if (count >= Constants.WINNING_MIN_COUNT) {
            return count + Constants.WINNING_COUNT_SUFFIX;
        }

        return null;
    }
}
