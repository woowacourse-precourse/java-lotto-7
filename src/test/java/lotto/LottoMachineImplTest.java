package lotto;

import lotto.domain.Lotto;
import lotto.service.LottoMachineImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoMachineImplTest {

    @Test
    void 로또_생성_테스트() {
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
                allMatch(number -> number >= 1 && number <= 45);
    }
}