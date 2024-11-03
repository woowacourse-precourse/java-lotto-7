package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoGame {

    public void start() {
        try {
            int lottoCount = getValidatedLottoCount();
            System.out.println();

            List<Lotto> purchasedLottos = generateLottos(lottoCount);
            printPurchasedLottos(purchasedLottos);
            System.out.println();

            Map<PrizeRank, Integer> resultCounts = getResultCounts(purchasedLottos);
            System.out.println();
            LottoResultPrinter.printResults(resultCounts);
        } catch (IllegalArgumentException e) {
            printErrorMessage(e);
        }
    }

    private int getValidatedLottoCount() {
        int purchaseAmount = getPurchaseAmount();
        LottoValidator.validateAmount(purchaseAmount);
        return purchaseAmount / 1000;
    }

    private int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효한 숫자를 입력해 주세요.");
        }
    }

    private List<Lotto> generateLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = LottoNumberGenerator.generate();
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    private void printPurchasedLottos(List<Lotto> purchasedLottos) {
        System.out.println(purchasedLottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : purchasedLottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    private Map<PrizeRank, Integer> getResultCounts(List<Lotto> purchasedLottos) {
        List<Integer> winningNumbers = LottoInputHandler.getWinningNumbers();
        int bonusNumber = LottoInputHandler.getBonusNumber(winningNumbers);
        return LottoResultCalculator.calculateResults(purchasedLottos, winningNumbers, bonusNumber);
    }

    private void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
