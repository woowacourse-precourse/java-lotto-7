package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.*;

class LottoMachineTest {
    @Test
    void 넣은금액_만큼_로또나오는지_확인() {
        LottoMachine lottoMachine = new LottoMachine(2000);
        assertThat(lottoMachine.lottoNumbers)
                .isNotEmpty()
                .hasSize(2);
    }
}