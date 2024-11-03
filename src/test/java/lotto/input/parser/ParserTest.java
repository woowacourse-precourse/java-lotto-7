package lotto.input.parser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ParserTest {
    private Parser parser = new Parser();


    @Test
    void 금액_입력에_숫자가_아닌_값이_오면_예외가_발생한다() {
        String input = "notNumber";
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> parser.parseInt(input));
    }

    @Test
    void 금액_입력이_가능한_범위를_초과하면_예외가_발생한다() {
        String input = String.valueOf((long) Integer.MAX_VALUE + 1);
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> parser.parseInt(input));
    }

    @Test
    void 정상적인_숫자_문자열은_숫자를_변환한다() {
        String input = "1000";
        int expected = 1000;
        Assertions.assertEquals(expected, parser.parseInt(input));
    }

    @Test
    void 정상적인_콤마로_이어진_숫자_문자열은_숫자_리스트를_변환한다() {
        String input = "1000,2000,2000,5000";
        List<Integer> expected = List.of(1000,2000,2000,5000);

        Assertions.assertEquals(expected, parser.parseIntList(input));
    }

    @Test
    void 빈_입력이_들어오면_예외가_발생한다() {
        String input = "";

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> parser.parseInt(input));
    }

    @Test
    void 빈_리스트_입력이_들어오면_예외가_발생한다() {
        String input = "";

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> parser.parseIntList(input));
    }
}
