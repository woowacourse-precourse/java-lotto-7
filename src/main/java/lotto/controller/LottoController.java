package lotto.controller;

import static lotto.utils.InputValidator.validateNullOrEmpty;
import static lotto.utils.InputValidator.validateNumber;
import static lotto.utils.StringSeparator.separate;
import static lotto.view.InputView.getBonusNumberInput;
import static lotto.view.InputView.getMoneyInput;
import static lotto.view.InputView.getWinningNumberInput;
import static lotto.view.OutputView.printEarningRateOutput;
import static lotto.view.OutputView.printErrorMessageOutput;
import static lotto.view.OutputView.printIssuedLottoOutput;
import static lotto.view.OutputView.printLineSeparator;
import static lotto.view.OutputView.printLottoResultOutput;
import static lotto.view.OutputView.printPurchaseMessage;
import static lotto.view.OutputView.printStatisticMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.LottoGameResult;
import lotto.domain.LottoShop;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.utils.InputValidator;
import lotto.utils.NumberGenerator;

public class LottoController {
    private final NumberGenerator lottoNumberGenerator;

    public LottoController(NumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public void run() {
        LottoShop lottoshop = createLottoShop();
        int purchaseCount = lottoshop.calculateLottoGameCount();
        printPurchaseMessage(purchaseCount);

        List<Lotto> issuedLottos = issueLottos(purchaseCount);
        printIssuedLottos(issuedLottos);

        WinningLotto winningLotto = createWinningLotto();
        LottoGameResult lottoGameResult = new LottoGameResult();
        playLottoGame(issuedLottos, winningLotto, lottoGameResult);

        printLottogameResult(lottoGameResult, lottoshop.getMoney());
        printEarningRate(lottoGameResult, lottoshop.getMoney());
    }

    private LottoShop createLottoShop() {
       try {
           int money = getMoney();
           return new LottoShop(money);
       } catch (IllegalArgumentException e) {
           printErrorMessageOutput(e.getMessage());
           return createLottoShop();
       }
    }

    private int getMoney() {
        try {
            String moneyInput = getMoneyInput();
            validateNullOrEmpty(moneyInput);
            validateNumber(moneyInput);
            return Integer.parseInt(moneyInput);
        } catch (IllegalArgumentException e) {
            printErrorMessageOutput(e.getMessage());
            return getMoney();
        }
    }

    private List<Lotto> issueLottos(int lottoGameCount) {
        return IntStream.range(0, lottoGameCount)
                .mapToObj(i -> new Lotto(lottoNumberGenerator.generate()))
                .toList();
    }

    private void printIssuedLottos(List<Lotto> lottos) {
        lottos.stream()
                .map(Lotto::getNumbers)
                .forEach(numbers -> printIssuedLottoOutput(numbers.toString()));
    }

    private WinningLotto createWinningLotto() {
        try {
            List<Integer> winningNumbers = getWinningNumbers();
            int bonusNumber = getBonusNumber();
            return new WinningLotto(new Lotto(winningNumbers), bonusNumber);
        } catch (IllegalArgumentException e) {
            printErrorMessageOutput(e.getMessage());
            return createWinningLotto();
        }
    }

    private List<Integer> getWinningNumbers() {
        try {
            String winningNumbersInput = getWinningNumberInput();
            validateNullOrEmpty(winningNumbersInput);
            return parseWinningNumbers(winningNumbersInput);
        } catch (IllegalArgumentException e) {
            printErrorMessageOutput(e.getMessage());
            return getWinningNumbers();
        }
    }

    private List<Integer> parseWinningNumbers(String winningNumbersInput) {
        String[] winningNumbers = separate(winningNumbersInput);
        Arrays.stream(winningNumbers)
                .forEach(InputValidator::validateNumber);

        return Arrays.stream(winningNumbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private int getBonusNumber() {
        try {
            String bonusNumberInput = getBonusNumberInput();
            validateNullOrEmpty(bonusNumberInput);
            validateNumber(bonusNumberInput);
            return Integer.parseInt(bonusNumberInput);
        } catch (IllegalArgumentException e) {
            printErrorMessageOutput(e.getMessage());
            return getBonusNumber();
        }
    }

    private void playLottoGame(List<Lotto> issuedlottos, WinningLotto winningLotto, LottoGameResult lottoGameResult) {
        issuedlottos.forEach(issuedLotto -> {
            Rank rank = winningLotto.getLottoRank(issuedLotto);
            lottoGameResult.updateResult(rank);
        });
    }

    private void printLottogameResult(LottoGameResult lottoGameResult, int money) {
        printStatisticMessage();
        printLineSeparator();

        Arrays.stream(Rank.values())
                .filter(rank -> rank != Rank.NONE)
                .forEach(rank -> {
                    int count = lottoGameResult.getLottoGameResult().get(rank);
                    printLottoResultOutput(rank.getMessage(), count);
                });
    }

    private void printEarningRate(LottoGameResult lottoGameResult, int money) {
        double earningRate = lottoGameResult.calculateEarningRate(money);
        printEarningRateOutput(earningRate);
    }
}
