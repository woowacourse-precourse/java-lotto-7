package lotto.util;

import lotto.constant.Amount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.constant.Amount.MAXIMUM_LOTTO_NUMBER;
import static lotto.constant.Amount.MINIMUM_LOTTO_NUMBER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LottoNumberGeneratorTest {

    private static final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

    private static final int TEST_PURCHASE_AMOUNT = 20000;
    private static final int NEXT_INDEX = 1;


    @Nested
    class 발행된_로또_번호_검증_테스트 {

        @Test
        void 발행된_로또_번호_오름차순_정렬여부_검증() {

            List<List<Integer>> generatedLottoNumbers =
                    lottoNumberGenerator.generateLottoNumbers(TEST_PURCHASE_AMOUNT);

            List<Integer> firstIssuedNumbers = generatedLottoNumbers.get(0);

            List<Integer> secondIssuedNumbers = generatedLottoNumbers.get(1);

            assertTrue(isSortedAscending(firstIssuedNumbers));

            assertTrue(isSortedAscending(secondIssuedNumbers));

        }

        @Test
        void 발행된_로또_번호가_여섯자리로_구성되었는지_검증() {

            List<List<Integer>> generatedLottoNumbers =
                    lottoNumberGenerator.generateLottoNumbers(TEST_PURCHASE_AMOUNT);

            List<Integer> firstIssuedNumbers = generatedLottoNumbers.get(0);

            List<Integer> secondIssuedNumbers = generatedLottoNumbers.get(1);

            assertEquals(firstIssuedNumbers.size(), Amount.LOTTO_NUMBERS_SIZE.getValue());

            assertEquals(secondIssuedNumbers.size(), Amount.LOTTO_NUMBERS_SIZE.getValue());

        }

        @Test
        @DisplayName("발행된 로또 번호의 최대값이 45 이하인지 검증")
        void 발행된_로또_번호의_최대값이_45_이하인지_검증() {
            List<List<Integer>> generatedLottoNumbers = lottoNumberGenerator.generateLottoNumbers(TEST_PURCHASE_AMOUNT);

            generatedLottoNumbers.stream()
                    .forEach(lottoNumbers -> {
                        lottoNumbers.forEach(lottoNumber -> {
                            Assertions.assertTrue(lottoNumber <= MAXIMUM_LOTTO_NUMBER.getValue());
                        });
                    });
        }

        @Test
        @DisplayName("발행된 로또 번호의 최소값이 1 이상인지 검증")
        void 발행된_로또_번호의_최소값이_1_이상인지_검증() {

            List<List<Integer>> generatedLottoNumbers = lottoNumberGenerator.generateLottoNumbers(TEST_PURCHASE_AMOUNT);

            generatedLottoNumbers.stream()
                    .forEach(lottoNumbers -> {
                        lottoNumbers.forEach(lottoNumber -> {
                            Assertions.assertTrue(lottoNumber >= MINIMUM_LOTTO_NUMBER.getValue());
                        });
                    });
        }

        private boolean isSortedAscending(List<Integer> winningNumbers) {
            for (int i = 0; i < winningNumbers.size() - 1; i++) {
                if (winningNumbers.get(i) > winningNumbers.get(i + NEXT_INDEX)) {
                    return false;
                }
            }
            return true;
        }
    }
}
