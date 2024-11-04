package lotto;

import java.util.List;
import lotto.io.Input;
import lotto.io.Output;

public class Application {
    public static void main(String[] args) {

        Input input = new Input();
        Output output = new Output();
        int money = input.inputMoney();

        LottoConverter lottoConverter = new LottoConverter(1000);
        List<Lotto> lottos = lottoConverter.convertLotto(money);
        output.outputLottos(lottos);

        List<Integer> numbers = input.inputWinningNumber();
        LottoFactory lottoFactory = new LottoFactory();
        Lotto winningLotto = lottoFactory.createLottoByNumbers(numbers);

        int bonusNumber = input.inputBonusNumber();
        LottoMachineFactory lottoMachineFactory = new LottoMachineFactory();
        LottoMachine lottoMachine = lottoMachineFactory.createLottoMachine(winningLotto, bonusNumber);

        List<WinningType> winningTypes = lottoMachine.checkWinnings(lottos);
        output.outputWinningResult(winningTypes);

    }
}
