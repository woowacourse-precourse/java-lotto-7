package lotto;


import lotto.io.Input;
import lotto.io.View;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Application {
    private final Integer price;
    private final LottoGenerator lottoGenerator;
    private final LottoResult lottoResult;
    private final WinningChecker winningChecker;

    public Application() {
        Lotto winningNumber = new Lotto(toLotto(Input.inputWinningNumber()));
        Integer bonusNumber = Integer.parseInt(Input.inputBonusNumber());

        this.price = Integer.parseInt(Input.inputPrice());
        this.lottoGenerator = new LottoGenerator();
        this.lottoResult = new LottoResult();
        this.winningChecker = new WinningChecker(winningNumber, bonusNumber, lottoResult);
    }

    public static void main(String[] args) {
        Application lottoMachine = new Application();

        LottoGenerator lottoGenerator = lottoMachine.getLottoGenerator();
        LottoResult lottoResult = lottoMachine.getLottoResult();

        Lottos lottos = lottoGenerator.generateLottos(lottoMachine.getPrice());

        WinningChecker winningChecker = lottoMachine.getWinningChecker();
        winningChecker.calculate(lottos);

        printIssuedLottos(lottos);
        printResult(lottos, lottoResult);
    }

    private static void printIssuedLottos(Lottos lottos) {
        View.printLotto(lottos.getLottoCount(), lottos.toString());
    }

    private static void printResult(Lottos lottos, LottoResult lottoResult) {
        View.printWinningResult(lottoResult.toString());
        View.printProfit(lottoResult.getProfitRate(lottos));
    }

    private Integer getPrice() {
        return price;
    }

    private LottoResult getLottoResult() {
        return lottoResult;
    }

    private LottoGenerator getLottoGenerator() {
        return lottoGenerator;
    }

    private WinningChecker getWinningChecker() {
        return winningChecker;
    }

    private List<Integer> toLotto(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
