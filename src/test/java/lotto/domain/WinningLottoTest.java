package lotto.domain;

import static lotto.exception.ExceptionMessage.DUPLICATE_WITH_WINNING_NUMBER;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.*;

public class WinningLottoTest {

    @DisplayName("로또 번호와 보너스 번호가 중복되는 경우 - IllegalArgumentException 반환")
    @Test
    void testDuplicate(){
        // given
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        int bonusNumber = 5;

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() ->  new WinningLotto(lotto, bonusNumber))
                .withMessage(DUPLICATE_WITH_WINNING_NUMBER.getMessage());
    }

    @DisplayName("성공적으로 생성되는 경우 - ")
    @Test
    void testValid(){
        // given
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        int bonusNumber = 7;

        // when
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);

        // then
        assertEquals(lotto, winningLotto.getLotto());
        assertEquals(bonusNumber, winningLotto.getBonusNumber());
    }
}
