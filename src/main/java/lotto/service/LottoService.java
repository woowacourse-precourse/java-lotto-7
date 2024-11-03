package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;

public class LottoService {
    private final static Integer ZERO_NUMBER = 0;
    private final static Integer LOTTO_NUMBER_SIZE = 6;
    private final static Integer LOTTO_RANGE_START = 1;
    private final static Integer LOTTO_RANGE_END = 45;

    private List<Integer> winningNumbers;
    private Integer bonusNumber;

    private List<Lotto> publishedLottos = new ArrayList<>();


    public List<Integer> publishLotto(){
        Lotto newLotto = new Lotto(Randoms.pickUniqueNumbersInRange(LOTTO_RANGE_START, LOTTO_RANGE_END, LOTTO_NUMBER_SIZE));
        publishedLottos.add(newLotto);

        return newLotto.getSortedNumbers();
    }

    public void setNumbers(List<Integer> winningNumbers, Integer bonusNumber){
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<LottoResult> calcLottoResults(){
        List<LottoResult> results = new ArrayList<>();

        for(Lotto lotto : publishedLottos) {
            Integer matchCount = checkLottoMatched(lotto);
            boolean isBonusMatch = checkLottoMatchedBonus(lotto);

            results.add(LottoResult.of(matchCount, isBonusMatch));
        }

        return results;
    }

    public Integer getSumLottoProfits(List<LottoResult> results) {
        return results.stream()
                .filter(lottoResult -> lottoResult.getMatchCount() > ZERO_NUMBER)
                .mapToInt(LottoResult::getPrice)
                .sum();
    }

    private Integer checkLottoMatched(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getSortedNumbers();

        return Math.toIntExact(
                lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count());
    }

    private boolean checkLottoMatchedBonus(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getSortedNumbers();

        return lottoNumbers.contains(bonusNumber);
    }

}
