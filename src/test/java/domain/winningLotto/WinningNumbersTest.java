package domain.winningLotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import constants.ErrorMessage;
import domain.lotto.LottoNumber;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class WinningNumbersTest {

    @Test
    void 당첨번호_생성() {
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");
        
        assertThat(winningNumbers).isEqualTo(new WinningNumbers("1,2,3,4,5,6"));
    }

    @Test
    void 입력된_당첨_번호가_6개가_아닌_경우_예외() {
        assertThatThrownBy(() -> new WinningNumbers("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_MATCH_LOTTO_SIZE);
    }

    @Test
    void 입력된_당첨_번호에_숫자가_중복된_경우_예외() {
        assertThatThrownBy(() -> new WinningNumbers("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.EXISTS_DUPLICATE_NUMBER);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a,b,3,4,5,6", "1:2:3:4:5:6"})
    void 입력된_당첨_번호가_유효하지_않은_경우_예외(String input) {
        assertThatThrownBy(() -> new WinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ENTERED_INVALID_NUMBER);
    }

    @Test
    void 보너스번호가_당첨번호와_중복되면_예외() {
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,45");

        assertThatThrownBy(() -> new BonusNumber("45", winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.DUPLICATE_BONUS_NUMBER);
    }

    @Test
    void 로또와_당첨번호를_비교하여_매칭_개수_구하기() {
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");
        List<LottoNumber> numbers = List.of(LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3),
                LottoNumber.from(4), LottoNumber.from(44), LottoNumber.from(45));

        assertThat(winningNumbers.countNumbers(numbers)).isEqualTo(4);
    }
}
