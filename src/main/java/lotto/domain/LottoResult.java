package lotto.domain;

public class LottoResult {
    private final Winning winning;

    public LottoResult(Winning winning) {
        this.winning = winning;
    }

    // 당첨금 반환
    public int getPrize() {
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
            return String.format("5개 일치, 보너스 볼 일치 (%,d원)", winning.getPrize());
        }

        if (winning == Winning.FIRST) {
            return String.format("6개 일치 (%,d원)", winning.getPrize());
        }

        if (winning == Winning.THIRD) {
            return String.format("5개 일치 (%,d원)", winning.getPrize());
        }

        if (winning == Winning.FOURTH) {
            return String.format("4개 일치 (%,d원)", winning.getPrize());
        }

        return String.format("3개 일치 (%,d원)", winning.getPrize());
    }
}