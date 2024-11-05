package lotto.mvc.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import lotto.util.LottoList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("로또 매니저에 대한 테스트")
class LottoManagerTest {
    private LottoManager lottoManager;

    @BeforeEach
    void setUp() {
        lottoManager = new LottoManager();
    }

    @ParameterizedTest
    @DisplayName("로또 발행 개수 뽑아내는 기능")
    @CsvSource(value = {"5000:5", "30000:30", "5000000:5000"}, delimiter = ':')
    void test1(String inputAmount, String expectedCount) {
        long amount = Long.parseLong(inputAmount);  // 문자열을 long으로 변환
        int lottoCount = lottoManager.extractLottoCount(amount);

        assertEquals(Integer.parseInt(expectedCount), lottoCount);
    }

    @ParameterizedTest
    @DisplayName("로또 발행 개수만큼 발행하는 기능")
    @ValueSource(ints = {2, 12342, 15334, 324545})
    void test2(int count) {
        lottoManager.makeLottoes(count);

        LottoList lottoes = lottoManager.getLottoes();
        assertNotNull(lottoes);
        assertEquals(count, lottoes.getBunchofLottoes().size());
    }

    static Stream<List<Integer>> winningNumbersProvider() {
        return Stream.of(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(7, 8, 9, 10, 11, 12)
        );
    }

    @ParameterizedTest
    @DisplayName("로또 당첨 번호를 입력받는 기능")
    @MethodSource("winningNumbersProvider")
    void test3(List<Integer> winningNumbers) {
        lottoManager.setWinningLotto(winningNumbers);

        WinningLotto winningLotto = lottoManager.getWinningLotto();
        assertNotNull(winningLotto);
        assertEquals(winningNumbers, winningLotto.getNumbers());
    }

    @Test
    @DisplayName("로또 보너스 번호 입력받는 기능")
    void test4() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        lottoManager.setWinningLotto(winningNumbers);
        lottoManager.setBonusNumber(bonusNumber);

        WinningLotto winningLotto = lottoManager.getWinningLotto();
        assertEquals(bonusNumber, winningLotto.getBonus());
    }
}
