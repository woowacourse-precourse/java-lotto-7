package lotto.input;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ParserTest {

    @Test
    void toInt_문자열을_정수로_변환() {
        int result = Parser.toInt("123");
        assertThat(result).isEqualTo(123);
    }

    @Test
    void toInt_문자열이_숫자가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> Parser.toInt("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void toInts_문자열_배열을_정수_리스트로_변환() {
        String[] inputs = {"1", "2", "3", "4"};
        List<Integer> result = Parser.toInts(inputs);
        assertThat(result).containsExactly(1, 2, 3, 4);
    }

    @Test
    void toInts_잘못된_문자열이_포함된_경우_예외가_발생한다() {
        String[] inputs = {"1", "two", "3"};
        assertThatThrownBy(() -> Parser.toInts(inputs))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
