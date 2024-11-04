package lotto.domain;

public class LottoResult {
    private final Winning winning;

    public LottoResult(Winning winning) {
        this.winning = winning;
    }

    // 당첨금 반환
    public int getReward() {
        return winning.getPrize();
    }

    public Winning getWinning() {
        return winning;
    }

    @Override
    public String toString() {
        if (winning == Winning.NONE) {
            return "미당첨";
        }

        if (winning == Winning.SECOND) {
            return String.format("5개 일치, 보너스 볼 일치 (%d원)", winning.getPrize());
        }

        int matchCount = switch (winning) {
            case FIRST -> 6;
            case THIRD -> 5;
            case FOURTH -> 4;
            case FIFTH -> 3;
            default -> 0;
        };

        return String.format("%d개 일치 (%d원)", matchCount, winning.getPrize());
    }
}