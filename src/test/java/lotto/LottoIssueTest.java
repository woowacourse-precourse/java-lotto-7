package lotto;

import java.util.*;
import lotto.controller.LottoNumberController;
import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LottoIssueTest {
    private final LottoNumberController lottoNumberController = new LottoNumberController();
    private static final int LOTTO_MIN = 1;
    private static final int LOTTO_MAX = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    @Test
    void 주어진_수량만큼_로또_발행() {
        List<Lotto> testLottos = lottoNumberController.issueLottos(10);
        // 로또가 주어진 수량인 10장만큼 발행되었는지
        assertThat(testLottos.size()).isEqualTo(10);

        for (Lotto lotto : testLottos) {
            List<Integer> numbers = lotto.getNumbers();
            // 로또 번호가 6개인지
            assertThat(numbers.size()).isEqualTo(LOTTO_NUMBER_COUNT);
            // 모든 로또 번호가 1 이상 45 이하의 정수인지
            assertTrue(numbers.stream().allMatch(num -> num >= LOTTO_MIN && num <= LOTTO_MAX));
            // 로또 번호가 중복되지 않는지
            Set<Integer> numbersSet = new HashSet<>(numbers);
            assertThat(numbersSet.size()).isEqualTo(numbers.size());
            // 로또 번호가 오름차순으로 정렬되어 있는지
            assertThat(numbers).isSorted();
        }
    }
}
