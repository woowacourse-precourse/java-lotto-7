package lotto.entity;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottoMachineTest {
    @Test
    void 성공__객체생성() {
        // given
        int paymentAmount = 14000;
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        // when
        LottoMachine lottoMachine = new LottoMachine(paymentAmount, winningNumbers, bonusNumber);

        // then
        Assertions.assertNotNull(lottoMachine);
    }

    @Test
    void 실패__로또_생성_테스트() {
        // given

        // when

        // then
    }
}
