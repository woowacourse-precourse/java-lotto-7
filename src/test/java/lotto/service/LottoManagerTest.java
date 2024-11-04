package lotto.service;

import lotto.model.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoManagerTest {

    LottoManager lottoManager;
    @BeforeEach
    void setUp(){
        lottoManager = new LottoManager();
    }

    @Test
    void buyLottos() {
        int count = 10;
        lottoManager.buyLottos(count);

        assertThat(lottoManager.getLottos()).hasSize(10);
    }

    @Test
    void generateLottoWithNumbers() {
        List<Integer> numbers = new ArrayList<>(List.of(1,2,3,4,5,6));
        Lotto lotto = lottoManager.generateLottoWithNumbers(numbers);

        assertThat(lotto.getNumbers()).isEqualTo(numbers);
    }
}