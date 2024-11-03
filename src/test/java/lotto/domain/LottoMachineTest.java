package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

    @DisplayName("여러 개의 로또를 생성한다.")
    @Test
    void generateLottosTest() {
        int lottoCount = 3;
        NumbersGenerator fixedNumbersGenerator = () -> List.of(1, 2, 3, 4, 5, 6);
        LottoMachine lottoMachine = new LottoMachine(lottoCount, fixedNumbersGenerator);

        LottoTicket lottoTicket = new LottoTicket(lottoMachine.generateLottos());

        lottoTicket.getLottos().forEach(lotto ->
                assertThat(lotto.getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6))
        );
    }
}
