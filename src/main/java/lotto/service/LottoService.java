package lotto.service;

import lotto.model.SystemLotto;
import lotto.model.UserLotto;
import lotto.model.WinningLotto;
import lotto.util.Constants;

import java.util.List;
import java.util.ArrayList;

import static lotto.model.WinningLotto.*;

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

    public void matchLotto(UserLotto userLotto) {
        List<Integer> matchingCounts = new ArrayList<>();
        List<Boolean> matchingBonus = new ArrayList<>();

        for (List<Integer> systemLotto : purchasedLotto) {
            List<Integer> matchingNumbers = new ArrayList<>(userLotto.getNumbers());
            matchingNumbers.retainAll(systemLotto);
            matchingCounts.add(matchingNumbers.size());

            boolean isContainBonus = systemLotto.contains(userLotto.getBonusNumber());
            matchingBonus.add(isContainBonus);
        }

        determineWinningRank(matchingCounts, matchingBonus);
    }

    private void determineWinningRank(List<Integer> matchingCounts, List<Boolean> matchingBonus) {
        for (int i = 0; i < matchingCounts.size(); i++) {
            WinningLotto winningLotto = winningResult(matchingCounts.get(i), matchingBonus.get(i));

            if (winningLotto != null) {
                winningLotto.incrementMatchCount();
            }
        }
    }

    private WinningLotto winningResult(int count, Boolean isBonusMatched) {
        if (count == 3) {
            return THREE_MATCH;
        }
        if (count == 4) {
            return FOUR_MATCH;
        }
        if (count == 5 && isBonusMatched) {
            return FIVE_MATCH_BONUS;
        }
        if (count == 5) {
            return FIVE_MATCH;
        }
        if (count == 6) {
            return SIX_MATCH;
        }

        return null;
    }
}
