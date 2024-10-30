package lotto;

import java.util.List;
import constants.Constants;

public class Application {
    public static void main(String[] args) {
        LottoInput lottoInput = new LottoInput();
        int amount = lottoInput.purchaseInput();

        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Lotto> lottos = lottoGenerator.generateLottos(amount);

        int count = amount / Constants.LOTTO_PRICE;

        LottoOutput lottoOutput = new LottoOutput();
        lottoOutput.printLottos(lottos, count);

        Lotto winningLotto = lottoInput.mainNumbersInput();
    }
}