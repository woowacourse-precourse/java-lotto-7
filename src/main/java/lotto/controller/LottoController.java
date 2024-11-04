package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.model.LottoBudget;
import lotto.model.LottoPrizes;
import lotto.model.Lottos;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        String lottoBudgetInput = inputView.readLottoBudget();
        LottoBudget lottoBudget = new LottoBudget(lottoBudgetInput);

        String lottoCount = lottoBudget.getLottoCount();
        outputView.printLottoCount(lottoCount);

        int lottoCountNumber = Integer.parseInt(lottoCount);
        Lottos lottos = Lottos.fromCount(lottoCountNumber);

        List<String> lottoNumbers = lottos.getLottoNumbers();
        outputView.printLottoNumbers(lottoNumbers);

        System.out.println("당첨 번호를 입력해 주세요.");
        String WinningNumbersInput = Console.readLine();
        String[] WinningNumberStrings = WinningNumbersInput.split(",");
        List<Integer> winningNumbers = Arrays.stream(WinningNumberStrings)
                .map(Integer::parseInt)
                .toList();

        System.out.println("보너스 번호를 입력해 주세요.");
        String BonusNumberInput = Console.readLine();
        int bonusNumber = Integer.parseInt(BonusNumberInput);

        LottoPrizes lottoPrizes = lottos.getPrizes(winningNumbers, bonusNumber);

        String yield = lottoPrizes.calculateYield(lottoBudget.getValue());
        System.out.println("당첨 통계" + System.lineSeparator() + "---");

        List<String> matchStatistics = lottoPrizes.calculateMatchStatistics();
        matchStatistics.forEach(System.out::println);

        System.out.println("총 수익률은 " + yield + "%입니다.");
    }

}
