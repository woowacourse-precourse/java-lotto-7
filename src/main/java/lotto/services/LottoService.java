package lotto.services;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.model.LottoStatistics;

import java.util.ArrayList;
import java.util.List;

public class LottoService implements LottoServices {
    // 한장의 로또 객체를 생성하여 반환합니다.
    public Lotto createLotto(List<Integer> lotto) {
       return new Lotto(lotto);
    }

    public List<Lotto> createRandomLotteries(int quantity) {
        List<Lotto> RandomLotteries = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            RandomLotteries.add(new Lotto(numbers));
        }
        return RandomLotteries;
    }

    // 로또 통계 데이터 객체를 생성하여 반환합니다.
    public LottoStatistics createLottoStatistics() {
        return new LottoStatistics();
    }

    // 사용자의 로또 한장, 랜덤로또 N장, 통계데이터 객체를 전달받습니다.
    // 로또 당첨 여부를 확인하여 통계데이터를 업데이트합니다.
    public void checkLottoResults(LottoStatistics lottoStatistics, List<Lotto> randomLotteries, Lotto userLotto, int bonusNumber) {
        for (Lotto lotto : randomLotteries) {
            int matchCount = countMatchingNumbers(lotto.getNumbers(), userLotto);
            boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);

            if (matchCount == 6) {
                lottoStatistics.increment("6개 일치 (2,000,000,000원)");
            } else if (matchCount == 5 && bonusMatch) {
                lottoStatistics.increment("5개 일치, 보너스 볼 일치 (30,000,000원)");
            } else if (matchCount == 5) {
                lottoStatistics.increment("5개 일치 (1,500,000원)");
            } else if (matchCount == 4) {
                lottoStatistics.increment("4개 일치 (50,000원)");
            } else if (matchCount == 3) {
                lottoStatistics.increment("3개 일치 (5,000원)");
            }
        }
    }
    // 업데이트된 로또 당첨 통계의 수익률을 계산합니다.
    public void calculateLottoYield(LottoStatistics lottoStatistics, int amount) {
        lottoStatistics.updateLottoYield(amount);
    }


    // 사용자의 로또와 각각의 랜덤 로또 간 당첨 여부를 확인합니다.
    private int countMatchingNumbers(List<Integer> randomLotteries, Lotto userLotto) {
        int count = 0;
        for (Integer number : randomLotteries) {
            if (userLotto.getNumbers().contains(number)) {
                count++;
            }
        }
        return count;
    }

}