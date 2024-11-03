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
        List<Lotto> lottos = buyLotto(price);
        printLottoPurchaseSize(lottos.size());
        printLottoState(lottos);
        LottoWinningSet lottoWinningSet = readWinningLottoSet();
        Map<Prize, Integer> lottoScore = calculateLottoScore(lottos, lottoWinningSet);
        printLottoScore(lottoScore);
        printRateOfReturn(lottoScore, price);
    }

    private void printRateOfReturn(Map<Prize, Integer> lottoScore, int price) {
        YieldCalculator yieldCalculator = new YieldCalculator();
        int prizeMoney = yieldCalculator.calculatePrizeMoney(lottoScore);
        printRateOfReturn(yieldCalculator.calculateRateOfReturn(price, prizeMoney));
    }

    private void printWinningStatisticMessage() {
        outputView.printWinningStatisticMessage();
    }

    private Map<Prize, Integer> calculateLottoScore(List<Lotto> lottos, LottoWinningSet lottoWinningSet) {
        LottoJudge lottoJudge = new LottoJudge();
        return lottoJudge.calculateLottoScore(lottos, lottoWinningSet);
    }

    private void printLottoState(List<Lotto> lottos) {
        outputView.printLottos(lottos);
    }

    private List<Lotto> buyLotto(int price) {
        LottoShop lottoShop = new LottoShop();
        LottoGenerator lottoGenerator = new RandomLottoGenerator();
        return lottoShop.buyLotto(price, lottoGenerator);
    }

    private void printRateOfReturn(String returnRate) {
        outputView.printReturnRate(returnRate);
    }

    private void printLottoScore(Map<Prize, Integer> lottoScore) {
        printWinningStatisticMessage();
        String lottoScoreToString = Arrays.stream(Prize.values())
                .filter(prize -> prize != NO_PRIZE)
                .map(prize -> prize.formatScoreDetails(lottoScore.get(prize)))
                .collect(Collectors.joining("\n"));
        outputView.println(lottoScoreToString);
    }

    private int readPrice() {
        int price;
        while (true) {
            outputView.printPurchaseInputMessage();
            String input = inputView.readPrice();
            try {
                validatePrice(input);
                price = Integer.parseInt(input);
                break;
            } catch (IllegalArgumentException exception) {
                outputView.println(exception.getMessage());
            }
        }
        return price;
    }

    private LottoWinningSet readWinningLottoSet() {
        List<Integer> winningNumber = readWinningNumber();
        int bonusNumber = readBonusNumber(winningNumber);
        return new LottoWinningSet(winningNumber, bonusNumber);
    }

    private List<Integer> readWinningNumber() {
        while (true) {
            printWinningNumberInputMessage();
            List<String> input = Arrays.asList(inputView.readWinningNumber());

            try {
                validateWinningNumber(input);
                return input.stream()
                        .map(Integer::parseInt)
                        .toList();
            } catch (IllegalArgumentException exception) {
                outputView.println(exception.getMessage());
            }
        }
    }

    private int readBonusNumber(List<Integer> winningNumber) {
        while (true) {
            printBonusNumberInputMessage();
            String input = inputView.readBonusNumber();

            try {
                validateBonusNumber(winningNumber, input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException exception) {
                outputView.println(exception.getMessage());
            }
        }
    }

    private void printLottoPurchaseSize(Integer lottoSize) {
        outputView.printLottoPurchase(lottoSize.toString());
    }

    private void printWinningNumberInputMessage() {
        outputView.printWinningNumberInputMessage();
    }

    private void printBonusNumberInputMessage() {
        outputView.printBonusNumberInputMessage();
    }
}

