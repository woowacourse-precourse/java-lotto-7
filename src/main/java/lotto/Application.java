package lotto;

import java.util.List;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        io.Print printMessage = new io.Print(io.Print.MONEY_INPUT_MESSAGE);
        printMessage.print();
        int lottoNumber = exception.Handler.getLottoNumber();

        printMessage = new io.Print(lottoNumber + io.Print.NUMBER_PRINT_MESSAGE);
        printMessage.print();

        List<Lotto> lottos = lotto.Lotto.getLottos(lottoNumber);
        lotto.Lotto.printLottos(lottos);

        printMessage = new io.Print(io.Print.NUMBERS_INPUT_MESSAGE);
        printMessage.print();

        io.Input lottoInput = new io.Input();
        String lottoInputNumbers = lottoInput.getInput();
        List<String> lottoArray = Stream.of(lottoInputNumbers.split(",")).toList();
        List<Integer> lottoArrayNum = lottoArray.stream().map(Integer::parseInt).toList();

        List<Integer> sortedLottoArray = lottoArrayNum.stream().sorted().toList();

        Lotto winningLotto = new Lotto(sortedLottoArray);
    }
}
