package lotto;


import lotto.io.Input;
import lotto.io.View;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Application {
    private final Integer price;
    private final Lotto winningNumber;
    private final Integer bonusNumber;

    public Application() {
        this.price = Integer.parseInt(Input.inputPrice());
        this.winningNumber = new Lotto(toLotto(Input.inputWinningNumber()));
        this.bonusNumber = Integer.parseInt(Input.inputBonusNumber());
    }

    public static void main(String[] args) {
        Application app = new Application();

        LottoGenerator lottoGenerator = new LottoGenerator();
        Lottos lottos = lottoGenerator.generateLottos(app.getPrice());

        LottoResult lottoResult = new LottoResult();
        WinningChecker winningChecker = new WinningChecker(app.getWinningNumber(), app.getBonusNumber(), lottoResult);
        winningChecker.calculate(lottos);
        lottoResult.calculateTotalBenefit();

        printResults(lottos, lottoResult);
    }

    private static void printResults(Lottos lottos, LottoResult lottoResult) {
        View.printLotto(lottos.getLottoCount(), lottos.toString());
        View.printWinningResult(lottoResult.toString());
        View.printProfit(lottoResult.getProfitRate(lottos));
    }

    private Integer getPrice() {
        return price;
    }

    private Lotto getWinningNumber() {
        return winningNumber;
    }

    private Integer getBonusNumber() {
        return bonusNumber;
    }

    private List<Integer> toLotto(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
