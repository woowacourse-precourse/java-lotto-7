package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    private static List<List<Integer>> lottoNumberList;

    @Test
    void 로또_랜덤숫자_생성() {
        LottoMachine lottoMachine = new LottoMachine();
        lottoNumberList = lottoMachine.generateLottoNumbers(6);

        assertThat(lottoNumberList.size()).isEqualTo(6);
    }
}