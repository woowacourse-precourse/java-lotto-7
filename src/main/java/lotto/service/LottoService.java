package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;

public class LottoService {
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int MIN_LOTTO_NUMBER = 1;
    public int calculateLottoTickets(PurchaseAmount purchaseAmount) {
        return purchaseAmount.getMoney() / 1000;
    }

    public List<Lotto> generateTotalLottoNumbers(int ticketCount) {
        List<Lotto> totalLottoNumbers = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            Lotto newLotto = generateLottoNumbers();
            totalLottoNumbers.add(newLotto);
        }
        return totalLottoNumbers;
    }

    public Lotto generateLottoNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 6) {
            int randomNumber = Randoms.pickNumberInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return new Lotto(numbers);
    }
}
