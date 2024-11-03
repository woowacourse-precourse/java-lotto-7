package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Ranking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OutputViewTest {

    private ByteArrayOutputStream outputStream;
    private OutputView outputView;

    @BeforeEach
    void setUp() {
        // 표준 출력을 캡처하기 위한 설정
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        outputView = new OutputView();
    }

    @Test
    @DisplayName("로또 번호 출력 테스트")
    void printLottoNumbers_단일로또번호_출력테스트() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);
        List<Lotto> lottoes = List.of(lotto);

        // when
        outputView.printLottoNumbers(lottoes);

        // then
        String expected = "[1, 2, 3, 4, 5, 6]\n";
        assertThat(outputStream.toString()).hasToString(expected);
    }

    @Test
    @DisplayName("로또 번호 복수 출력 테스트")
    void printLottoNumbers_복수로또번호_출력테스트() {
        // given
        List<Lotto> lottoes = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12))
        );

        // when
        outputView.printLottoNumbers(lottoes);

        // then
        String expected = "[1, 2, 3, 4, 5, 6]\n[7, 8, 9, 10, 11, 12]\n";
        assertThat(outputStream.toString()).hasToString(expected);
    }

    @Test
    @DisplayName("로또 번호 출력 테스트 - null 입력시 예외 발생")
    void printLottoNumbers_null입력시_예외발생() {
        // given
        List<Lotto> lottoes = null;

        // when & then
        assertThatThrownBy(() -> outputView.printLottoNumbers(lottoes))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("로또 당첨 결과 출력 테스트 - 당첨자 있을 때")
    void printWinningResult_모든등수_당첨자있음() {
        // given
        Map<Ranking, Integer> result = new EnumMap<>(Ranking.class);
        result.put(Ranking.FIFTH, 1);   // 3개 일치
        result.put(Ranking.FOURTH, 1);  // 4개 일치
        result.put(Ranking.THIRD, 1);   // 5개 일치
        result.put(Ranking.SECOND, 1);  // 5개 + 보너스볼 일치
        result.put(Ranking.FIRST, 1);   // 6개 일치

        // when
        outputView.printWinningResult(result);

        // then
        String expected = String.format(
                "3개 일치 (5,000원) - 1개%n" +
                "4개 일치 (50,000원) - 1개%n" +
                "5개 일치 (1,500,000원) - 1개%n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개%n" +
                "6개 일치 (2,000,000,000원) - 1개%n");

        assertThat(outputStream.toString()).hasToString(expected);
    }

    @Test
    @DisplayName("수익 결과 출력 테스트 - 수익 발생")
    void printEarningRate_수익발생() {
        // given
        double earningRate = 150.5;

        // when
        outputView.printEarningRate(earningRate);

        // then
        String expected = "총 수익률은 150.5%입니다.";
        assertThat(outputStream.toString()).hasToString(expected);
    }

    @Test
    @DisplayName("수익 결과 출력 테스트 - 소수점 첫째 자리까지 출력")
    void printEarningRate_소수점첫째자리까지출력() {
        // given
        double earningRate = 123.456;

        // when
        outputView.printEarningRate(earningRate);

        // then
        String expected = "총 수익률은 123.5%입니다.";
        assertThat(outputStream.toString()).hasToString(expected);
    }
}