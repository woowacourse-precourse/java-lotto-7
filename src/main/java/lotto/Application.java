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

    }
}
