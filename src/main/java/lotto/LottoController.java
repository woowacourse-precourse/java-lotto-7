package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Collectors;

public class LottoController {
    private final LottoView view;
    private final LottoGame game;
    public LottoController(LottoView view, LottoGame game){
        this.view = view;
        this.game = game;
    }

    public void start() {
        try {
            int purchaseAmount = view.inputPurchaseAmount();


            if (purchaseAmount < 1000) {
                throw new IllegalArgumentException("[ERROR] 최소 1000원 이상 구매해야 합니다.");
            }


            int numberOfLottos = purchaseAmount / 1000;
            List<Lotto> purchasedLottos = game.generateLottos(numberOfLottos);
            view.displayPurchasedLottos(purchasedLottos);

            List<Integer> winningNumbers = view.inputWinningNumbers();
            int bonusNumber = view.inputBonusNumber();


            validateWinningNumbers(winningNumbers, bonusNumber);

            LottoResult result = game.calculateResults(purchasedLottos, winningNumbers, bonusNumber);
            view.displayResult(result, purchaseAmount);
        } catch (IllegalArgumentException e) {
            view.displayError("[ERROR]"+ e.getMessage());
        }
    }
    private void validateWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호에 포함될 수 없습니다.");
        }

        if (winningNumbers.stream().anyMatch(num -> num < 1 || num > 45)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1에서 45 사이여야 합니다.");
        }
        if (winningNumbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다.");
        }

        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1에서 45 사이여야 합니다.");
        }
    }

}
