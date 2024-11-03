package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.WinningLotto;

import java.util.ArrayList;
import java.util.List;

public class BasicLottoService implements LottoService {

    public int getIssueCount(int cost, int lottoPrice) {
        return cost / lottoPrice;
    }

    public List<Lotto> issueLotto(int issueCount) {
        List<Lotto> issuedLotto = new ArrayList<>();
        for (int i = 0; i < issueCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            issuedLotto.add(lotto);
        }
        return issuedLotto;
    }

    public List<LottoRank> rankLotto(List<Lotto> issuedLotto, WinningLotto winningLotto) {
        List<LottoRank> lottoRanks = new ArrayList<>();
        List<Integer> winningNumbers = winningLotto.getWinningNumbers().getNumbers();
        int bonusNumber = winningLotto.getBonusNumber();
        for (Lotto lotto : issuedLotto) {
            lottoRanks.add(calculateRank(lotto, winningNumbers, bonusNumber));
        }
        return lottoRanks;
    }

    private LottoRank calculateRank(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        List<Integer> numbers = lotto.getNumbers();
        int matchCount = (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
        boolean isBonusCorrect = numbers.contains(bonusNumber);
        if (isBonusCorrect) {
            matchCount++;
        }
        return LottoRank.calculateRank(matchCount, isBonusCorrect);
    }

}
