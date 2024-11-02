package lotto.service;

import lotto.domain.bonus.BonusNumber;
import lotto.domain.lotto.Lotto;
import lotto.domain.winning.Rank;
import lotto.domain.winning.WinningContext;
import lotto.domain.winning.WinningNumbers;
import lotto.domain.winning.WinningResult;
import lotto.exception.lotto.LottoErrorMessages;
import lotto.service.lotto.LottoServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoServiceImplTest {
    private final LottoServiceImpl lottoService = new LottoServiceImpl();

    @Test
    @DisplayName("로또 구입 금액이 양수가 아닐 경우 예외가 발생한다.")
    void 로또_구입_금액이_양수가_아닐_경우_예외가_발생한다() {
        // given
        int invalidAmount = -1000;

        // when, then
        assertThatThrownBy(() -> lottoService.validateAmount(invalidAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoErrorMessages.INVALID_AMOUNT_NON_POSITIVE.getMessage());
    }

    @Test
    @DisplayName("로또 구입 금액이 1,000원 단위가 아닐 경우 예외가 발생한다.")
    void 로또_구입_금액이_1000원_단위가_아닐_경우_예외가_발생한다() {
        // given
        int invalidAmount = 800;

        // when, then
        assertThatThrownBy(() -> lottoService.validateAmount(invalidAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoErrorMessages.INVALID_AMOUNT_NOT_DIVISIBLE_BY_1000.getMessage());
    }

    @Test
    @DisplayName("로또 구입 금액이 1,000원으로 나누어 떨어지지 않는 경우 예외가 발생한다.")
    void 로또_구입_금액이_1000원으로_나누어_떨어지지_않는_경우_예외가_발생한다() {
        // given
        int invalidAmount = 2500;

        // when, then
        assertThatThrownBy(() -> lottoService.validateAmount(invalidAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoErrorMessages.INVALID_AMOUNT_NOT_DIVISIBLE_BY_1000.getMessage());
    }

    @Test
    @DisplayName("로또 구입 금액이 정상 입력된 경우 true를 반환한다.")
    void 로또_구입_금액이_정상_입력된_경우_true를_반환한다() {
        // given
        int validAmount = 3000;

        // when
        boolean result = lottoService.validateAmount(validAmount);

        // then
        assertThat(result).isTrue();
    }

//    @Test
//    @DisplayName("6개 번호가 모두 일치하면 1등이어야 한다.")
//    void 모든_번호_일치_1등() {
//        // given
//        Lotto lotto = new Lotto(List.of(8, 21, 15, 33, 40, 42));
//        WinningNumbers winningNumbers = new WinningNumbers("8,21,15,33,40,42");
//        BonusNumber bonusNumber = new BonusNumber("7", winningNumbers.getNumbers());
//        WinningContext context = new WinningContext(winningNumbers, bonusNumber);
//
//        // when
//        WinningResult result = lottoService.checkResult(lotto, context);
//
//        // then
//        assertThat(result.getRankCount(Rank.FIRST)).isEqualTo(1);
//    }
//
//    @Test
//    @DisplayName("5개 번호와 보너스 번호가 일치하면 2등이어야 한다.")
//    void 다섯_번호_보너스_일치_2등() {
//        // given
//        Lotto lotto = new Lotto(List.of(8, 21, 15, 33, 40, 7));
//        WinningNumbers winningNumbers = new WinningNumbers("8,21,15,33,40,42");
//        BonusNumber bonusNumber = new BonusNumber("7", winningNumbers.getNumbers());
//        WinningContext context = new WinningContext(winningNumbers, bonusNumber);
//
//        // when
//        WinningResult result = lottoService.checkResult(lotto, context);
//
//        // then
//        assertThat(result.getRankCount(Rank.SECOND)).isEqualTo(1);
//    }
//
//    @Test
//    @DisplayName("5개 번호만 일치하면 3등이어야 한다.")
//    void 다섯_번호_일치_3등() {
//        // given
//        Lotto lotto = new Lotto(List.of(8, 21, 15, 33, 40, 43));
//        WinningNumbers winningNumbers = new WinningNumbers("8,21,15,33,40,42");
//        BonusNumber bonusNumber = new BonusNumber("7", winningNumbers.getNumbers());
//        WinningContext context = new WinningContext(winningNumbers, bonusNumber);
//
//        // when
//        WinningResult result = lottoService.checkResult(lotto, context);
//
//        // then
//        assertThat(result.getRankCount(Rank.THIRD)).isEqualTo(1);
//    }
//
//    @Test
//    @DisplayName("4개 번호가 일치하면 4등이어야 한다.")
//    void 네_번호_일치_4등() {
//        // given
//        Lotto lotto = new Lotto(List.of(8, 21, 15, 33, 44, 45));
//        WinningNumbers winningNumbers = new WinningNumbers("8,21,15,33,40,42");
//        BonusNumber bonusNumber = new BonusNumber("7", winningNumbers.getNumbers());
//        WinningContext context = new WinningContext(winningNumbers, bonusNumber);
//
//        // when
//        WinningResult result = lottoService.checkResult(lotto, context);
//
//        // then
//        assertThat(result.getRankCount(Rank.FOURTH)).isEqualTo(1);
//    }
//
//    @Test
//    @DisplayName("3개 번호가 일치하면 5등이어야 한다.")
//    void 세_번호_일치_5등() {
//        // given
//        Lotto lotto = new Lotto(List.of(8, 21, 15, 34, 44, 45));
//        WinningNumbers winningNumbers = new WinningNumbers("8,21,15,33,40,42");
//        BonusNumber bonusNumber = new BonusNumber("7", winningNumbers.getNumbers());
//        WinningContext context = new WinningContext(winningNumbers, bonusNumber);
//
//        // when
//        WinningResult result = lottoService.checkResult(lotto, context);
//
//        // then
//        assertThat(result.getRankCount(Rank.FIFTH)).isEqualTo(1);
//    }
//
//    @Test
//    @DisplayName("2개 이하의 번호가 일치하면 당첨되지 않는다.")
//    void 두_번호_이하_일치_꽝() {
//        // given
//        Lotto lotto = new Lotto(List.of(8, 21, 16, 34, 44, 45));
//        WinningNumbers winningNumbers = new WinningNumbers("8,21,15,33,40,42");
//        BonusNumber bonusNumber = new BonusNumber("7", winningNumbers.getNumbers());
//        WinningContext context = new WinningContext(winningNumbers, bonusNumber);
//
//        // when
//        WinningResult result = lottoService.checkResult(lotto, context);
//
//        // then
//        assertThat(result.getRankCount(Rank.NO_WIN)).isEqualTo(1);
//    }
}