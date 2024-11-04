package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.enums.Constants;
import lotto.enums.Rank;

public class LottoService {

    static final String DELIMITER = ",";

    public List<Integer> getLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(Constants.LOTTO_LOWER_BOUND.getValue(),
                Constants.LOTTO_UPPER_BOUND.getValue(),
                Constants.LOTTO_NUMBER_SIZE.getValue());
    }

    public List<Integer> getWinningNumbers(String inputWinningNumbers) {
        return Arrays.stream(inputWinningNumbers.split(DELIMITER)).map(Integer::parseInt).toList();
    }

    public List<Integer> calculateLottoResult(List<Lotto> lottos, List<Integer> winningNumbers, int bounsNumber) {
        int[] lottoResult = new int[6];
        for (Lotto lotto : lottos) {
            int rank = lotto.calculateRank(winningNumbers, bounsNumber);
            lottoResult[rank]++;
        }
        return Arrays.stream(lottoResult).boxed().toList();
    }

    public double calculateRate(int money, List<Integer> lottoResults) {
        double totalSum = 0;
        for (Rank rank : Rank.values()) {
            int prize = rank.getPrize();
            int count = lottoResults.get(rank.getRank());
            totalSum += prize * count;
        }
        double rate = (totalSum / money) * 100d;
        return Math.round(rate * 100d) / 100d;
    }
}
