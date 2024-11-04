package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.enums.Winnings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Order {
    private static final int BONUS_MATCH_INDEX = 7;
    private static final int REQUIRED_MATCH_WITH_BONUS = 5;

    public final LottoRound lottoRound;
    public final int orderCount;
    public final List<Lotto> orderedLottos;
    private final List<Integer> matchCounts;

    public Order(LottoRound lottoRound, int orderCount) {
        this.lottoRound = lottoRound;
        this.orderCount = orderCount;
        this.orderedLottos = generateOrderedLotto(orderCount);
        this.matchCounts = new ArrayList<>(Collections.nCopies(8, 0));
    }

    private List<Lotto> generateOrderedLotto(int orderCount) {
        List<Lotto> orderedLottos = new ArrayList<>();
        for (int i = 0; i < orderCount; i++) {
            Lotto lotto = createRandomLotto();
            System.out.println(lotto);
            orderedLottos.add(lotto);
        }
        return orderedLottos;
    }

    private Lotto createRandomLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    public void calculateMatchCounts() {
        for (Lotto lotto : orderedLottos) {
            int matchCount = lotto.countMatchingNumbers(lottoRound.getWinningLotto());
            boolean hasBonusNumber = lotto.hasBonusNumber(lottoRound.getBonusNumber());
            updateMatchCounts(matchCount, hasBonusNumber);
        }
    }

    private void updateMatchCounts(int matchCount, boolean hasBonusNumber) {
        if (isBonusMatch(matchCount, hasBonusNumber)) matchCount = BONUS_MATCH_INDEX;
        incrementMatchCount(matchCount);
    }

    private boolean isBonusMatch(int matchCount, boolean hasBonusNumber) {
        return matchCount == REQUIRED_MATCH_WITH_BONUS && hasBonusNumber;
    }

    private void incrementMatchCount(int index) {
        matchCounts.set(index, matchCounts.get(index) + 1);
    }

    public double calculateTotalProfit() {
        double winAmount = calculateWinAmount();
        return (winAmount / (orderCount * 1000)) * 100;
    }

    private double calculateWinAmount() {
        double winAmount = 0;
        for (Winnings winnings : Winnings.values()) {
            int count = matchCounts.get(winnings.getMatchCount());
            winAmount += winnings.getPrize() * count;
        }
        return winAmount;
    }

    public int getOrderCount() {
        return orderCount;
    }

    public List<Integer> getMatchCounts() {
        return matchCounts;
    }

    @Override
    public String toString() {
        return orderedLottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }
}
