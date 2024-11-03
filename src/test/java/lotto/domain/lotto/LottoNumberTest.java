package lotto.domain.lotto;

import static lotto.exception.message.WinningNumberExceptionMessage.BONUS_NUMBER_OUT_OF_RANGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.winning.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -1, 46})
    @DisplayName("로또 번호가 유효 범위(1-45)를 벗어나면 예외가 발생한다")
    void givenOutOfRangeLottoNumber_whenCreate_thenThrowsException(int bonusNumber) {
        // given

        // when & then
        assertThatThrownBy(() -> LottoNumber.from(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이미 생성된 로또 번호를 재사용한다.")
    void givenLottoNumber_whenCreateLottoNumber_thenSame() {
        // given
        LottoNumber lottoNumber = LottoNumber.from(1);

        // when & then
        assertThat(LottoNumber.from(1)).isSameAs(lottoNumber);
    }

    @Test
    @DisplayName("같은 숫자로 로또 번호를 생성할 시 동등하다.")
    void givenLottoNumber_whenCreateLottoNumber_thenEqual() {
        // given
        LottoNumber lottoNumber1 = LottoNumber.from(1);

        // when
        LottoNumber lottoNumber2 = LottoNumber.from(1);

        // when & then
        assertThat(lottoNumber2.equals(lottoNumber1)).isTrue();
    }

}
