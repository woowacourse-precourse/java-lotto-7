package lotto;

import lotto.model.Winning;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoPrintFormat;
import lotto.model.lotto.LottoMachine;
import lotto.model.lotto.LottoPublisher;
import lotto.number_generator.NumberGenerator;
import lotto.number_generator.TestNumberGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OutputViewTest {

    @Test
    void printLottoNumbersTest() {
        LottoPublisher lottoPublisher = makeLottoPublisher();

        List<Integer> numbers = testNumberGenerator.generate();
        String expect = createExpect(numbers);
        List<Lotto> lottos = lottoPublisher.publishLotto(LOTTO_COUNT);
        Lotto lotto = lottos.getFirst();

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
