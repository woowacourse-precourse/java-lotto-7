package lotto;

import lotto.model.Winning;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.constant.LottoNumberPrintFormat;
import lotto.model.lotto.LottoChecker;
import lotto.model.lotto.LottoPublisher;
import lotto.model.number_generator.NumberGenerator;
import lotto.model.number_generator.TestNumberGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OutputViewTest {

    private static final int LOTTO_COUNT = 5;
    private static final DrawNumberHacker HACKED_PLACE = DrawNumberHacker.HACK_THIRD_PLACE;

    private NumberGenerator testNumberGenerator;

    @BeforeEach
    void initTestNumberGenerator() {
        testNumberGenerator = new TestNumberGenerator(
                DrawNumberHacker.MIN_WINNING_NUMBER,
                DrawNumberHacker.MAX_WINNING_NUMBER
        );
    }

    @AfterEach
    void winningCountClear() {
        Arrays.stream(Winning.values())
                .forEach(Winning::clear);
    }

    @Test
    void printLottoNumbersTest() {
        LottoPublisher lottoPublisher = makeLottoPublisher();

        List<Integer> numbers = testNumberGenerator.generate();
        String expect = createExpect(numbers);
        List<Lotto> lottos = lottoPublisher.publishLotto(LOTTO_COUNT);
        Lotto lotto = lottos.getFirst();

        Assertions.assertEquals(lotto.numbersToString(), expect);
    }

    @Test
    void winningCountTest() {
        LottoPublisher lottoPublisher = makeLottoPublisher();
        LottoChecker lottoChecker = new LottoChecker(HACKED_PLACE.getDrawNumbers());

        List<Lotto> lottos = lottoPublisher.publishLotto(LOTTO_COUNT);
        lottoChecker.calcRevenueRate(lottos, LOTTO_COUNT);
        Assertions.assertEquals(LOTTO_COUNT, Winning.THIRD_PLACE.getCount());
    }

    @Test
    void resultToStringTest() {
        OutputView outputView = new OutputView();

        LottoPublisher lottoPublisher = makeLottoPublisher();
        LottoChecker lottoChecker = new LottoChecker(HACKED_PLACE.getDrawNumbers());

        List<Lotto> lottos = lottoPublisher.publishLotto(LOTTO_COUNT);
        double revenueRate = lottoChecker.calcRevenueRate(lottos, LOTTO_COUNT);
        double roundRevenueRate = Math.round(revenueRate * 100) / 100.0;

        StringBuilder sb = new StringBuilder();
        makeExpectResult(sb, roundRevenueRate);

        Assertions.assertEquals(outputView.resultToString(revenueRate), sb.toString());
    }

    private LottoPublisher makeLottoPublisher() {
        return new LottoPublisher(testNumberGenerator);
    }

    private static void makeExpectResult(StringBuilder sb, double roundRevenueRate) {
        sb.append("당첨 통계\n")
                .append("---\n");
        Arrays.stream(Winning.values()).forEach(winning -> sb.append(winning.toString()));
        sb.append("총 수익률은 ").append(roundRevenueRate).append("%입니다.");
    }

    private static String createExpect(List<Integer> numbers) {
        numbers.sort(Integer::compareTo);
        String joinedNumbers = numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(LottoNumberPrintFormat.DELIMITER));
        return LottoNumberPrintFormat.PREFIX + joinedNumbers + LottoNumberPrintFormat.SUFFIX;
    }
}
