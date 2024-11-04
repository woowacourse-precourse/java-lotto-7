package lotto;

import lotto.domain.Lotto;
import lotto.service.LottoMachineImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineImplTest {

    @DisplayName("1이상 45이하의 중복되지 않는 6개의 숫자로 로또가 생성된다")
    @Test
    void 로또_생성() {
        //given
        LottoMachineImpl lottoMachine = new LottoMachineImpl();
        //when
        Lotto lotto = lottoMachine.generateLotto();
        long count = lotto.getNumbers().stream().
                distinct().
                count();
        //then
        Assertions.assertThat(count).isEqualTo(6);
        Assertions.assertThat(lotto.getNumbers()).
                allMatch(number->number>=1 && number<=45);
    }
}