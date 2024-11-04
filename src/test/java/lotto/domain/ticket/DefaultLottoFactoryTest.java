package lotto.domain.ticket;

import static lotto.constants.LottoTicket.LOWER_BOUND;
import static lotto.constants.LottoTicket.NUMBERS_PER_LOTTO;
import static lotto.constants.LottoTicket.UPPER_BOUND;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class DefaultLottoFactoryTest {


    @Nested
    @DisplayName("[createLotto] 로또 생성 기능을 검증한다.")
    class CreateLottoTest {

        @Test
        @DisplayName("[create] 고정된 번호 리스트가 주어지면 로또가 정상적으로 생성된다")
        public void Given_NumbersGenerator_When_CreateLotto_Then_ReturnLotto() {
            // Given
            NumbersGenerator mockGenerator = new NumbersGenerator() {
                @Override
                public List<Integer> generate() {
                    // 고정된 번호 리스트를 반환
                    return List.of(1, 2, 3, 4, 5, 6);
                }
            };
            DefaultLottoFactory factory = new DefaultLottoFactory(mockGenerator);

            // When
            Lotto lotto = factory.createLotto();

            // Then
            assertNotNull(lotto);
            List<Integer> lottoNumbers = lotto.getNumbers();
            assertEquals(NUMBERS_PER_LOTTO.getValue(), lottoNumbers.size());
            assertEquals(List.of(1, 2, 3, 4, 5, 6), lottoNumbers);
        }

        @Test
        @DisplayName("[create] 유효한 번호 생성기를 사용하여 로또가 생성된다")
        public void Given_ValidNumbersGenerator_When_CreateLotto_Then_ReturnValidLotto() {
            // Given
            NumbersGenerator numbersGenerator = new LottoNumbersGenerator(); // 실제 번호 생성기 사용
            DefaultLottoFactory factory = new DefaultLottoFactory(numbersGenerator);

            // When
            Lotto lotto = factory.createLotto();

            // Then
            assertNotNull(lotto);
            List<Integer> lottoNumbers = lotto.getNumbers();
            assertEquals(NUMBERS_PER_LOTTO.getValue(), lottoNumbers.size());
            for (Integer number : lottoNumbers) {
                assertTrue(number >= LOWER_BOUND.getValue() && number <= UPPER_BOUND.getValue());
            }
            long distinctCount = lottoNumbers.stream().distinct().count();
            assertEquals(distinctCount, lottoNumbers.size());
        }
    }
}
