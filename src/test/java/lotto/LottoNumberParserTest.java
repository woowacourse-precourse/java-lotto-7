package lotto;

import lotto.model.LottoNumberParser;
import lotto.util.model.Parser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberParserTest {

    @DisplayName("로또 번호 입력에 문자가 삽입될 경우 예외가 발생한다.")
    @Test
    void 로또_번호_입력에_문자가_삽입될_경우_예외가_발생한다() {
        assertThatThrownBy(() -> Parser.select(LottoNumberParser.class).parse("1,2,3,4,5,r"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 입력이 Integer Maximum Number를 초과할 경우 예외가 발생한다.")
    @Test
    void 로또_번호_입력이_Integer_Maximum_Number를_초과할_경우_예외가_발생한다() {
        assertThatThrownBy(() -> Parser.select(LottoNumberParser.class).parse("1,2,"+Integer.MAX_VALUE+"1,4,5,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
