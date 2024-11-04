package lotto.model.result;

import static lotto.common.Constants.*;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.model.lottery.Bonus;
import lotto.model.lottery.Winning;
import lotto.model.lottery.Lotto;
import lotto.model.lottery.PurchasedLotto;

public class Result {
    private static final String WINNING_DETAIL_FORMAT = "%s%d개\n";

    private final Map<Rank, Integer> winningDetails;

    // 클래스 내부(from()), 테스트 환경에서만 사용하도록 설계된 생성자입니다. 일반 환경에서는 객체 생성을 지양해주세요.
    Result(Map<Rank, Integer> winningDetails) {
        this.winningDetails = winningDetails;
    }

    public static Result from(Winning winning, Bonus bonus, PurchasedLotto purchasedLottos) {
        Map<Rank, Integer> winningDetails = initializeWinningDetails();
        for(Lotto purchasedLotto : purchasedLottos.get()) {
            int matchingCount = purchasedLotto.getMatchingCountWith(winning);
            boolean isBonusContained = purchasedLotto.isContained(bonus);
            Rank satisfiedRank = getSatisfiedRank(matchingCount, isBonusContained);
            if(satisfiedRank != null) {
                winningDetails.put(satisfiedRank, winningDetails.get(satisfiedRank) + 1);
            }
        }
        return new Result(winningDetails);
    }

    public Map<Rank, Integer> getWinningDetails() {
        return Collections.unmodifiableMap(winningDetails);
    }

    public String getFormattedWinningDetails() {
        return winningDetails.entrySet().stream()
                .map(entry -> getFormattedWinningDetail(entry.getKey(), entry.getValue()))
                .collect(Collectors.joining());
    }

    public long calculateTotalPrize() {
        return winningDetails.entrySet().stream()
                .mapToLong(entry -> entry.getKey()
                        .calculatePrize(entry.getValue()))
                .sum();
    }

    private static Map<Rank, Integer> initializeWinningDetails() {
        Map<Rank, Integer> winningDetails = new LinkedHashMap<>();
        for(Rank rank : Rank.values()) {
            winningDetails.put(rank, 0);
        }
        return winningDetails;
    }

    private static Rank getSatisfiedRank(int matchingCount, boolean isBonusContained) {
        if (matchingCount == FIRST_MATCHING_COUNT) return Rank.FIRST;
        if (matchingCount == SECOND_MATCHING_COUNT && isBonusContained) return Rank.SECOND;
        if (matchingCount == THIRD_MATCHING_COUNT) return Rank.THIRD;
        if (matchingCount == FOURTH_MATCHING_COUNT) return Rank.FOURTH;
        if (matchingCount == FIFTH_MATCHING_COUNT) return Rank.FIFTH;
        return null;
    }

    private String getFormattedWinningDetail(Rank condition, Integer count) {
        return String.format(WINNING_DETAIL_FORMAT, condition.getPrintFormat(), count);
    }
}
