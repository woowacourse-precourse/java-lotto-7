package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.LottoConstants;
import lotto.model.Lotto;
import lotto.model.LottoResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoService {
    private final int totalPurchase;

    public LottoService(int totalPurchase) {
        this.totalPurchase = totalPurchase;
    }

    public List<List<Integer>> generateLottoTickets() {
        int totalQuantity = this.totalPurchase / LottoConstants.TICKET_PRICE;
        System.out.printf("\n%d개를 구매했습니다.\n", totalQuantity);
        return getTotalRandomNumbers(totalQuantity);
    }

    private List<List<Integer>> getTotalRandomNumbers(int totalQuantity) {
        List<List<Integer>> totalRandomNumbers = new ArrayList<>();
        for (int i = 0; i < totalQuantity; i++) {
            List<Integer> randomNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(LottoConstants.MIN_NUMBER, LottoConstants.MAX_NUMBER, LottoConstants.PICK_COUNT));
            Collections.sort(randomNumbers);
            System.out.println(randomNumbers);
            totalRandomNumbers.add(randomNumbers);
        }
        return totalRandomNumbers;
    }
}
