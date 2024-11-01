package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoListTest {

    @Test
    @DisplayName("돈을 입력받고 개수 확인")
    void test1() {
        Money money = new Money("10000");

        LottoList lottoList = LottoList.generate(money);

        assertThat(lottoList.size()).isEqualTo(10);
    }

}
