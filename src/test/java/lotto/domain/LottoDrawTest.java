package lotto.domain;

import lotto.exception.LottoException;
import lotto.exception.message.LottoExceptionMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoDrawTest {

    @Test
    @DisplayName("당첨 번호와 보너스 번호가 정상일 때 LottoDraw를 생성한다.")
    void createLottoDrawWithValidLottoAndBonus() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        LottoDraw lottoDraw = LottoDraw.of(winningLotto, bonusNumber);

        Assertions.assertEquals(winningLotto, lottoDraw.getWinningLotto());
        Assertions.assertEquals(bonusNumber, lottoDraw.getBonusNumber());
    }

    @Test
    @DisplayName("보너스 번호가 1보다 작거나 45보다 크면 예외를 발생한다.")
    void throwExceptionWhenBonusNumberOutOfRange() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        int invalidBonusNumberLow = 0;
        int invalidBonusNumberHigh = 46;

        LottoException lowException = Assertions.assertThrows(LottoException.class, () ->
                LottoDraw.of(winningLotto, invalidBonusNumberLow)
        );
        LottoException highException = Assertions.assertThrows(LottoException.class, () ->
                LottoDraw.of(winningLotto, invalidBonusNumberHigh)
        );

        Assertions.assertTrue(
                lowException.getMessage().contains(LottoExceptionMessage.INVALID_LOTTO_NUMBER.getMessage())
        );
        Assertions.assertTrue(
                highException.getMessage().contains(LottoExceptionMessage.INVALID_LOTTO_NUMBER.getMessage())
        );
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호에 포함되면 예외를 발생한다.")
    void throwExceptionWhenBonusNumberIsInWinningLotto() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int invalidBonusNumber = 6;

        LottoException exception = Assertions.assertThrows(LottoException.class, () ->
                LottoDraw.of(winningLotto, invalidBonusNumber)
        );

        Assertions.assertTrue(
                exception.getMessage().contains(LottoExceptionMessage.DUPLICATE_BONUS_NUMBER.getMessage())
        );
    }

}
