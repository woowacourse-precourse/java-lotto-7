package lotto.model.evaluate;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("로또 번호 매치 카운터 객체 테스트")
class LottoNumbersMatchCounterTest {

    private LottoNumbersMatchCounter lottoNumbersMatchCounter;

    @BeforeEach
    void setUp() {
        lottoNumbersMatchCounter = new LottoNumbersMatchCounter();
    }

    @DisplayName("로또 번호와 당첨 번호 간 일치하는 수를 정확하게 계산한다.")
    @ParameterizedTest(name = "로또 번호: {0}, 당첨 번호: {1}, 일치 수: {2}")
    @CsvSource({
            "'1,2,3,4,5,6', '1,2,3,4,5,6', 6",
            "'1,2,3,4,5,6', '1,2,3,4,5,7', 5",
            "'1,2,3,4,5,6', '1,2,3,4,7,8', 4",
            "'1,2,3,4,5,6', '1,2,3,7,8,9', 3",
            "'1,2,3,4,5,6', '1,2,7,8,9,10', 2",
            "'1,2,3,4,5,6', '1,7,8,9,10,11', 1",
            "'1,2,3,4,5,6', '7,8,9,10,11,12', 0"
    })
    void testCountMatches(String lottoNumbersStr, String winningNumbersStr, int expectedMatchCount) {
        List<Integer> lottoNumbers = parseNumbers(lottoNumbersStr);
        List<Integer> winningNumbers = parseNumbers(winningNumbersStr);

        int matchesCount = lottoNumbersMatchCounter.countMatches(lottoNumbers, winningNumbers);
        assertEquals(expectedMatchCount, matchesCount);
    }

    private List<Integer> parseNumbers(String numbersStr) {
        return Stream.of(numbersStr.split(","))
                .map(Integer::parseInt)
                .toList();
    }
}
