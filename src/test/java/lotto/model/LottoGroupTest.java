package lotto.model;

import static lotto.constants.CommonConstants.LOTTO_SIZE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

class LottoGroupTest {

    @Test
    void 로또_그룹은_지정된_갯수만큼_로또를_생성한다() {
        // Given
        long numLotto = 5;

        // When
        LottoGroup lottoPurchaseDetails = new LottoGroup(numLotto);
        List<Lotto> lottoGroup = lottoPurchaseDetails.getLottos();

        // Then
        assertEquals(numLotto, lottoGroup.size());
    }

    @Test
    void 로또_그룹에서_생성된_모든_로또는_고유하다() {
        // Given
        long numLotto = 100;

        // When
        LottoGroup lottoPurchaseDetails = new LottoGroup(numLotto);
        List<Lotto> lottoGroup = lottoPurchaseDetails.getLottos();

        // Then
        Set<Integer> uniqueIds = new HashSet<>();
        for (Lotto lotto : lottoGroup) {
            uniqueIds.add(lotto.getId());
        }

        assertEquals(numLotto, uniqueIds.size());
    }

    @Test
    void 로또_그룹에서_생성된_모든_로또는_유효하다() {
        // Given
        long numLotto = 10;

        // When
        LottoGroup lottoPurchaseDetails = new LottoGroup(numLotto);
        List<Lotto> lottoGroup = lottoPurchaseDetails.getLottos();

        // Then
        for (Lotto lotto : lottoGroup) {
            assertNotNull(lotto);
            assertEquals(LOTTO_SIZE, lotto.getNumbers().size());
            assertTrue(lotto.getNumbers().stream().allMatch(num -> num >= 1 && num <= 45));

            List<Integer> numbers = lotto.getNumbers();
            boolean isSorted = IntStream.range(0, numbers.size() - 1)
                    .allMatch(i -> numbers.get(i) < numbers.get(i + 1));
            assertTrue(isSorted);
        }
    }

}