package lotto.domain.ticket;

import static lotto.constants.LottoTicket.LOWER_BOUND;
import static lotto.constants.LottoTicket.NUMBERS_PER_LOTTO;
import static lotto.constants.LottoTicket.UPPER_BOUND;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("[Domain] LottoNumbersGenerator")
public class LottoNumbersGeneratorTest {

    @Nested
    @DisplayName("[generate]생성되는 로또 번호의 유효성을 검증한다")
    class generateTest{
        @Test
        @DisplayName("[generate] 범위 내에 속하며, 중복되는 숫자 없이 로또 번호들이 생성되었다.")
        public void Given_LottoNumbersGenerator_When_Generate_Then_ReturnValidNumbers() {
            // Given
            LottoNumbersGenerator generator = new LottoNumbersGenerator();

            // When
            List<Integer> generatedNumbers = generator.generate();

            // Then
            assertEquals(NUMBERS_PER_LOTTO.getValue(), generatedNumbers.size());

            for (Integer number : generatedNumbers) {
                assertTrue(number >= LOWER_BOUND.getValue() && number <= UPPER_BOUND.getValue());
            }

            long distinctCount = generatedNumbers.stream().distinct().count();
            assertEquals(distinctCount, generatedNumbers.size());
        }

    }


}
