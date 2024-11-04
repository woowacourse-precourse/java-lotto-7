package view;

import lotto.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class outputViewTest
{
    private outputView outputView;

    @BeforeEach
    void setUp()
    {
        outputView = new outputView();
    }

    @Test
    @DisplayName("randomNumber 메소드가 입력된 로또 번호들을 올바르게 변환하는지 테스트")
    void randomNumber_ShouldConvertLottoNumbersCorrectly()
    {
        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> numbers2 = Arrays.asList(7, 8, 9, 10, 11, 12);
        List<Lotto> lottos = Arrays.asList(
                new Lotto(numbers1),
                new Lotto(numbers2)
        );
        List<List<Integer>> result = outputView.randomNumber(lottos);
        assertThat(result).hasSize(2);
        assertThat(result.get(0)).containsExactly(1, 2, 3, 4, 5, 6);
        assertThat(result.get(1)).containsExactly(7, 8, 9, 10, 11, 12);
        assertThat(outputView.usedPrice).isEqualTo(2000); // 2장 * 1000원
    }

    @Test
    @DisplayName("inputPrice 메소드가 당첨 통계를 올바르게 저장하는지 테스트")
    void inputPrice_ShouldStoreStatisticsCorrectly()
    {
        List<Integer> stats = Arrays.asList(1, 2, 3, 4, 5); // 3개,4개,5개,5+보너스,6개 매칭
        outputView.inputPrice(stats);
        assertThat(outputView.three).isEqualTo(1);
        assertThat(outputView.four).isEqualTo(2);
        assertThat(outputView.five).isEqualTo(3);
        assertThat(outputView.fiveAndBonus).isEqualTo(4);
        assertThat(outputView.six).isEqualTo(5);
    }

    @Test
    @DisplayName("choose 메소드가 올바른 개수의 로또를 생성하는지 테스트")
    void choose_ShouldGenerateCorrectNumberOfLottos()
    {
        outputView.inputUsedPrice(5000);
        List<Lotto> result = outputView.choose();
        assertThat(result).hasSize(5);
        result.forEach(lotto ->
                assertThat(lotto.getNumbers()).hasSize(6)
        );
    }

    @Test
    @DisplayName("수익률 계산이 올바르게 되는지 테스트")
    void calculateProfit_ShouldCalculateCorrectly() {
        outputView.inputUsedPrice(10000);
        outputView.inputPrice(Arrays.asList(1, 1, 1, 1, 1));
        outputView.printWinningStatistics();
        double expectedTotal = (outputView.PRIZE_3 + outputView.PRIZE_4 + outputView.PRIZE_5
                + outputView.PRIZE_5_AND_BONUS + outputView.PRIZE_6) * 100.0 / 10000;
        assertThat(outputView.totalPrice).isEqualTo(expectedTotal);
    }

    @Test
    @DisplayName("로또 번호 출력 형식이 올바른지 테스트")
    void printNumberLists_ShouldFormatCorrectly()
    {
        List<List<Integer>> numberLists = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(7, 8, 9, 10, 11, 12)
        );
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        outputView.printNumberLists(numberLists);
        String expectedOutput = "[1, 2, 3, 4, 5, 6]\n[7, 8, 9, 10, 11, 12]\n";
        assertThat(outContent.toString()).isEqualTo(expectedOutput);
        System.setOut(System.out);
    }

    @Test
    @DisplayName("초기 상태가 올바르게 설정되는지 테스트")
    void constructor_ShouldInitializeCorrectly()
    {
        outputView newOutputView = new outputView();

        assertThat(newOutputView.three).isZero();
        assertThat(newOutputView.four).isZero();
        assertThat(newOutputView.five).isZero();
        assertThat(newOutputView.fiveAndBonus).isZero();
        assertThat(newOutputView.six).isZero();
    }

    @Test
    @DisplayName("사용 금액 입력이 올바르게 되는지 테스트")
    void inputUsedPrice_ShouldSetCorrectly()
    {
        outputView.inputUsedPrice(5000);
        assertThat(outputView.usedPrice).isEqualTo(5000);
    }
}