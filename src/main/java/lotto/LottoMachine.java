package lotto;

import java.util.List;

/**
 * 로또 진행에 필요한 기능들을 수행한다.
 * - 로또를 n개 생성한다.
 * - 로또를 n개 생성하기 위한 랜덤 넘버들을 가져온다.
 * - 로또 결과를 생성한다.
 */
public class LottoMachine {
    List<Lotto> lottos;

    public void generateLottos(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(LottoNumberGenerator.getNumbers()));
        }
    }

    public LottoResult generateResult (List<Integer> winningNumbers, Integer bonusNumber) {
        LottoResult result = new LottoResult();
        for (Lotto lotto : lottos) {
            int matchCount = lotto.countMatchNumber(winningNumbers);
            result.addMatchCount(matchCount, lotto.hasBonus(bonusNumber));
        }
        return result;
    }
}
