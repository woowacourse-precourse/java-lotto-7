package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

public class LottoValidatorTest {
    @Test
    void validateInputTest_빈_문자열_예외_테스트() {
        assertThatThrownBy(() -> LottoValidator.validateInput(""))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 입력이 잘못되었습니다.");
    }

    @Test
    void validateLottoSizeTest_로또_길이_초과_예외_테스트() {
        assertThatThrownBy(() -> LottoValidator.validateLottoSize(List.of(1, 2, 3, 4, 5, 6, 7)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    @Test
    void validateNumberTest_숫자가_아닌_문자열_예외_테스트() {
        assertThatThrownBy(() -> LottoValidator.validateNumber("a"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 숫자만 입력해야 합니다.");
    }

    @Test
    void validateLottoNumbersTest_로또_번호_범위_예외_테스트() {
        assertThatThrownBy(() -> LottoValidator.validateLottoNumbers(List.of(0, 1, 2, 3, 4, 5)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 로또 번호가 1~45 사이의 숫자여야 합니다.");
    }

    @Test
    void validateLottoNumbersTest_로또_번호_중복_예외_테스트() {
        assertThatThrownBy(() -> LottoValidator.validateLottoNumbers(List.of(1, 2, 3, 4, 5, 5)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 로또 번호는 중복될 수 없습니다.");
    }

    @Test
    void validateBonusNumberTest_보너스_번호_중복_예외_테스트() {
        assertThatThrownBy(() -> LottoValidator.validateBonusNumber(1, List.of(1, 2, 3, 4, 5, 6)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }
}
