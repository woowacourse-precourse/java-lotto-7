package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LottoService lottoService = new LottoService();

//    1 사용자에게 로또 구입 금액을 입력받기.
//    2 입력받은 금액으로 로또 티켓 생성.
//    3 로또 티켓을 출력하기.
//    4 당첨 번호와 보너스 번호 입력받기.
//    5 사용자가 구매한 로또와 당첨 번호를 비교하여 당첨 통계 계산.
//    6 당첨 결과와 수익률 출력.

    public void run() {
        int purchaseAmount = getPurchaseAmount();
        List<Lotto> lottos = createLottos(purchaseAmount);
        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber(winningNumbers);

        Map<LottoRank, Integer> winningStats = lottoService.calculateWinningStats(lottos, winningNumbers, bonusNumber);
        double yield = lottoService.calculateYield(winningStats, purchaseAmount);

        printResults(lottos, winningStats, yield);
    }

    private int getPurchaseAmount() {
        while (true) {
            try {
                String inputPurchaseAmount = inputView.inputPurchaseAmount();
                return Integer.parseInt(inputPurchaseAmount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Lotto> createLottos(int purchaseAmount) {
        List<Lotto> lottos = lottoService.createLottos(purchaseAmount);
        outputView.printLottos(lottos);
        return lottos;
    }

    private List<Integer> getWinningNumbers() {
        while (true) {
            try {
                return inputView.inputLottoNumber();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                String inputBonusNuber = inputView.inputBonusNumber();
                int bonusNumber = Integer.parseInt(inputBonusNuber);
                if (winningNumbers.contains(bonusNumber)) {
                    throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
                }
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void printResults(List<Lotto> lottos, Map<LottoRank, Integer> winningStats, double yield) {
        outputView.printWinningStats(winningStats);
        outputView.printYield(yield);
    }

}
