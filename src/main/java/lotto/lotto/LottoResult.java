package lotto.lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.lotto.object.MyLotto;
import lotto.lotto.object.WinningLotto;

public class LottoResult {
    private final WinningLotto winningLotto;

    public LottoResult(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    /**
     * 당첨 번호와 일치하는 번호의 개수를 반환한다.
     */
    public int matchingNumberCount(MyLotto myLotto) {
        List<Integer> lottoNumbers = myLotto.getNumbers();
        List<Integer> winningLottoNumbers = winningLotto.getNumbers();
        return (int) lottoNumbers.stream()
                .filter(winningLottoNumbers::contains).count();
    }

    /**
     * 로또 번호 일치 개수에 따라 순위를 반환한다.
     */
    public int assignRank(MyLotto myLotto) {
        int bonusNumber = winningLotto.getBonusNumber();
        int matchingCount = matchingNumberCount(myLotto);

        if (matchingCount == 3) {
            return 5;
        } else if (matchingCount == 4) {
            return 4;
        } else if (matchingCount == 5) {
            if (myLotto.getNumbers().contains(bonusNumber)) {
                return 2;
            }
            return 3;
        } else if (matchingCount == 6) {
            return 1;
        }
        return 0;
    }

    /**
     * 당첨 통계를 출력하기 위한 Map을 생성한다.
     */
    public Map<Integer, Integer> winnerLottoCount(List<MyLotto> myLottos) {
        Map<Integer, Integer> result = new HashMap<>();
        result.put(1, 0);
        result.put(2, 0);
        result.put(3, 0);
        result.put(4, 0);
        result.put(5, 0);

        for (MyLotto lotto : myLottos) {
            if (lotto.getRank() > 0) {
                result.put(lotto.getRank(), result.get(lotto.getRank()) + 1);
            }
        }
        return result;
    }

    public double getReturnRate(long money, List<MyLotto> myLottos) {
        long profit = 0;
        for (MyLotto lotto : myLottos) {
            if (lotto.getRank() == 1) {
                profit += 2000000000;
            } else if (lotto.getRank() == 2) {
                profit += 30000000;
            } else if (lotto.getRank() == 3) {
                profit += 1500000;
            } else if (lotto.getRank() == 4) {
                profit += 50000;
            } else if (lotto.getRank() == 5) {
                profit += 5000;
            }
        }
        return (double) profit / money;
    }
}
