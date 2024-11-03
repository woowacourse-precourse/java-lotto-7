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
        lottoMachine.makeLottos();
        assertThat(lottoMachine.lottoNumbers)
                .isNotEmpty()
                .hasSize(2);
    }

    @Test
    void 당첨번호_변수에_들어갔는지_확인(){
        LottoMachine lottoMachine = new LottoMachine(2000);
        lottoMachine.inputWinnigNumbers("1,2,3,4,5,6");
        assertThat(lottoMachine.winnigNumbers)
                .isNotEmpty()
                .hasSize(6);
    }
    @Test
    void 보너스_점수_확인(){
        LottoMachine lottoMachine = new LottoMachine(2000);
        lottoMachine.inputWinnigNumbers("1,2,3,4,5,6");
        lottoMachine.inputBonusNumbers("1");
        assertThat(lottoMachine.winnigNumbers)
                .isNotEmpty()
                .hasSize(7);
    }
}