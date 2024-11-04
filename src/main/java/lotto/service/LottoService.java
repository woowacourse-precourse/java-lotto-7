package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.model.Statistics;
import lotto.model.WinningLotto;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final int LOTTO_NUMBERS_COUNT = 6;

    public List<Lotto> generateLottos(int numberOfTickets) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < numberOfTickets; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX,
                LOTTO_NUMBERS_COUNT);
            numbers = new ArrayList<>(numbers);
            numbers.sort(Integer::compareTo); // 오름차순 정렬
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        return lottos;
    }

    public Statistics calculateStatistics(List<Lotto> purchasedLottos, WinningLotto winningLotto) {
        int matchCount;
        boolean bonusMatch;
        Statistics statistics = new Statistics();

        for (Lotto lotto : purchasedLottos) {
            matchCount = lotto.getMatchCount(winningLotto.getWinningNumbers());
            bonusMatch = lotto.getNumbers().contains(winningLotto.getBonusNumber());
            statistics.addResult(matchCount, bonusMatch);
        }
        return statistics;
    }
}
