package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.exception.DuplicationNumberException;
import lotto.exception.InvalidDelimiterException;
import lotto.exception.InvalidNumberRangeException;
import lotto.exception.InvalidNumberSizeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(InvalidNumberSizeException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(DuplicationNumberException.class);
    }

    @Test
    @DisplayName("로또 번호가 범위를 벗어나면 예외가 발생한다.")
    void 로또_번호가_범위를_벗어나면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(InvalidNumberRangeException.class);
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(InvalidNumberRangeException.class);
    }

    @Test
    @DisplayName("입력 문자열의 마지막에 쉼표가 있을 경우 구분자 예외가 발생한다.")
    void 입력_문자열_마지막에_구분자가_있으면_예외가_발생한다() {
        String inputLastIndexDelimiter = "1,2,3,4,5,6,";
        assertThatThrownBy(() -> {
            User user = new User();
            user.lastIndexValidation(inputLastIndexDelimiter);
        }).isInstanceOf(InvalidDelimiterException.class);
    }

}
