package lotto;

import static lotto.global.util.Validator.validatePrice;
import static lotto.score.Prize.NO_PRIZE;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.io.InputView;
import lotto.io.OutputView;
import lotto.score.Prize;

public class GameManager {
    private final InputView inputView;
    private final OutputView outputView;

    public GameManager() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void start() {
        int price = readPrice();
        LottoShop lottoShop = new LottoShop();
        LottoJudge lottoJudge = new LottoJudge();
        RandomLottoGenerator randomLottoGenerator = new RandomLottoGenerator();
        YieldCalculator yieldCalculator = new YieldCalculator();
        List<Lotto> lottos = lottoShop.buyLotto(price, randomLottoGenerator);
        printLottoPurchase(lottos.size());
        outputView.printLottos(lottos);
        LottoWinningSet lottoWinningSet = readWinningLottoSet();
        Map<Prize, Integer> lottoScore = lottoJudge.calculateLottoScore(lottos, lottoWinningSet);
        outputView.printWinningStatisticMessage();
        printLottoScore(lottoScore);
        int prizeMoney = yieldCalculator.calculatePrizeMoney(lottoScore);
        printReturnRate(yieldCalculator.calculateRateOfReturn(price, prizeMoney));
    }

    private void printReturnRate(String returnRate) {
        outputView.printReturnRate(returnRate);
    }

    private void printLottoScore(Map<Prize, Integer> lottoScore) {
        String lottoScoreToString = Arrays.stream(Prize.values())
                .filter(prize -> prize != NO_PRIZE)
                .map(prize -> prize.formatScoreDetails(lottoScore.get(prize)))
                .collect(Collectors.joining("\n"));
        System.out.println(lottoScoreToString);
    }

    private int readPrice() {
        outputView.printPurchaseInputMessage();
        String input = inputView.readPrice();

        try {
            validatePrice(input);
        } catch (IllegalArgumentException exception) {
            outputView.println(exception.getMessage());
            return readPrice();
        }

        return Integer.parseInt(input);
    }

    private LottoWinningSet readWinningLottoSet() {
        printWinningNumberInputMessage();
        List<Integer> winningNumber = readWinningNumber();
        printBonusNumberInputMessage();
        int bonusNumber = readBonusNumber();
        return new LottoWinningSet(winningNumber, bonusNumber);
    }

    private List<Integer> readWinningNumber() {
        return Arrays.stream(inputView.readWinningNumber())
                .map(Integer::parseInt)
                .toList();
    }

    private int readBonusNumber() {
        return Integer.parseInt(inputView.readBonusNumber());
    }

    private void printLottoPurchase(Integer lottoSize) {
        outputView.printLottoPurchase(lottoSize.toString());
    }

    private void printWinningNumberInputMessage() {
        outputView.printWinningNumberInputMessage();
    }

    private void printBonusNumberInputMessage() {
        outputView.printBonusNumberInputMessage();
    }
}

