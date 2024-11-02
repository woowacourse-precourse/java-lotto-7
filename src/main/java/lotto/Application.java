package lotto;


import lotto.io.Input;
import lotto.io.View;

import java.util.Arrays;
import java.util.stream.Collectors;


public class Application {
    public static void main(String[] args) {
        Integer price = Integer.parseInt(Input.inputPrice());
        Lotto winningNumber = new Lotto(Arrays.stream(Input.inputWinningNumber().split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
        Integer bonusNumber = Integer.parseInt(Input.inputBonusNumber());

        LottoGenerator lottoGenerator = new LottoGenerator();
        Lottos lottos = new Lottos(lottoGenerator.generateLottos(price));

        LottoResult lottoResult = new LottoResult();
        WinningChecker winningChecker = new WinningChecker(winningNumber, bonusNumber, lottoResult);
        winningChecker.calculate(lottos);
        lottoResult.calculateTotalBenefit();

        printResults(lottos, lottoResult);
    }

    private static void printResults(Lottos lottos,LottoResult lottoResult) {
        View view = new View();
        view.printLotto(lottos.getLottoCount(), lottos.toString());
        view.printWinningResult(lottoResult.toString());
        view.printProfit(lottoResult.getProfitRate(lottos));
    }
}
