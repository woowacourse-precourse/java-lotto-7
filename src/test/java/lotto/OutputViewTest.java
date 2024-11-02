package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

public class OutputViewTest {

    @Test
    void printNumbersTest() {
        NumberGenerator testNumberGenerator = new TestNumberGenerator();
        LottoGenerator lottoGenerator = new LottoGenerator(testNumberGenerator);

        List<Integer> numbers = lottoGenerator.createNumbers();
        String expect = createExpect(numbers);

        Lotto lotto = lottoGenerator.generate(numbers);

        Assertions.assertEquals(lotto.numbersToString(), expect);
    }

    private static String createExpect(List<Integer> numbers) {
        String joinedNumbers = numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(LottoFormat.DELIMITER));
        return LottoFormat.PREFIX + joinedNumbers + LottoFormat.SUFFIX;
    }
}
