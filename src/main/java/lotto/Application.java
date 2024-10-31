package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        io.Print.print(io.Print.MONEY_INPUT_MESSAGE);
        int lottoNumber = exception.Handler.getLottoNumber();

        io.Print.print(lottoNumber + io.Print.NUMBER_PRINT_MESSAGE);

        List<Lotto> lottos = lotto.Lotto.getLottos(lottoNumber);
        lotto.Lotto.printLottos(lottos);

        io.Print.print(io.Print.NUMBERS_INPUT_MESSAGE);

        io.Input lottoInput = new io.Input();
        String lottoInputNumbers = lottoInput.getInput();
        List<String> lottoArray = Stream.of(lottoInputNumbers.split(",")).toList();
        List<Integer> lottoArrayNum = lottoArray.stream().map(Integer::parseInt).toList();

        List<Integer> sortedLottoArray = lottoArrayNum.stream().sorted().toList();

        Lotto winningLotto = new Lotto(sortedLottoArray);

        io.Print.print(io.Print.BONUS_NUMBER_INPUT_MESSAGE);
        io.Input bonusNumberInput = new io.Input();
        String bonusNumber = bonusNumberInput.getInput();
        List<Integer> bonusNumberAfterParse = new ArrayList<>();
        bonusNumberAfterParse.add(Integer.parseInt(bonusNumber));
        lotto.Lotto.checkRange(bonusNumberAfterParse);
        lotto.Lotto.checkBonusNumber(winningLotto, Integer.parseInt(bonusNumber));

    }
}
