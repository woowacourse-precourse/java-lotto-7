package lotto;

import java.util.ArrayList;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoVendingMachineTest {
    private LottoVendingMachine lottoVendingMachine;

    @BeforeEach
    void 테스트_사전작업(){
        this.lottoVendingMachine = new LottoVendingMachine();
    }

    @DisplayName("구입 금액에 맞게 로또가 생성되는지 테스트합니다.")
    @Test
    void 구입금액에_맞게_로또가_생성되는지_테스트(){
        ArrayList<Lotto> lottoTickets;

        lottoTickets = lottoVendingMachine.giveLotto(4000);

        Assertions.assertThat(lottoTickets.size()).isEqualTo(4);
    }

}
