package lotto;

import lotto.model.Lotto;
import lotto.view.InputParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputParserTest {
    @Test
    @DisplayName("문자열 로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    void 문자열_로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> InputParser.validateLength("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("문자열 번호가 숫자가 아니면 예외가 발생한다.")
    void 문자열_번호가_숫자가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> InputParser.parseNumber("q"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
