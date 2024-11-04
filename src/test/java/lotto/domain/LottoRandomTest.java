package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoRandom;
import org.junit.jupiter.api.Test;

class LottoRandomTest {

    @Test
    void 랜덤으로_생성한_번호들이_오름차순으로_정렬() {
        LottoRandom lottoRandom = new LottoRandom();
        int lottoCounts = 2;
        List<Lotto> lottos = lottoRandom.generateLottoRandom(lottoCounts);

        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            assertTrue(isSorted(numbers));
        }
    }

    private boolean isSorted(List<Integer> numbers) {
        for (int i = 0; i < numbers.size() - 1; i++) {
            if (numbers.get(i) > numbers.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}