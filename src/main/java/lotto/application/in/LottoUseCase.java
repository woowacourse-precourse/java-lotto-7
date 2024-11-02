package lotto.application.in;

import lotto.config.validation.annotation.NotNull;
import lotto.config.validation.annotation.Valid;
import lotto.domain.input.BonusNumber;
import lotto.domain.input.PurchaseAmount;
import lotto.domain.input.WinningNumber;
import lotto.domain.round.LottoRound;
import lotto.domain.round.LottoRoundResult;

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
    LottoRound buyLotto(@Valid @NotNull PurchaseAmount purchaseAmount);

    /**
     * 로또의 당첨 등수를 확인합니다.
     *
     * @param lottoRound    로또 회차 정보
     * @param winningNumber 회차의 당첨 번호
     * @param bonusNumber   회차의 보너스 번호
     * @return 회차의 결과 정보
     */
    LottoRoundResult checkResult(
            @Valid @NotNull LottoRound lottoRound,
            @Valid @NotNull WinningNumber winningNumber,
            @Valid @NotNull BonusNumber bonusNumber);
}
