package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class BonusNumberTest {
    public static WinningNumber winningNumber;

    @BeforeAll
    static void setUpBeforeClass() {
        winningNumber = new WinningNumber("1,3,5,7,9,11");
    }

    @Test
    void 보너스_번호가_당첨_번호에_중복되면_예외가_발생한다() {
        //given
        final String expectedMessage = "[ERROR] 보너스 번호는 당첨 번호에 중복되지 않는 숫자여야 합니다.";
        final LottoNumber lottoNumber = new LottoNumber(7);

        //when & then
        assertThatThrownBy(() -> new BonusNumber(lottoNumber, winningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);
    }

    @Test
    void 보너스_번호가_당첨_번호에_중복되지_않는다면_객체가_만들어진다() {
        //given
        final LottoNumber lottoNumber = new LottoNumber(45);

        //when & then
        assertDoesNotThrow(() -> new BonusNumber(lottoNumber, winningNumber));
    }
}