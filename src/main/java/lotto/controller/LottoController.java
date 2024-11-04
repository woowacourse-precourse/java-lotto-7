package lotto.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.domain.dto.LottoResult;
import lotto.service.CalculateService;
import lotto.service.LottoDrawService;
import lotto.service.LottoService;
import lotto.service.parser.AmountParser;
import lotto.service.parser.WinningNumberParser;
import lotto.validation.AmountValidator;
import lotto.validation.BonusNumberValidator;
import lotto.validation.WinningNumberValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private static final int FIVE_WITH_BONUS = 7;
    private static final List<Integer> KEYS_TO_EXCLUDE = List.of(1,2);
    private static final List<Integer> OUTPUT_ORDER = List.of(3, 4, 5, 7, 6);
    private final LottoService lottoService;
    private final LottoDrawService lottoDrawService;
    private final CalculateService calculateService;

    public LottoController(LottoService lottoService, LottoDrawService lottoDrawService, CalculateService calculateService) {
        this.lottoService = lottoService;
        this.lottoDrawService = lottoDrawService;
        this.calculateService = calculateService;
    }

    public void run() {

        int amount = getValidAmount();

        List<Lotto> lottos = lottoService.getLottos(amount);
        OutputView.purcharsedCount(lottos.size());
        OutputView.purchasedLottos(lottos);

        List<Integer> winningNumbers = getValidWinningNumbers();

        int bonusNumber = getValidBonusNumber(winningNumbers);

        WinningLotto winningLotto = new WinningLotto(winningNumbers,bonusNumber);

        Map<LottoResult,Integer> drawResult = new HashMap<>();

        for (Lotto lotto: lottos){
            LottoResult lottoResult = lottoDrawService.drawLotto(lotto, winningLotto);
            resultStore(drawResult, lottoResult);
        }

        OutputView.startDrawResult();
        BigDecimal ratio = calculateService.calculateRatio(amount, drawResult);


        Map<Integer, Integer> resultMap = new HashMap<>();
        settingMap(resultMap);

        for (LottoResult lottoResult: drawResult.keySet()){
            fiveAndResultMapper(lottoResult, resultMap);
        }

        for (Integer key : OUTPUT_ORDER) {
            if (!KEYS_TO_EXCLUDE.contains(key) && resultMap.containsKey(key)) {
                OutputView.drawResult(key, resultMap.get(key));
            }
        }

        OutputView.earnRatio(ratio);
    }

    private int getValidAmount() {
        while (true) {
            try {
                String amountInput = InputView.readAmount();
                AmountValidator.validateOnlyNumeric(amountInput);
                return AmountParser.parseAmount(amountInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // 에러 메시지 출력
            }
        }
    }

    private List<Integer> getValidWinningNumbers() {
        while (true) {
            try {
                String winningNumberInput = InputView.readWinningNumber();
                WinningNumberValidator.validateWinningNumberInputAll(winningNumberInput);
                List<Integer> winningNumbers = WinningNumberParser.parseWinningNumber(winningNumberInput);
                WinningNumberValidator.validateWinningNumbersCount(winningNumbers);
                return winningNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // 에러 메시지 출력
            }
        }
    }

    private int getValidBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                String bonusNumberInput = InputView.readBonusNumber();
                BonusNumberValidator.validateOnlyNumeric(bonusNumberInput);
                int bonusNumber = WinningNumberParser.parseBonusNumber(bonusNumberInput);
                BonusNumberValidator.validateBonusNumberDuplicate(winningNumbers, bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // 에러 메시지 출력
            }
        }
    }

    private static void settingMap(Map<Integer, Integer> resultMap) {
        for (int i = 0; i <= 7; i++) {
            resultMap.put(i, 0);
        }
    }

    private static void fiveAndResultMapper(LottoResult lottoResult, Map<Integer, Integer> resultMap) {
        if (lottoResult.getMatchingNumberCount() == 5 && lottoResult.isBonusMatch()){
            resultMap.put(FIVE_WITH_BONUS, resultMap.get(FIVE_WITH_BONUS)+1);
            return;
        }

        int count = lottoResult.getMatchingNumberCount();
        if (lottoResult.isBonusMatch()){
            resultMap.put(count+1, resultMap.get(count+1)+1);
            return;
        }
        resultMap.put(count, resultMap.get(count)+1);
    }

    private static void resultStore(Map<LottoResult, Integer> drawResult, LottoResult lottoResult) {
        if (drawResult.get(lottoResult) == null){
            drawResult.put(lottoResult,1);
            return;
        }
        drawResult.put(lottoResult, drawResult.get(lottoResult)+1);
    }
}
