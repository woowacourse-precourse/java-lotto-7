package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.common.exception.InvalidLottoNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

    @DisplayName("로또 번호를 성공적으로 생성하는 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 10, 30, 35, 45})
    void LottoNumberGenerationTest(int lottoNumber) {
        assertThat(new LottoNumber(lottoNumber).getLottoNumber()).isEqualTo(lottoNumber);
    }

    @DisplayName("잘못된 로또 번호 생성 시 예외를 발생하는 테스트")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46, 50, 100, 1000, 20000, Integer.MAX_VALUE})
    void InvalidLottoNumberRangeExceptionTest(int lottoNumber){
        assertThatThrownBy(() -> new LottoNumber(lottoNumber))
                .isInstanceOf(InvalidLottoNumberException.class);
    }
}
