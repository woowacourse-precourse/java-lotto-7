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

        Lotto mainLotto = lottoInput.mainNumbersInput();
        int bonusNumber = lottoInput.bonusNumberInput(mainLotto.getNumbers());

        LottoResult lottoResult = new LottoResult();
        lottoResult.calculateResult(lottos, mainLotto, bonusNumber);

        double profitRate = lottoResult.calculateProfitRate(amount);
        lottoOutput.printResult(lottoResult, profitRate);
    }
}