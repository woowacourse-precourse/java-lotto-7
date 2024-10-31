package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.UserLotto;

public class LottoManager {
    private final List<LottoRank> ranks = new ArrayList<>();

    public LottoManager() {
        ranks.add(new LottoRank(1, 2000000000, 6, false));
        ranks.add(new LottoRank(2, 30000000, 5, true));
        ranks.add(new LottoRank(3, 1500000, 5, false));
        ranks.add(new LottoRank(4, 50000, 4, false));
        ranks.add(new LottoRank(5, 5000, 3, false));
    }

    public List<Lotto> generateLotteries(int purchaseAmount) {
        int lottoCount = purchaseAmount / 1000;
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

    public int calculateTotalPrize(UserLotto userLotto){
        int totalPrize = 0;
        for(LottoRank rank : ranks){
            int winningCount = userLotto.getWinningCount(rank.rank());
            totalPrize += winningCount * rank.prizeAmount();
        }

        return totalPrize;
    }

    private int countMatchingNumbers(List<Integer> lotto, List<Integer> winningNumbers){
         List<Integer> tempLotto = new ArrayList<>(lotto);
         tempLotto.retainAll(winningNumbers);
         return tempLotto.size();
    }

    private boolean checkMatchingBonusNumber(List<Integer> lotto, int bonusNumber){
        return lotto.contains(bonusNumber);
    }

    private void updateWinningCount(UserLotto userLotto, int matchedNumbersCount, boolean isMatchedBonusNumber){
        for(LottoRank rank : ranks){
            if(rank.isWinning(matchedNumbersCount, isMatchedBonusNumber)){
                userLotto.updateWinningCount(rank.rank());
                break;
            }
        }
    }

    private List<Integer> generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        numbers.sort(Comparator.naturalOrder());
        return numbers;
    }

}
