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

        processLottos(winningNumbers, bonusNumber);
        generateRankResult(this.user);
    }

    private void processLottos(List<Integer> winningNumbers, int bonusNumber) {
        for (Lotto lotto : this.user.getLottos()) {
            long matchingCount = matchWinningNumberCount(lotto, winningNumbers);
            Rank rank = determineRank(matchingCount, lotto, bonusNumber);
            this.user.addRank(rank);
        }
    }

    private long matchWinningNumberCount(Lotto lotto, List<Integer> winningNumbers) {
        return lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private Rank determineRank(long matchingCount, Lotto lotto, int bonusNumber) {
        if (matchingCount == 5) {
            return drawBonus(lotto, bonusNumber);
        }
        return Rank.of(matchingCount);
    }

    private Rank drawBonus(Lotto lotto, int bonusNumber) {
        if (hasBonus(lotto, bonusNumber)) {
            return Rank.SECOND;
        }
        return Rank.THIRD;
    }

    private boolean hasBonus(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    private void generateRankResult(User user) {
        this.rankResult = new RankResult(user.getRanks());
    }

    public RankResult getRankResult() {
        return this.rankResult;
    }

    public User getUser() {
        return this.user;
    }
}
