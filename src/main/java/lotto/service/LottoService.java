package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.LottoRank;
import lotto.WinningLotto;

import java.util.*;

public class LottoService {
    public List<Lotto> createLotto(int purchaseCount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < purchaseCount; i++) {
            List<Integer> numbers = createLottoNumber();
            numbers = sortLottoNumber(numbers);

            Lotto newLotto = new Lotto(numbers);
            lottos.add(newLotto);
        }

        return lottos;
    }

    public List<Integer> createLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public List<Integer> sortLottoNumber(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers;
    }

    public Map<Lotto, LottoRank> checkWinning(List<Lotto> lottos, WinningLotto winningLotto) {
        Map<Lotto, LottoRank> lottoRanks = new HashMap<>();

        for (Lotto lotto : lottos) {
            LottoRank lottoRank = determineRank(lotto, winningLotto);

            if (lottoRank == null) {
                continue;
            }
            lottoRanks.put(lotto, lottoRank);
        }

        return lottoRanks;
    }

    public LottoRank determineRank(Lotto lotto, WinningLotto winningLotto) {
        int matchCount = countMatches(lotto, winningLotto);

        if (matchCount == 6)
            return LottoRank.FIRST;
        if (matchCount == 5 && hasBonus(lotto, winningLotto))
            return LottoRank.SECOND;
        if (matchCount == 5)
            return LottoRank.THIRD;
        if (matchCount == 4)
            return LottoRank.FOURTH;
        if (matchCount == 3)
            return LottoRank.FIFTH;
        return null;
    }

    public int countMatches(Lotto lotto, WinningLotto winningLotto) {
        List<Integer> numbers = lotto.getNumbers();
        List<Integer> winningNumbers = winningLotto.getNumbers();

        int matchCount = 0;

        for (int number : numbers) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }

        return matchCount;
    }

    public boolean hasBonus(Lotto lotto, WinningLotto winningLotto) {
        int bonusNumber = winningLotto.getBonusNumber();
        List<Integer> numbers = lotto.getNumbers();

        return numbers.contains(bonusNumber);
    }

    public Map<LottoRank, Integer> countWinningRank(Map<Lotto, LottoRank> rankForEach) {
        Map<LottoRank, Integer> winningCount = new EnumMap<>(LottoRank.class);

        if (rankForEach == null) {
            throw new IllegalArgumentException("당첨 정보가 없습니다");
        }

        winningCount = initWinningCount(winningCount);

        for (LottoRank rank : rankForEach.values()) {
            winningCount.put(rank, winningCount.get(rank) + 1);
        }

        return winningCount;
    }

    public Map<LottoRank, Integer> initWinningCount(Map<LottoRank, Integer> input) {
        for (LottoRank rank : LottoRank.values()) {
            input.put(rank, 0);
        }

        return input;
    }
}
