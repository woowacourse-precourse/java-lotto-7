package lotto.service;

import lotto.constants.LottoConstants;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoGeneratorTest {

    @Test
    @DisplayName("로또가 정상적으로 뽑히는지 테스트")
    void generateLottoNumbersTest() {
        // given
        int lottoCount = 5;

        // when
        List<Lotto> lottos = LottoGenerator.getRandomLottos(lottoCount);

        // then
        assertEquals(lottoCount, lottos.size());
        for (Lotto lotto : lottos) {
            assertEquals(LottoConstants.NUMBER_OF_LOTTO, lotto.getNumbers().size());
        }
    }

    @Test
    @DisplayName("로또 번호가 오름차순으로 정렬되었는지 테스트")
    void generateLottoNumbersSortedTest() {
        // given
        int lottoCount = 5;

        // when
        List<Lotto> lottos = LottoGenerator.getRandomLottos(lottoCount);

        // then
        for (Lotto lotto : lottos) {
            List<Integer> originalNumbers = lotto.getNumbers();
            List<Integer> sortedNumbers = originalNumbers.stream().sorted().toList();

            assertEquals(originalNumbers, sortedNumbers);
        }
    }

}
