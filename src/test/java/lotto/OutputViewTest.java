package lotto;

import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoPrintFormat;
import lotto.model.lotto.LottoGenerator;
import lotto.number_generator.LottoNumberGenerator;
import lotto.number_generator.NumberGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

public class OutputViewTest {

    @Test
    void printNumbersTest() {
        NumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        LottoGenerator lottoGenerator = new LottoGenerator(lottoNumberGenerator);

        List<Integer> numbers = lottoGenerator.createNumbers();
        String expect = createExpect(numbers);

        Lotto lotto = lottoGenerator.generate(numbers);

        Assertions.assertEquals(lotto.numbersToString(), expect);
    }

    private static String createExpect(List<Integer> numbers) {
        numbers.sort(Integer::compareTo);
        String joinedNumbers = numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(LottoPrintFormat.DELIMITER));
        return LottoPrintFormat.PREFIX + joinedNumbers + LottoPrintFormat.SUFFIX;
    }
}
