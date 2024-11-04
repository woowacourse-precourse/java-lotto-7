package lotto.view.converter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("LottoInputConverter 테스트")
public class LottoInputConverterTest {

    private LottoInputConverter lottoInputConverter;

    @BeforeEach
    void setUp() {
        lottoInputConverter = new LottoInputConverter();
    }

    @Test
    void 로또_구입금액을_입력받는다() {
        // given
        String input = "14000";

        // when
        int money = lottoInputConverter.convertMoney(input);

        // then
        assertThat(money).isEqualTo(14000);
    }

    @Test
    void 로또_번호를_문자열로_입력받아서_숫자_리스트를_만든다() {
        // given
        String input = "1,2,3,4,5,6";

        // when
        List<Integer> numbers = lottoInputConverter.convertNumbers(input);

        // then
        assertThat(numbers).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"일,이,삼,사,오,육", "1,2,3,4,5,6!"})
    void 로또_번호는_숫자만_입력_가능하다(String input) {
        // when & then
        assertThatThrownBy(() -> lottoInputConverter.convertNumbers(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호를_입력받아_숫자로_변환한다() {
        //given
        String input = "7";

        //when
        int bonusNumber = lottoInputConverter.convertBonusNumber(input);

        //then
        assertThat(bonusNumber).isEqualTo(7);
    }

    @ParameterizedTest
    @ValueSource(strings = {"일", "이", "삼", "사", "오", "육"})
    void 보너스_번호는_숫자만_입력_가능하다() {
        //when & then
        assertThatThrownBy(() -> lottoInputConverter.convertBonusNumber("일"))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
