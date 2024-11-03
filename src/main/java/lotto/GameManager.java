package lotto;

import static lotto.global.util.Validator.validateBonusNumber;
import static lotto.global.util.Validator.validatePrice;
import static lotto.global.util.Validator.validateWinningNumber;
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
        List<Integer> winningNumber = readWinningNumber();
        int bonusNumber = readBonusNumber(winningNumber);
        return new LottoWinningSet(winningNumber, bonusNumber);
    }

    private List<Integer> readWinningNumber() {
        printWinningNumberInputMessage();
        List<String> input = Arrays.asList(inputView.readWinningNumber());
        try {
            validateWinningNumber(input);
        } catch (IllegalArgumentException exception) {
            outputView.println(exception.getMessage());
            return readWinningNumber();
        }
        return input.stream()
                .map(Integer::parseInt)
                .toList();
    }

    private int readBonusNumber(List<Integer> winningNumber) {
        printBonusNumberInputMessage();
        String input = inputView.readBonusNumber();
        try {
            validateBonusNumber(winningNumber, input);
        } catch (IllegalArgumentException exception) {
            outputView.println(exception.getMessage());
            return readBonusNumber(winningNumber);
        }
        return Integer.parseInt(input);
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

