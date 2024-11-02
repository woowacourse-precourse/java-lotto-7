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

            WinningLotto rank = determineRank(matchCount, lotto, bonusNumber);
            user.addWinning(rank);
        }

        determineRankResult(this.user);
    }

    private long matchWinningNumberCount(Lotto lotto, List<Integer> winningNumbers) {
        return lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private WinningLotto determineRank(long matchCount, Lotto lotto, int bonusNumber) {
        if (matchCount == 5) {
            return drawBonus(lotto, bonusNumber);
        }
        return WinningLotto.from(matchCount);
    }

    private WinningLotto drawBonus(Lotto lotto, int bonusNumber) {
        boolean hasBonus = isHasBonus(lotto, bonusNumber);
        if (hasBonus) {
            return WinningLotto.SECOND;
        }
        return WinningLotto.THIRD;
    }

    private boolean isHasBonus(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    private void determineRankResult(User user) {
        this.rankResult = new RankResult(user.getWinningLottos());
    }

    public RankResult getRankResult() {
        return this.rankResult;
    }

    public User getUser() {
        return this.user;
    }
}
