package lotto;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottoMachineTest {


    @Test
    void 당첨을_판단_한다() {
        //given
        LottoFactory lottoFactory = new LottoFactory();
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lottoNumber = lottoFactory.createLottoByNumbers(numbers);

        LottoMachineFactory lottoMachineFactory = new LottoMachineFactory();
        LottoMachine lottoMachine = lottoMachineFactory.createLottoMachine(lottoNumber, 1);

        //when
        Lotto lotto = lottoFactory.createLottoByNumbers(List.of(1, 5, 3, 9, 10, 11));
        WinningType winningType = lottoMachine.checkWinning(lotto);

        //then
        WinningFactory winningFactory = new WinningFactory();
        WinningTypes winningTypes = winningFactory.createWinningTypes();
        Assertions.assertThat(winningType).isEqualTo(winningTypes.getWinning(3));
    }

    @Test
    void 보너스당첨을_판단_한다() {
        //given
        LottoFactory lottoFactory = new LottoFactory();
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lottoNumber = lottoFactory.createLottoByNumbers(numbers);

        LottoMachineFactory lottoMachineFactory = new LottoMachineFactory();
        LottoMachine lottoMachine = lottoMachineFactory.createLottoMachine(lottoNumber, 1);

        //when
        Lotto lotto = lottoFactory.createLottoByNumbers(List.of(1, 2, 6, 5, 10, 11));
        WinningType winningType = lottoMachine.checkWinning(lotto);

        //then
        WinningFactory winningFactory = new WinningFactory();
        WinningTypes winningTypes = winningFactory.createWinningTypes();
        Assertions.assertThat(winningType).isEqualTo(winningTypes.getWinning(4));
    }

    @Test
    void 가장금액이_높은_당첨을_판단_한다() {
        //given
        LottoFactory lottoFactory = new LottoFactory();
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lottoNumber = lottoFactory.createLottoByNumbers(numbers);

        LottoMachineFactory lottoMachineFactory = new LottoMachineFactory();
        LottoMachine lottoMachine = lottoMachineFactory.createLottoMachine(lottoNumber, 1);

        //when
        Lotto lotto = lottoFactory.createLottoByNumbers(List.of(1, 2, 3, 4, 5, 6));
        WinningType winningType = lottoMachine.checkWinning(lotto);

        //then
        Assertions.assertThat(winningType.getPrize()).isEqualTo(2000000000);
    }
}
