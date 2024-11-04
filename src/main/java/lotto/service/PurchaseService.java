package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.DrawNumbers;
import lotto.domain.Purchase;

public class PurchaseService {

    public Purchase purchaseLotto(int purchaseAmountNumber) {
        return new Purchase(purchaseAmountNumber);
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
        List<Integer> bonusCandidates = IntStream.rangeClosed(1, 45)
                .boxed()
                .filter(candidate -> !randomLottoNumbers.contains(candidate))
                .collect(Collectors.toList());
        Collections.shuffle(bonusCandidates);

        return bonusCandidates.getFirst();
    }
}
