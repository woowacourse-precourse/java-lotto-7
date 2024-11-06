package lotto.domain.winner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Map;
import lotto.domain.lotto.ResultState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("우승자 빈도수를 테스트한다.")
class WinnerFrequencyTest {

    @DisplayName("우승자 빈도수 메시지를 검증한다.")
    @ParameterizedTest
    @CsvSource(value = {
            "THREE,3",
            "FOUR,4",
            "FIVE,5",
            "FIVE_BONUS,6",
            "SIX,2"
    }, delimiter = ',')
    void winnerFrequencyMessageFormatTest2(String state, int frequency) {
        WinnerFrequency winnerFrequency = new WinnerFrequency(ResultState.valueOf(state), frequency);
        Map<ResultState, String> expectedMessages = Map.of(
                ResultState.THREE, "3개 일치 (5,000원) - 3개",
                ResultState.FOUR, "4개 일치 (50,000원) - 4개",
                ResultState.FIVE, "5개 일치 (1,500,000원) - 5개",
                ResultState.FIVE_BONUS, "5개 일치, 보너스 볼 일치 (30,000,000원) - 6개",
                ResultState.SIX, "6개 일치 (2,000,000,000원) - 2개"
        );

        String message = winnerFrequency.getMessage();

        assertAll(() -> assertThat(message).isEqualTo(expectedMessages.get(ResultState.valueOf(state))));
    }
}