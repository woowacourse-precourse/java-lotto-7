package lotto.model;

import static java.util.stream.Collectors.toMap;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Statistics {
    private final List<Integer> winningNumbers;
    private final Integer bonusNumber;

    public Statistics(List<Integer> winningNumbers, Integer bonusNumber) {
        validate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private static void validate(List<Integer> winningNumbers, Integer bonusNumber) {
        if (winningNumbers.contains(bonusNumber)){
            throw new IllegalArgumentException("당첨 번호와 보너스 번호는 겹치면 안 됩니다.");
        }
    }

    public Map<LottoResult, Integer> getResult(List<Lotto> issuedLottos) {
        Map<LottoResult, Integer> lottoResults = initiateLottoResults();
        for (Lotto lotto : issuedLottos) {
            List<Integer> lottoNumbers = lotto.getLottoNumbers();
            List<Integer> numbersOverlapped = findNumberOverlapped(lottoNumbers);

            boolean hasBonus = lottoNumbers.contains(bonusNumber);
            LottoResult lottoResult = lotto.getResult(numbersOverlapped.size(), hasBonus);

            lottoResults.put(lottoResult, lottoResults.get(lottoResult) + 1);
        }
        return lottoResults;
    }

    private List<Integer> findNumberOverlapped(List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                .filter(lottoNumber -> winningNumbers.stream().anyMatch(Predicate.isEqual(lottoNumber)))
                .toList();
    }

    private Map<LottoResult, Integer> initiateLottoResults() {
        return Stream.of(new Object[][]{
                {LottoResult.FIRST, 0},
                {LottoResult.SECOND, 0},
                {LottoResult.THIRD, 0},
                {LottoResult.FOURTH, 0},
                {LottoResult.FIFTH, 0},
                {LottoResult.NONE, 0}
        }).collect(toMap(data -> (LottoResult) data[0], data -> (Integer) data[1]));
    }
}
