package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import lotto.exception.ErrorMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    private Lotto winningNumbers;
    private BonusNumber bonusNumber;

    @BeforeEach
    void setUp() {
        winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    void 정상_생성_테스트() {
        bonusNumber = new BonusNumber(7);
        assertDoesNotThrow(() -> new WinningLotto(winningNumbers, bonusNumber));
    }

    @Test
    void 당첨_번호와_보너스_번호_중복_테스트() {
        bonusNumber = new BonusNumber(6);

        assertThatThrownBy(() -> new WinningLotto(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.BONUS_NUMBER_NOT_DUPLICATED_WITH_LOTTO_NUMBER.getMessage());
    }
}