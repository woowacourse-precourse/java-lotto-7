package lotto.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Splitter.CustomSplitter;
import lotto.domain.generator.RandomIntegerListGenerator;
import lotto.domain.lotto.Investment;
import lotto.domain.lotto.LottoBundle;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoResult;
import lotto.domain.lotto.Rank;
import lotto.domain.lotto.WinningNumbers;
import lotto.domain.sorting.AscendingSorter;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final CustomSplitter splitter;

    public LottoController(InputView inputView, OutputView outputView, CustomSplitter splitter) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.splitter = splitter;

    }


    public void run() {

        outputView.printPurchaseGuide();

        int cost = Integer.parseInt(inputView.readLine());

        outputView.printNewLine();

        Investment investment = new Investment(BigInteger.valueOf(cost));

        int lottoQuantity = investment.getQuantity();

        outputView.printPurchasedAmount(lottoQuantity);

        LottoBundle lottoBundle = new LottoBundle(new ArrayList<>(), new RandomIntegerListGenerator(),
                new AscendingSorter());

        lottoBundle.generate(lottoQuantity);

        outputView.printLottoTicket(lottoBundle.getLottoBundle());

        outputView.printWinningNumbersGuide();

        String input = inputView.readLine();
        outputView.printNewLine();
        String[] splitInput = splitter.splitFrom(input);
        List<LottoNumber> preWinningNumbers = new ArrayList<>();
        for (String splitNumber : splitInput) {
            preWinningNumbers.add(new LottoNumber(Integer.parseInt(splitNumber)));
        }

        outputView.printBonusNumberGuide();
        LottoNumber bonusNumber = new LottoNumber(Integer.parseInt(inputView.readLine()));
        outputView.printNewLine();
        WinningNumbers winningNumbers = new WinningNumbers(preWinningNumbers, bonusNumber);

        outputView.printWinningStatistics();
        LottoResult lottoResult = new LottoResult(new EnumMap<>(Rank.class), BigInteger.ZERO);

        lottoResult.calculate(lottoBundle, winningNumbers);
        Map<Rank, Integer> rankCount = lottoResult.getRankCount();
        outputView.printWinningResult(rankCount);

        outputView.printProfitRate(lottoResult.calculateReturnRate(investment));
    }
}
