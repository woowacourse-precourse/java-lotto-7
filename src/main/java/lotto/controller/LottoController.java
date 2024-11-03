package lotto.controller;

import java.util.Arrays;
import java.util.List;
import lotto.constants.WinRank;
import lotto.domain.Lotto;
import lotto.domain.WinNumber;
import lotto.factory.LottoFactory;
import lotto.service.LottoMatcher;
import lotto.service.LottoMoneyService;
import lotto.validator.BonusNumberValidator;
import lotto.validator.PurchasePriceValidator;
import lotto.validator.WinNumberValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private static final String DEFAULT_MATCH_FORMAT = "%d개 일치 (%,d원) - %d개";
    private static final String BONUS_MATCH_FORMAT = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개";
    private static final String RATIO_OF_BENEFIT_FORMAT = "총 수익률은 %.1f%%입니다.";
    private final LottoMoneyService lottoMoneyService;
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoFactory lottoFactory;

    private LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.lottoFactory = new LottoFactory();
        this.lottoMoneyService = new LottoMoneyService();
    }

    public static LottoController getInstance() {
        return LottoControllerHolder.LOTTO_CONTROLLER;
    }

    public static class LottoControllerHolder {
        private static final LottoController LOTTO_CONTROLLER = new LottoController();
    }

    /**
     * 전체적인 로직이 작동하는 곳.
     */
    public void run() {
        int validPurchasePrice = getValidInteger(validatePurchasePrice());
        List<Lotto> lottoes = lottoFactory.makeLottoes(validPurchasePrice);
        printLottoNumbers(lottoes);

        List<Integer> validWinNumbers = getValidWinNumbers(validateWinNumbers());
        int validBonusNumber = getValidInteger(validateBonusNumber(validWinNumbers));
        WinNumber winNumber = new WinNumber(validWinNumbers, validBonusNumber);

        LottoMatcher lottoMatcher = new LottoMatcher(lottoes, winNumber);
        printLottoMatchResult(lottoMatcher);
        printRatioOfBenefit(lottoMatcher, validPurchasePrice);
    }

    private void printDefaultMatchFormat(WinRank winRank, LottoMatcher lottoMatcher) {
        outputView.println(
                String.format(DEFAULT_MATCH_FORMAT, winRank.getMatchCount(), lottoMoneyService.getMoney(winRank),
                        lottoMatcher.getResult(winRank)));
    }

    private void printBonusMatchFormat(WinRank winRank, LottoMatcher lottoMatcher) {
        outputView.println(
                String.format(BONUS_MATCH_FORMAT, winRank.getMatchCount(), lottoMoneyService.getMoney(winRank),
                        lottoMatcher.getResult(winRank)));
    }

    private int getValidInteger(String validatedInteger) {
        return Integer.parseInt(validatedInteger);
    }

    // 패턴이 동일한 메서드가 두개 더 존재함. 리팩토링 필요!
    private String validateWinNumbers() {
        boolean pass = false;
        String rawWinNumber = "";
        while (!pass) {
            rawWinNumber = inputView.getRequestWinNumber();
            pass = WinNumberValidator.validate(rawWinNumber);
        }
        outputView.newLine();
        return rawWinNumber;
    }

    private List<Integer> getValidWinNumbers(String rawWinNumber) {
        return Arrays.stream(rawWinNumber.split(","))
                .map(Integer::parseInt)
                .toList();
    }

    // 패턴이 동일한 메서드가 두개 더 존재함. 리팩토링 필요!
    private String validatePurchasePrice() {
        boolean pass = false;
        String rawPurchasePrice = "";
        while (!pass) {
            rawPurchasePrice = inputView.getRequestPurchasePrice();
            pass = PurchasePriceValidator.validate(rawPurchasePrice);
        }
        outputView.newLine();
        return rawPurchasePrice;
    }

    private void printLottoNumbers(List<Lotto> lottoes) {
        outputView.println(lottoes.size() + "개를 구매했습니다.");
        lottoes.stream()
                .map(Lotto::getNumbers)
                .forEach(outputView::printList);
        outputView.newLine();
    }

    // 패턴이 동일한 메서드가 두개 더 존재함. 리팩토링 필요!
    private String validateBonusNumber(List<Integer> validWinningNumbers) {
        boolean pass = false;
        String rawBonusNumber = "";
        while (!pass) {
            rawBonusNumber = inputView.getRequestBonusNumber();
            pass = BonusNumberValidator.validate(rawBonusNumber, validWinningNumbers);
        }
        outputView.newLine();
        return rawBonusNumber;
    }

    private void printLottoMatchResult(LottoMatcher lottoMatcher) {
        lottoMatcher.matchLottoes();
        outputView.println("당첨 통계");
        outputView.println("---");
        printDefaultMatchFormat(WinRank.FIFTH, lottoMatcher);
        printDefaultMatchFormat(WinRank.FOURTH, lottoMatcher);
        printDefaultMatchFormat(WinRank.THIRD, lottoMatcher);
        printBonusMatchFormat(WinRank.SECOND, lottoMatcher);
        printDefaultMatchFormat(WinRank.FIRST, lottoMatcher);
    }

    private void printRatioOfBenefit(LottoMatcher lottoMatcher, int validPurchasePrice) {
        outputView.println(String.format(RATIO_OF_BENEFIT_FORMAT,
                lottoMoneyService.getRatioOfBenefit(lottoMatcher, validPurchasePrice)));
    }
}
