package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

    @DisplayName("로또 번호는 1부터 45사이 이외의 숫자가 있으면 예외가 발생한다.")
    @Test
    void 나눠지지_않는_경우_예외처리_테스트() {
        int lottoPrice = 1234;
        assertThatThrownBy(() -> LottoMachine.purchaseLotto(lottoPrice))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호는 1부터 45사이 이외의 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또범위_예외처리_테스트() {
        int minuslottoPrice = -1234;
        assertThatThrownBy(() -> LottoMachine.purchaseLotto(minuslottoPrice))
                .isInstanceOf(IllegalArgumentException.class);

        int zerolottoPrice = 0;
        assertThatThrownBy(() -> LottoMachine.purchaseLotto(zerolottoPrice))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("로또 번호는 1부터 45사이 이외의 숫자가 있으면 예외가 발생한다.")
    @Test
    void 티켓_개수_테스트() {
        int lottoPrice = 6000;
        List<Lotto> lottos = LottoMachine.purchaseLotto(lottoPrice);
        assertThat(lottos.size()).isEqualTo(6);
    }
}