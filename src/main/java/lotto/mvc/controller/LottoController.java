package lotto.mvc.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.mvc.model.Lotto;
import lotto.mvc.model.LottoWinningAmount;
import lotto.mvc.validation.LottoBonusNumberValidator;
import lotto.mvc.validation.LottoNumberValidator;
import lotto.mvc.validation.PurchaseAmountValidator;
import lotto.mvc.view.InputView;
import lotto.mvc.view.OutputView;

public class LottoController {
    private InputView inputView;
    private OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        inputView.showPurchaseAmountMsg();

        String purchaseAmount = inputView.getUserInput();
        purchaseAmount = trimInput(purchaseAmount);
        purchaseAmount = removeDelimiter(purchaseAmount);

        PurchaseAmountValidator.isValid(purchaseAmount);

        int count = extractLottoCount(purchaseAmount);

        List<Lotto> lottos = makeLottos(count);

        outputView.showNumberOfLottoPurchases(count);
        outputView.showLottoDetails(lottos);

        inputView.showLottoWinningNumberMsg();
        String winningNumber = inputView.getUserInput();
        winningNumber = trimInput(winningNumber);

        Lotto winningLotto = new Lotto(extractLottoNumber(winningNumber));

        inputView.showLottoBonusNumberMsg();
        String bonusNumber = inputView.getUserInput();
        bonusNumber = trimInput(bonusNumber);

        LottoBonusNumberValidator.isValid(winningLotto, bonusNumber);

        int bonus = Integer.parseInt(bonusNumber);

        Map<LottoWinningAmount, Integer> winningCounts = checkLottoWinning(lottos, winningLotto, bonus);

        outputView.showWinningStatisticsMsg();
        outputView.showWinningStatistics(winningCounts);

        BigInteger totalWinningAmount = calculateWinningAmount(winningCounts);

        BigDecimal totalReturn = calculateTotalReturn(totalWinningAmount, purchaseAmount);
    }

    private Map<LottoWinningAmount, Integer> checkLottoWinning(List<Lotto> lottos, Lotto winningLotto, int bonus) {
        Map<LottoWinningAmount, Integer> results = new HashMap<>();

        for (int i = 0; i < lottos.size(); i++) {
            int matchCount = 0;
            boolean matchBonus = false;

            Lotto lotto = lottos.get(i);
            List<Integer> lottoNumbers = lotto.getNumbers();

            for (int j = 0; j < lottoNumbers.size(); j++) {
                if (winningLotto.getNumbers().contains(lottoNumbers.get(j))) {
                    matchCount++;
                }
            }

            if (lottoNumbers.contains(bonus)) {
                matchBonus = true;
            }

            LottoWinningAmount[] winningAmounts = LottoWinningAmount.values();

            //로직 확인 필요
            for (int j = 0; j < winningAmounts.length; j++) {
                if (matchCount == winningAmounts[j].getCount() && matchBonus == winningAmounts[j].isBonus()) {
                    results.put(winningAmounts[j], results.getOrDefault(winningAmounts[j], 0) + 1);
                }
            }
        }

        return results;
    }

    private String trimInput(String input) {
        return input.trim();
    }

    private String removeDelimiter(String input) {
        //정규표현식으로 할 수 있을까
        StringBuilder output = new StringBuilder();

        for (String s : input.split(",", -1)) {
            output.append(s);
        }

        return output.toString();
    }

    private int extractLottoCount(String input) {
        Long count = Long.parseLong(input) / 1000;
        return count.intValue();
    }

    private List<Lotto> makeLottos(int count) {
        List<Lotto> lottos = new ArrayList<>(count);

        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottos.add(lotto);
        }

        return lottos;
    }

    private List<Integer> extractLottoNumber(String winningNumber) {
        List<Integer> numbers = new ArrayList<>();

        LottoNumberValidator.isValid(winningNumber);

        for (String number : winningNumber.split(",")) {
            number = number.trim();
            numbers.add(Integer.parseInt(number));
        }

        return numbers;
    }

    private BigInteger calculateWinningAmount(Map<LottoWinningAmount, Integer> winningCounts) {
        BigInteger winningAmount = BigInteger.ZERO;
        LottoWinningAmount[] winningAmounts = LottoWinningAmount.values();

        for (LottoWinningAmount winning : winningAmounts) {
            BigInteger multiplied = BigInteger.valueOf(winningCounts.getOrDefault(winning, 0))
                    .multiply(BigInteger.valueOf(winning.getAmount()));
            winningAmount.add(multiplied);
        }

        return winningAmount;
    }

    private BigDecimal calculateTotalReturn(BigInteger totalWinningAmount, String purchaseAmount) {
        BigDecimal purchase = new BigDecimal(purchaseAmount);
        BigDecimal totalWinning = new BigDecimal(totalWinningAmount);

        return totalWinning.divide(purchase, 3, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100));
    }
}
