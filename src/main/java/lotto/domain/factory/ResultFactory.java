package lotto.domain.factory;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.Rank;
import lotto.domain.Result;

public class ResultFactory {
    public static Result generateResult(LottoMachine lottoMachine, List<Lotto> lottos) {
        Result result = new Result();
        List<Integer> winningNumbers = lottoMachine.getWinningNumbers();
        int bonusNumber = lottoMachine.getBonusNumber();

        for (Lotto lotto : lottos) {
            int matchingCount = checkMatchingNumber(winningNumbers, lotto);
            boolean matchingBonus = checkBonusNumber(bonusNumber, lotto);

            Rank rank = Rank.getRank(matchingCount, matchingBonus);
            if(rank!=null) {
                result.increaseWinningResult(rank);
            }
        }

        return result;
    }

    private static int checkMatchingNumber(List<Integer> winningNumbers, Lotto lotto) {
        int matchingCnt = 0;
        List<Integer> numbers = lotto.getNumbers();
        for (int number : numbers) {
            if (winningNumbers.contains(number)) {
                matchingCnt++;
            }
        }
        return matchingCnt;
    }

    private static boolean checkBonusNumber(int bonusNumber, Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        if (numbers.contains(bonusNumber)) {
            return true;
        }
        return false;
    }
}
