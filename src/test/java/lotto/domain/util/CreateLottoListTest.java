package lotto.domain.util;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CreateLottoListTest {

    @Test
    @DisplayName("로또 구입 금액에 맞는 로또를 생성하는지 테스트한다.")
    void createCreateListTest() {
        int amount = 8000;
        int count = amount / 1000;

        List<Lotto> lottos = CreateLottoList.create(count);

        assertThat(lottos.size()).isEqualTo(count);
    }
}