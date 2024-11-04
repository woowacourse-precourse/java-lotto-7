package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RankTest extends IOTest{

    @Test
    void printTest() {

        LottoMachine machine = new LottoMachine();

        int[] result = {0,0,0,0,1};
        machine.print(result);

        assertThat(getOutput()).contains(
                "당첨 통계\n" +
                        "---\n" +
                        "3개 일치 (5,000원) - 1개\n" +
                        "4개 일치 (50,000원) - 0개\n" +
                        "5개 일치 (1,500,000원) - 0개\n" +
                        "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n" +
                        "6개 일치 (2,000,000,000원) - 0개\n");
    }
}