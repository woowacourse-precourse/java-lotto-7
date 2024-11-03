package util;

import lotto.util.Separator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SeparatorTest {
    @Test
    void parseInputToList_정상_입력_테스트() {
        String input = "1, 2, 3, 4, 5, 6";
        List<Integer> result = Separator.parseInputToList(input);

        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    void parseInputToList_공백_포함_테스트() {
        String input = " 1 , 2 , 3 , 4 , 5 , 6 ";
        List<Integer> result = Separator.parseInputToList(input);

        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    void parseInputToList_빈_문자열_테스트() {
        String input = "";
        List<Integer> result = Separator.parseInputToList(input);

        assertThat(result).isEmpty();
    }

    @Test
    void parseInputToList_잘못된_형식_테스트() {
        String input = "1, 2, three, 4";

        assertThatThrownBy(() -> Separator.parseInputToList(input))
                .isInstanceOf(NumberFormatException.class);
    }
}
