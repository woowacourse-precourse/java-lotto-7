package lotto.winning;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import constants.ErrorMessage;
import java.util.List;
import lotto.LottoNumber;
import org.junit.jupiter.api.Test;

public class BonusNumberTest {

    private static final WinningNumbers TEST_WINNING_NUMBERS = new WinningNumbers("1,2,3,4,5,6");

    @Test
    void 보너스번호_생성() {
        BonusNumber bonusNumber = new BonusNumber("7", TEST_WINNING_NUMBERS);

        assertThat(bonusNumber).isEqualTo(new BonusNumber("7", TEST_WINNING_NUMBERS));
    }

    @Test
    void 입력된_보너스번호가_유효하지_않은_경우_예외() {
        assertThatThrownBy(() -> new BonusNumber("7,8", TEST_WINNING_NUMBERS))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ENTERED_INVALID_NUMBER);
    }

    @Test
    void 당첨번호와_중복이면_예외() {
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,45");

        assertThatThrownBy(() -> new BonusNumber("45", winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.DUPLICATE_BONUS_NUMBER);
    }

    @Test
    void 로또에_보너스번호가_포함되어있는지_확인() {
        BonusNumber bonusNumber1 = new BonusNumber("44", TEST_WINNING_NUMBERS);
        BonusNumber bonusNumber2 = new BonusNumber("45", TEST_WINNING_NUMBERS);

        List<LottoNumber> numbers = List.of(LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3),
                LottoNumber.from(4), LottoNumber.from(43), LottoNumber.from(44));

        assertThat(bonusNumber1.contains(numbers)).isTrue();
        assertThat(bonusNumber2.contains(numbers)).isFalse();
    }
}
