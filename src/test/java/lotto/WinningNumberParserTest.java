package lotto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

public class WinningNumberParserTest {
    @Test
    public void 쉼표를_구분자로_하여_문자열을_분리한다() {
        String input = "1,4,8,5,44,43";
        List<Integer> expected = List.of(1, 4, 8, 5, 44, 43);
        List<Integer> actual = WinningNumberParser.parse(input);
        assertEquals(expected, actual);
    }

    @Test
    public void 숫자가_아닌_값을_입력하면_예외가_발생한다() {
        String input = "1,4,8,a,.,43";
        assertThatThrownBy(() -> WinningNumberParser.parse(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 공백이_포함되면_예외가_발생한다() {
        String input = "1,4,8, 9, 10,43";
        assertThatThrownBy(() -> WinningNumberParser.parse(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 쉼표가_연속으로_입력될_경우_예외가_발생한다() {
        String input = "1,4,8,9,,43";
        assertThatThrownBy(() -> WinningNumberParser.parse(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 문자열_맨_앞에_쉼표가_있을_경우_예외가_발생한다() {
        String input = ",1,4,8,9,10,44";
        assertThatThrownBy(() -> WinningNumberParser.parse(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
