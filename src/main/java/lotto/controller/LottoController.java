package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.enums.WinningType;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private static final String INPUT_NUMBER_ERROR_MESSAGE = "[ERROR] 구입 금액은 숫자여야 합니다.";
    private static final String PURCHASE_AMOUNT_ERROR_MESSAGE = "[ERROR] 구입 금액은 %d원 단위여야 합니다.";
    private static final String WINNING_TYPE_STRING_FORMAT = "%d개 일치 (%,d원) - %d개";
    private static final String WINNING_TYPE_BONUS_BALL_STRING_FORMAT = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개";
    private static final Integer LOTTO_PURCHASE_COST = 1000;

    public void run() {
        Integer lottoCount = buyLotto();

        List<Lotto> createLottos = createLotto(lottoCount);

        printLottos(createLottos, lottoCount);

        List<Integer> winningNumbers = inputWinningNumbers();
        Integer bonusNumber = inputBonusNumber();

        Lottos lottos = new Lottos(createLottos, winningNumbers, bonusNumber);

        Map<WinningType, Integer> winningResult = lottos.getWinningResult();

        printResult(winningResult);

        printReturnRate(lottos, lottoCount * LOTTO_PURCHASE_COST);

    }

    private void printReturnRate(Lottos lottos, Integer lottoCount){
        double returnPrice = getReturnRate(lottos, lottoCount);
        OutputView.getInstance().printTotalReturnRate(returnPrice);
    }


    private void printLottos(List<Lotto> createLottos, Integer lottoCount) {
        String lottosString = getLottosString(createLottos);

        OutputView.getInstance().printLottos(lottoCount, lottosString);
    }

    private void printResult(Map<WinningType, Integer> winningResult){
        String resultString = toResultString(winningResult);
        OutputView.getInstance().printWinningResult(resultString);
    }

    private String toResultString(Map<WinningType, Integer> winningResult){
        StringBuilder stringBuilder = new StringBuilder();
        for (WinningType key : WinningType.values()) {
            stringBuilder.append(generateWinningTypeString(key, winningResult.get(key)));
        }

        return stringBuilder.toString();
    }

    private String generateWinningTypeString(WinningType winningType, Integer count){
        if(winningType.equals(WinningType.NOTHING)){
            return "";
        }
        if(winningType.equals(WinningType.FIVE_BONUS)){
            return String.format(WINNING_TYPE_BONUS_BALL_STRING_FORMAT, winningType.getMatchCount(), winningType.getPrize(), count) + "\n";
        }
        return String.format(WINNING_TYPE_STRING_FORMAT, winningType.getMatchCount(), winningType.getPrize(), count) + "\n";
    }

    private String getLottosString(List<Lotto> lottos) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Lotto lotto : lottos) {
            stringBuilder.append(lotto.toPrintList()).append("\n");
        }

        return stringBuilder.toString();
    }

    private List<Lotto> createLotto(Integer lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(Lotto.LOTTO_MIN_NUMBER,
                    Lotto.LOTTO_MAX_NUMBER, Lotto.LOTTO_NUMBER_COUNT);

            Collections.sort(lottoNumbers);

            Lotto lotto = new Lotto(lottoNumbers);
            lottos.add(lotto);
        }
        return lottos;
    }

    private List<Integer> inputWinningNumbers() {
        List<Integer> winningNumbers = new ArrayList<>();

        OutputView.getInstance().printWinningNumberInput();
        String input = InputView.getInstance().readUserInput();

        for (String splitString : input.split(",")) {
            winningNumbers.add(toInt(splitString));
        }

        return winningNumbers;
    }

    private Integer inputBonusNumber() {
        OutputView.getInstance().printBonusNumberInput();
        return toInt(InputView.getInstance().readUserInput());
    }


    private Integer buyLotto() {
        Integer totalCost = getUserPurchaseCost();
        return getLottoAmount(totalCost);
    }

    private Integer getLottoAmount(Integer cost) {
        if (cost % LOTTO_PURCHASE_COST != 0) {
            throw new IllegalArgumentException(String.format(PURCHASE_AMOUNT_ERROR_MESSAGE, LOTTO_PURCHASE_COST));
        }

        return cost / LOTTO_PURCHASE_COST;
    }

    private Integer getUserPurchaseCost() {
        OutputView.getInstance().printPurchaseInput();
        return toInt(InputView.getInstance().readUserInput());
    }

    private Integer toInt(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_NUMBER_ERROR_MESSAGE);
        }
    }

    private double getReturnRate(Lottos lottos, Integer lottoCount){
        Long totalPrize = lottos.getTotalPrize();
        return ((double)totalPrize - lottoCount) / lottoCount * 100 ;
    }
}
