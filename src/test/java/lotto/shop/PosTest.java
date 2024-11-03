package lotto.shop;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PosTest {

    lotto.shop.Pos pos = new lotto.shop.Pos();

    @ParameterizedTest
    @ValueSource(ints = {1000,2000,3000,4000,5000,10000,100000,1000000})
    @DisplayName("totalCount는 입력한 금액을 1000원으로 나눈 값이다.")
    void totalCount는_입력한_금액을_1000원으로_나눈_값이다(int money) {
        assertThat(pos.checkCount(money)).isEqualTo(money/1000);
    }

}
