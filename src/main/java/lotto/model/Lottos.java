package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.constant.WinningType;

public class Lottos {

    private final List<Lotto> lottos;

    private Lottos(final List<List<Integer>> lottoContents) {
        List<Lotto> lottos = new ArrayList<>();
        for (List<Integer> content : lottoContents) {
            lottos.add(Lotto.createLotto(content));
        }
        this.lottos = lottos;
    }

    public static Lottos create(final List<List<Integer>> lottoContents) {
        return new Lottos(lottoContents);
    }

    public static Lottos createAuto(final long lottoCount) {
        List<List<Integer>> lottoContents = new ArrayList<>();
        for (long l = 1; l <= lottoCount; l++) {
            final List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(
                    Lotto.MINIMUM_THRESHOLD, Lotto.MAXIMUM_THRESHOLD, Lotto.SIZE);
            lottoContents.add(randomNumbers);
        }
        return new Lottos(lottoContents);
    }

    public LottoResult check(final WinningNumbers winningNumbers, final BonusNumber bonusNumber) {
        LottoResult result = LottoResult.create();
        for (Lotto lotto : lottos) {
            final CorrectCount correctCount = winningNumbers.check(lotto.getNumbers());
            if (correctCount.getCount() == WinningType.BONUS.getCorrectCount()) {
                checkWithBonusNumber(bonusNumber, lotto, correctCount);
            }
            result.update(correctCount);
        }
        return result;
    }

    private void checkWithBonusNumber(final BonusNumber bonusNumber, final Lotto lotto,
                                      final CorrectCount correctCount) {
        bonusNumber.check(lotto.getNumbers(), correctCount);
    }

    public List<List<Integer>> getPurchasedLottos() {
        return lottos.stream()
                .map(Lotto::getNumbers)
                .collect(Collectors.toList());
    }
}
