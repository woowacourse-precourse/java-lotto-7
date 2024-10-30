package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

    private LottoMachine lottoMachine;

    @BeforeEach
    void init() {
        List<Integer> winNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        lottoMachine = new LottoMachine(winNumbers, bonusNumber);
    }

    @DisplayName("로또 기계에서 당첨 번호를 뽑는다")
    @Test
    void 로또_기계에서_당첨번호_뽑기() {
        List<Integer> winNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        Assertions.assertThat(lottoMachine.getWinNumbers()).isEqualTo(winNumbers);
    }

    @DisplayName("로또 기계에서 보너스 번호를 뽑는다")
    @Test
    void 로또_기계에서_보너스_번호_뽑기() {
        int bonusNumber = 7;

        Assertions.assertThat(lottoMachine.getBonusNumber()).isEqualTo(bonusNumber);
    }

}