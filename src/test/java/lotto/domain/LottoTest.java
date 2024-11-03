package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {

    @Test
    @DisplayName("유효한 로또일 경우 성공 검증")
    void 유효한_로또_성공() {
        //given
        List<Integer> validNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        //when
        Lotto validLotto = new Lotto(validNumbers);

        //then
        assertThat(validLotto.getNumbers()).isEqualTo(validNumbers);
    }

    @Test
    @DisplayName("로또 번호가 6개가 아닐 경우 예외 검증")
    void 로또_번호_길이_예외_검증() {
        //given
        List<Integer> invalidLengthNumbers = Arrays.asList(1, 2, 3, 4, 5);

        //when
        try {
            Lotto invalidLengthLotto = new Lotto(invalidLengthNumbers);
        } catch (LottoException e) {
            assertThat("[ERROR] 당첨 번호는 6자리 입력하셔야 합니다.").isEqualTo(e.getMessage());
        }

        //then
        assertThatThrownBy(() -> new Lotto(invalidLengthNumbers))
                .isInstanceOf(LottoException.class)
                .hasMessage(ErrorMessage.WINNING_LOTTO_IS_NOT_SIX_LENGTH.getErrorMessage());
    }

    @Test
    @DisplayName("로또 번호 중에 범위가 벗어나는 경우 예외 검증")
    void 로또_번호_범위_예외_검증() {
        //given
        List<Integer> invalidRangeNumbers = Arrays.asList(1, 2, 3, 4, 5, 46);

        //when
        try {
            Lotto invalidRangeLotto = new Lotto(invalidRangeNumbers);
        } catch (LottoException e) {
            assertThat("[ERROR] 당첨 번호는 1~45 사이의 수를 입력하셔야 합니다.").isEqualTo(e.getMessage());
        }

        //then
        assertThatThrownBy(() -> new Lotto(invalidRangeNumbers))
                .isInstanceOf(LottoException.class)
                .hasMessage(ErrorMessage.WINNING_LOTTO_RANGE_ERROR.getErrorMessage());
    }

    @Test
    @DisplayName("로또 번호 중에 중복된 숫자가 있을 경우 예외 검증")
    void 로또_번호_중복_예외_검증() {
        //given
        List<Integer> invalidDuplicateNumbers = Arrays.asList(1, 1, 2, 3, 4, 5);

        //when
        try {
            Lotto invalidDuplicateLotto = new Lotto(invalidDuplicateNumbers);
        } catch (LottoException e) {
            assertThat("[ERROR] 당첨 번호는 중복된 수 없이 입력하셔야 합니다.").isEqualTo(e.getMessage());
        }

        //then
        assertThatThrownBy(() -> new Lotto(invalidDuplicateNumbers))
                .isInstanceOf(LottoException.class)
                .hasMessage(ErrorMessage.WINNING_LOTTO_DUPLICATE_ERROR.getErrorMessage());
    }

}
