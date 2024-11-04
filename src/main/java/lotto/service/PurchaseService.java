package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.DrawNumbers;
import lotto.domain.Purchase;
import lotto.view.InputView;

public class PurchaseService {

    public Purchase purchaseLotto(int purchaseAmountNumber) {
        Purchase purchase = null;
        while (purchase == null) {
            try {
                purchase = new Purchase(purchaseAmountNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                purchaseAmountNumber = InputView.getPurchaseAmount();
            }
        }
        return purchase;
    }

    public List<DrawNumbers> getRandomDrawNumbersByTicketCount(int ticketCount) {
        List<DrawNumbers> drawSets = new ArrayList<>();

        for (int i = 0; i < ticketCount; i++) {
            List<Integer> randomLottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            int randomBonusNumber = getRandomBonusNumber(randomLottoNumbers);
            drawSets.add(new DrawNumbers(randomLottoNumbers, randomBonusNumber));
        }
        return drawSets;
    }

    private static int getRandomBonusNumber(List<Integer> randomLottoNumbers) {
        int randomBonusNumber = getFirstRandomFromOneToFortyFive();

        while (randomLottoNumbers.contains(randomBonusNumber)) {
            randomBonusNumber = getFirstRandomFromOneToFortyFive();
        }
        return randomBonusNumber;
    }

    private static int getFirstRandomFromOneToFortyFive() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 1).getFirst();
    }
}
