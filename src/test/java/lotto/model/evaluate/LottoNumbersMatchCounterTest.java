package lotto.model.evaluate;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로또 번호 매치 카운터 객체 테스트")
class LottoNumbersMatchCounterTest {

    @DisplayName("6개가 동일한 경우")
    @Test
    void shouldReturn6_WhenAllMatch() {
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        LottoNumbersMatchCounter lottoNumbersMatchCounter = new LottoNumbersMatchCounter();

        int matchesCount = lottoNumbersMatchCounter.countMatches(lottoNumbers, winningNumbers);
        assertEquals(matchesCount, 6);
    }

    @DisplayName("5개가 동일한 경우")
    @Test
    void shouldReturn5_When5Match() {
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 7);
        LottoNumbersMatchCounter lottoNumbersMatchCounter = new LottoNumbersMatchCounter();

        int matchesCount = lottoNumbersMatchCounter.countMatches(lottoNumbers, winningNumbers);
        assertEquals(matchesCount, 5);
    }

    @DisplayName("4개가 동일한 경우")
    @Test
    void shouldReturn4_When4Match() {
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 7, 8);
        LottoNumbersMatchCounter lottoNumbersMatchCounter = new LottoNumbersMatchCounter();

        int matchesCount = lottoNumbersMatchCounter.countMatches(lottoNumbers, winningNumbers);
        assertEquals(matchesCount, 4);
    }

    @DisplayName("3개가 동일한 경우")
    @Test
    void shouldReturn3_When3Match() {
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningNumbers = List.of(1, 2, 3, 7, 8, 9);
        LottoNumbersMatchCounter lottoNumbersMatchCounter = new LottoNumbersMatchCounter();

        int matchesCount = lottoNumbersMatchCounter.countMatches(lottoNumbers, winningNumbers);
        assertEquals(matchesCount, 3);
    }

    @DisplayName("2개가 동일한 경우")
    @Test
    void shouldReturn2_When2Match() {
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningNumbers = List.of(1, 2, 7, 8, 9, 10);
        LottoNumbersMatchCounter lottoNumbersMatchCounter = new LottoNumbersMatchCounter();

        int matchesCount = lottoNumbersMatchCounter.countMatches(lottoNumbers, winningNumbers);
        assertEquals(matchesCount, 2);
    }

    @DisplayName("1개가 동일한 경우")
    @Test
    void shouldReturn1_When1Match() {
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningNumbers = List.of(1, 7, 8, 9, 10, 11);
        LottoNumbersMatchCounter lottoNumbersMatchCounter = new LottoNumbersMatchCounter();

        int matchesCount = lottoNumbersMatchCounter.countMatches(lottoNumbers, winningNumbers);
        assertEquals(matchesCount, 1);
    }

    @DisplayName("동일한 숫자가 없는 경우")
    @Test
    void shouldReturn0_WhenNotMatch() {
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningNumbers = List.of(7, 8, 9, 10, 11, 12);
        LottoNumbersMatchCounter lottoNumbersMatchCounter = new LottoNumbersMatchCounter();

        int matchesCount = lottoNumbersMatchCounter.countMatches(lottoNumbers, winningNumbers);
        assertEquals(matchesCount, 0);
    }
}
