package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoManagerTest {

    private LottoManager manager;

    @BeforeEach
    void setUp() {
        manager = new LottoManager();
        manager.setPurchaseAmountForTest(3);
    }
    @Test
    void 로또_리스트_갯수_테스트(){
        manager.setLotto();
        List<Lotto> lottoList = manager.getLottoList();
        assertThat(lottoList.size()).isEqualTo(3);
    }

    @Test
    void 로또_정렬_테스트(){
        manager.setLotto();
        List<Lotto> testList = manager.getLottoList();
        for (Lotto lotto : testList) {
            List<Integer> numbers = lotto.getNumbers();
            assertThat(numbers).isSorted();
        }
    }
}