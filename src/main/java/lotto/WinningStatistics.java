package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.WinningCategory.*;

public class WinningStatistics {
    private static final List<WinningCategory> PRINT_ORDER = List.of(
            THREE_MATCH, FOUR_MATCH, FIVE_MATCH, FIVE_MATCH_WITH_BONUS, SIX_MATCH
    );
    private static final int PERCENTAGE_FACTOR = 100;
    private static final double ROUNDING_FACTOR = 100.0;
    private final List<Lotto> purchasedLottos;
    private final Lotto winningLotto;
    private final int bonusNumber;
    private final Map<WinningCategory, Integer> statistics;

    public WinningStatistics(List<Lotto> purchasedLottos, Lotto winningLotto, int bonusNumber) {
        this.purchasedLottos = purchasedLottos;
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
        this.statistics = new HashMap<>();

        for (WinningCategory category : WinningCategory.values()) {
            statistics.put(category, 0);
        }
    }

    public Map<WinningCategory, Integer> getStatistics() {
        return statistics;
    }

    public List<Lotto> getPurchasedLottos() {
        return purchasedLottos;
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private boolean hasBonus(Lotto lotto) {
        return lotto.getLottoNumbers().stream()
                .anyMatch(number -> number == bonusNumber);
    }

    private int getMatchCount(Lotto lotto) {
        return (int) lotto.getLottoNumbers().stream()
                .filter(number -> winningLotto.getLottoNumbers().stream()
                        .anyMatch(Predicate.isEqual(number)))
                .count();
    }

    private WinningCategory determineCategory(Lotto lotto, int matchCount, boolean hasBonus) {
        for (WinningCategory category : WinningCategory.values()) {
            if (category.getMatchCount() == matchCount && category.hasBonus() == hasBonus) {
                return category;
            }
        }
        return NO_WIN;
    }

    public WinningCategory getWinningCategory(Lotto lotto) {
        int matchCount = getMatchCount(lotto);
        boolean hasBonus = hasBonus(lotto);
        return determineCategory(lotto, matchCount, hasBonus);
    }

    public void countWinningCategory(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            WinningCategory winningCategory = getWinningCategory(lotto);
            statistics.put(winningCategory, statistics.get(winningCategory) + 1);
        }
    }

    public void printStatistics() {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (WinningCategory category : PRINT_ORDER) {
            System.out.print(category.getMatchCount() + "개 일치");
            if (category == FIVE_MATCH_WITH_BONUS) {
                System.out.print(", 보너스 볼 일치");
            }
            System.out.print(" (" + String.format("%,d", category.getPrize()) + "원) - ");
            System.out.println(statistics.get(category) + "개");
        }
    }

    private int getTotalPrize() {
        int totalPrize = 0;
        for (WinningCategory category : WinningCategory.values()) {
            int prize = category.getPrize();
            int count = statistics.get(category);
            totalPrize += prize * count;
        }
        return totalPrize;
    }

    private double calculateProfitRate(int budget) {
        double profitRate = ((double) getTotalPrize() / budget) * PERCENTAGE_FACTOR;
        return Math.round(profitRate * ROUNDING_FACTOR) / ROUNDING_FACTOR;
    }

    public void printProfitRate(int budget) {
        System.out.println("총 수익률은 " + calculateProfitRate(budget) + "%입니다.");
    }
}
