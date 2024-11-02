package lotto.constant;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public enum Prize {
    FIRST(6, false, 2_000_000_000, "6개 일치 (2,000,000,000원)"),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(5, false, 1_500_000, "5개 일치 (1,500,000원)"),
    FOURTH(4, false, 50_000, "4개 일치 (50,000원)"),
    FIFTH(3, false, 5_000, "3개 일치 (5,000원)");

    private final int lottoNumberMatchCount;
    private final boolean shouldMatchBonus;
    private final int earning;
    private final String description;

    Prize(final int lottoNumberMatchCount, final boolean shouldMatchBonus, final int earning, String description) {
        this.lottoNumberMatchCount = lottoNumberMatchCount;
        this.shouldMatchBonus = shouldMatchBonus;
        this.earning = earning;
        this.description = description;
    }

    public static Prize getPrize(final int matchedLottoNumberCount, final boolean matchedBonus) {
        // 조건에 맞는 상품이 여러 개일 수 있어서 당첨금이 가장 큰 거부터 확인
        // 예: 2등, 3등; 보너스밖에 차이가 없다.
        for (Prize prize : prizesOrderedBy(earningDescending())) {
            if (prize.matches(matchedLottoNumberCount, matchedBonus)) {
                return prize;
            }
        }
        return null;
    }

    private boolean matches(final int matchedLottoNumberCount, final boolean matchedBonus) {
        if (this.lottoNumberMatchCount != matchedLottoNumberCount) {
            return false;
        }

        if (this.shouldMatchBonus) {
            return matchedBonus;
        }

        return true;
    }

    public static List<Prize> prizesOrderedBy(Comparator<Prize> comparator) {
        return Arrays.stream(Prize.values())
                .sorted(comparator)
                .toList();
    }

    public static Comparator<Prize> earningAscending() {
        return (a, b) -> a.getEarning() - b.getEarning();
    }

    public static Comparator<Prize> earningDescending() {
        return (a, b) -> b.getEarning() - a.getEarning();
    }

    public int getEarning() {
        return earning;
    }

    public String getDescription() {
        return description;
    }
}
