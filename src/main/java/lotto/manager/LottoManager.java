package lotto.manager;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.UserLotto;
import lotto.enums.LottoNumberConstants;
import lotto.enums.PriceConstants;
import lotto.enums.RankConstants;

public class LottoManager {
    private final List<LottoRank> ranks = new ArrayList<>();

    public LottoManager() {
        ranks.add(new LottoRank(RankConstants.FIRST_PRIZE, RankConstants.FIRST_PRIZE_AMOUNT,
                RankConstants.FIRST_PRIZE_WINNING_COUNT, false));
        ranks.add(new LottoRank(RankConstants.SECOND_PRIZE, RankConstants.SECOND_PRIZE_AMOUNT,
                RankConstants.SECOND_PRIZE_WINNING_COUNT, true));
        ranks.add(new LottoRank(RankConstants.THIRD_PRIZE, RankConstants.THIRD_PRIZE_AMOUNT,
                RankConstants.THIRD_PRIZE_WINNING_COUNT, false));
        ranks.add(new LottoRank(RankConstants.FOURTH_PRIZE, RankConstants.FOURTH_PRIZE_AMOUNT,
                RankConstants.FOURTH_PRIZE_WINNING_COUNT, false));
        ranks.add(new LottoRank(RankConstants.FIFTH_PRIZE, RankConstants.FIFTH_PRIZE_AMOUNT,
                RankConstants.FIFTH_PRIZE_WINNING_COUNT, false));
    }

    public List<Lotto> generateLotteries(int purchaseAmount) {
        int lottoCount = purchaseAmount / PriceConstants.LOTTO_PRICE;
        List<Lotto> lotteries = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            lotteries.add(new Lotto(generateLotto()));
        }
        return lotteries;
    }

    public void executeWinningProcess(UserLotto userLotto, List<Integer> winningNumbers, int bonusNumber) {
        for (Lotto lotto : userLotto.getLotteries()) {
            List<Integer> numbers = lotto.getNumbers();
            int matchedNumbersCount = countMatchingNumbers(numbers, winningNumbers);
            boolean isMatchedBonusNumber = checkMatchingBonusNumber(numbers, bonusNumber);
            updateWinningCount(userLotto, matchedNumbersCount, isMatchedBonusNumber);
        }
    }

    public float calculateTotalPrizeRate(UserLotto userLotto, int purchaseAmount) {
        int totalPrize = calculateTotalPrize(userLotto);
        return (float) totalPrize / purchaseAmount * 100;
    }

    private int calculateTotalPrize(UserLotto userLotto) {
        int totalPrize = 0;
        for (LottoRank rank : ranks) {
            int winningCount = userLotto.getWinningCount(rank.rank());
            totalPrize += winningCount * rank.prizeAmount();
        }

        return totalPrize;
    }

    private int countMatchingNumbers(List<Integer> lotto, List<Integer> winningNumbers) {
        List<Integer> tempLotto = new ArrayList<>(lotto);
        tempLotto.retainAll(winningNumbers);
        return tempLotto.size();
    }

    private boolean checkMatchingBonusNumber(List<Integer> lotto, int bonusNumber) {
        return lotto.contains(bonusNumber);
    }

    private void updateWinningCount(UserLotto userLotto, int matchedNumbersCount, boolean isMatchedBonusNumber) {
        for (LottoRank rank : ranks) {
            if (rank.isWinning(matchedNumbersCount, isMatchedBonusNumber)) {
                userLotto.updateWinningCount(rank.rank());
                break;
            }
        }
    }

    private List<Integer> generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LottoNumberConstants.MIN_VALUE.getValue(),
                LottoNumberConstants.MAX_VALUE.getValue(), LottoNumberConstants.NUMBER_COUNT.getValue());
        return numbers.stream().sorted().toList();
    }

}
