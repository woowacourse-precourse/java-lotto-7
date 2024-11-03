package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


//class LotteryMachineTest {
//
//    @Test
//    @DisplayName("1,000원 투입 시 1개의 로또가 생성된다.")
//    void 로또_한_개가_출력() {
//        LotteryMachine lotteryMachine = new LotteryMachine();
//        lotteryMachine.drawLottos(1000);
//        assertThat(lotteryMachine.getLottos())
//                .hasSize(1);
//    }
//}