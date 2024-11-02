package domain;

import java.util.List;

public class LottoPlay {

    private final User user;
    private final LottoMachine lottoMachine;
    private RankResult rankResult;

    public LottoPlay(User user, LottoMachine lottoMachine) {
        this.user = user;
        this.lottoMachine = lottoMachine;
    }

    public void drawLottos() {
        List<Integer> winningNumbers = this.lottoMachine.getWinningNumbers();
        int bonusNumber = this.lottoMachine.getBonusNumber();

        for (Lotto lotto : this.user.getLottos()) {
            long matchCount = matchWinningNumberCount(lotto, winningNumbers);

            Rank rank = determineRank(matchCount, lotto, bonusNumber);
            this.user.addRank(rank);
        }

        determineRankResult(this.user);
    }

    private long matchWinningNumberCount(Lotto lotto, List<Integer> winningNumbers) {
        return lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private Rank determineRank(long matchCount, Lotto lotto, int bonusNumber) {
        if (matchCount == 5) {
            return drawBonus(lotto, bonusNumber);
        }
        return Rank.of(matchCount);
    }

    private Rank drawBonus(Lotto lotto, int bonusNumber) {
        if (isHasBonus(lotto, bonusNumber)) {
            return Rank.SECOND;
        }
        return Rank.THIRD;
    }

    private boolean isHasBonus(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    private void determineRankResult(User user) {
        this.rankResult = new RankResult(user.getRanks());
    }

    public RankResult getRankResult() {
        return this.rankResult;
    }

    public User getUser() {
        return this.user;
    }
}
