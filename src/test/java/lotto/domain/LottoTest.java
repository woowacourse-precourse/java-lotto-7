package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.exception.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    @DisplayName("당첨 번호 - 공백")
    void blankWinningNumber() {
        assertThatThrownBy(() -> Lotto.of(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.BLANK_WINNING_NUMBER.getMessage());
    }

    @Test
    @DisplayName("당첨 번호 - 숫자가 아닌 문자 포함")
    void notNumericLottoNumber() {
        assertThatThrownBy(() -> Lotto.of("1,2,a,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_NUMERIC_LOTTO_NUMBER.getMessage());
    }

    @Test
    @DisplayName("당첨 번호 - 너무 큰 숫자가 포함")
    void tooBigLottoNumber() {
        assertThatThrownBy(() -> Lotto.of("1,2,3,1000000000000,4,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.TOO_BIG_LOTTO_NUMBER.getMessage());
    }

    @Test
    @DisplayName("로또 번호 - 6개가 아닌 경우")
    void outRangeLottoNumbers() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_LOTTO_NUMBER_COUNT_SIX.getMessage());
    }

    @Test
    @DisplayName("로또 번호 - 1에서 45사이의 숫자가 아닌 경우")
    void outRangeLottoNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 50, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.OUT_RANGE_LOTTO_NUMBER.getMessage());
    }

    @Test
    @DisplayName("로또 번호 - 중복된 숫자가 존재하는 경우")
    void duplicateLottoNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.DUPLICATED_LOTTO_NUMBER.getMessage());
    }

    @Test
    @DisplayName("로또 번호 - 성공 테스트")
    void validLottoNumber() {
        //given
        String input = "1, 2, 3, 4, 5, 6";

        //when
        Lotto lotto = Lotto.of(input);

        //then
        assertThat(lotto.getNumbers()).hasSize(6);
    }
}
