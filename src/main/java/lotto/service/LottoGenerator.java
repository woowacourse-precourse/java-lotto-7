package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;
import lotto.util.StringUtil;

public class LottoGenerator {

    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private static final int LOTTO_NUMBERS_COUNT = 6;
    private static final int LOTTO_PRICE = 1000;

    private Lotto[] lotto;
    private int purchaseAmount;

    // 사용자가 구매 금액을 입력하면 그 금액에 맞게 로또를 발행 (1000원당 1개의 로또)
    public Lotto[] generate(String amount){
        StringUtil.checkIfNull(amount);
        purchaseAmount = StringUtil.parseToPositiveInt(amount);

        validatePurchaseAmount(purchaseAmount);
        int numberOfLottoTickets = calculateNumberOfLottoTickets(purchaseAmount);
        lotto = new Lotto[numberOfLottoTickets];

        for (int i = 0; i < numberOfLottoTickets; i++) {
            List<Integer> randomNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_NUMBERS_COUNT));
            Collections.sort(randomNumbers);

            lotto[i] = new Lotto(randomNumbers);
        }

        return lotto;
    }

    // 입력된 구매 금액이 1000원 단위로 입력되었는지 확인하는 메서드
    private void validatePurchaseAmount(int purchaseAmount) {
        if(purchaseAmount % LOTTO_PRICE != 0){
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 단위여야 합니다.");
        }
    }

    // 총 발행할 로또의 수를 계산하는 메서드
    public int calculateNumberOfLottoTickets(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

    public Lotto[] getLotto() {
        return lotto;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
