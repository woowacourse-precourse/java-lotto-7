package lotto.view;

import lotto.model.DrawNumberHacker;
import lotto.constants.view.OutputViewMessage;
import lotto.model.Winning;
import lotto.model.lotto.Lotto;
import lotto.constants.lotto.LottoNumberPrintFormat;
import lotto.model.lotto.LottoChecker;
import lotto.model.lotto.LottoPublisher;
import lotto.model.number_generator.NumberGenerator;
import lotto.model.number_generator.mock.MockLottoNumberGenerator;
import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OutputViewTest {

    private static final int LOTTO_COUNT = 5;
    private static final DrawNumberHacker HACKED_PLACE = DrawNumberHacker.HACK_THIRD_PLACE;

    private NumberGenerator testNumberGenerator;

    @BeforeEach
    void initTestNumberGenerator() {
        testNumberGenerator = new MockLottoNumberGenerator(
                DrawNumberHacker.MIN_WINNING_NUMBER,
                DrawNumberHacker.MAX_WINNING_NUMBER
        );
    }

    @AfterEach
    void winningCountClear() {
        Arrays.stream(Winning.values())
                .forEach(Winning::clear);
    }

    @DisplayName("구매한 로또의 출력이 잘못되면 예외가 발생한다.")
    @Test
    void printLottoNumbersTest() {
        LottoPublisher lottoPublisher = makeLottoPublisher();

        List<Integer> numbers = testNumberGenerator.generate();
        String expect = createExpect(numbers);
        List<Lotto> lottos = lottoPublisher.publishLotto(LOTTO_COUNT);
        Lotto lotto = lottos.getFirst();

        Assertions.assertEquals(lotto.numbersToString(), expect);
    }

    @DisplayName("당첨 개수가 잘못 계싼되면 예외가 발생한다.")
    @Test
    void winningCountTest() {
        LottoPublisher lottoPublisher = makeLottoPublisher();
        LottoChecker lottoChecker = new LottoChecker();

        List<Lotto> lottos = lottoPublisher.publishLotto(LOTTO_COUNT);
        lottoChecker.calcRevenueRate(lottos, HACKED_PLACE.getDrawNumbers());
        Assertions.assertEquals(LOTTO_COUNT, Winning.THIRD_PLACE.getCount());
    }

    @DisplayName("당첨 통계 출력이 잘못되면 예외가 발생한다.")
    @Test
    void resultToStringTest() {
        OutputView outputView = new OutputView();

        LottoPublisher lottoPublisher = makeLottoPublisher();
        LottoChecker lottoChecker = new LottoChecker();

        List<Lotto> lottos = lottoPublisher.publishLotto(LOTTO_COUNT);
        double revenueRate = lottoChecker.calcRevenueRate(lottos, HACKED_PLACE.getDrawNumbers());
        double roundRevenueRate = Math.round(revenueRate * 100) / 100.0;

        String str = makeExpectResult(roundRevenueRate);

        Assertions.assertEquals(outputView.resultToString(revenueRate), str);
    }

    private LottoPublisher makeLottoPublisher() {
        return new LottoPublisher(testNumberGenerator);
    }

    private static String makeExpectResult(double roundRevenueRate) {
        StringBuilder sb = new StringBuilder();
        sb.append(OutputViewMessage.RESULT_HEADER);
        Arrays.stream(Winning.values()).forEach(winning -> sb.append(winning.toString()));
        sb.append(String.format(OutputViewMessage.REVENUE_RATE_MESSAGE, roundRevenueRate));

        return sb.toString();
    }

    private static String createExpect(List<Integer> numbers) {
        numbers.sort(Integer::compareTo);
        String joinedNumbers = numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(LottoNumberPrintFormat.DELIMITER));
        return LottoNumberPrintFormat.PREFIX + joinedNumbers + LottoNumberPrintFormat.SUFFIX;
    }
}
