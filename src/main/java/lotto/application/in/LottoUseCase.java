package lotto.application.in;

import lotto.domain.BonusNumber;
import lotto.domain.LottoRound;
import lotto.domain.LottoRoundResult;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumber;

/**
 * 로또 유즈케이스를 정의한 인터페이스.
 */
public interface LottoUseCase {

    /**
     * 구입 금액만큼 로또를 구매합니다.
     *
     * @param purchaseAmount 구입 가격
     * @return 구입한 회차의 로또 정보
     */
    LottoRound buyLotto(PurchaseAmount purchaseAmount);

    /**
     * 로또의 당첨 등수를 확인합니다.
     *
     * @param lottoRound    로또 회차 정보
     * @param winningNumber 회차의 당첨 번호
     * @param bonusNumber   회차의 보너스 번호
     * @return 회차의 결과 정보
     */
    LottoRoundResult checkResult(LottoRound lottoRound, WinningNumber winningNumber, BonusNumber bonusNumber);
}
