package lotto;

import java.util.List;

public enum LottoRank {
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원)"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원)"),
    FOURTH(4, 50_000, "4개 일치 (50,000원)"),
    FIFTH(3, 5_000, "3개 일치 (5,000원)"),
    NONE(0, 0, "꽝");

    private final int matchCount;
    private final int prize;
    private final String description;

    // Enum 생성자
    LottoRank(int matchCount, int prize, String description) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.description = description;
    }

    public int getPrize() {
        return prize;
    }

    public String getDescription() {
        return description;
    }

    // 로또 등수를 계산하는 메서드
    public static LottoRank calculate(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        // 일치하는 번호 개수 계산
        int matchCount = (int) lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
        // 보너스 번호가 포함되어 있는지 확인
        boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);

        // 등수 판별
        if (matchCount == 6) {
            return FIRST;
        }
        if (matchCount == 5 && bonusMatch) {
            return SECOND;
        }
        if (matchCount == 5) {
            return THIRD;
        }
        if (matchCount == 4) {
            return FOURTH;
        }
        if (matchCount == 3) {
            return FIFTH;
        }
        return NONE;
    }
}