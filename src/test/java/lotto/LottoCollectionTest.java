package lotto;

import domain.LottoCollection;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LottoCollectionTest {
    @Test
    void 구매_개수만큼_로또를_생성하는지_확인하는_테스트() {
        int countOfLotto = 5;
        List<List<Integer>> lottoCollection = LottoCollection.generateLottos(countOfLotto);

        assertEquals(countOfLotto, lottoCollection.size());
    }

    @Test
    void 생성한_로또의_번호가_중복이_없는지_확인하는_테스트() {
        int countOfLotto = 10;
        List<List<Integer>> lottoCollection = LottoCollection.generateLottos(countOfLotto);

        for (List<Integer> lotto : lottoCollection) {
            assertEquals(6, lotto.size());
            assertTrue(lotto.stream().distinct().count() == lotto.size());
        }
    }
}
