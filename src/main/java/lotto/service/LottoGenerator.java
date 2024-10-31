package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;
import lotto.io.OutputHandler;
import lotto.util.StringUtil;

public class LottoGenerator {

    private Lotto[] lotto;
    private int numberOfLottoTickets;

    // 사용자가 구매 금액을 입력하면 그 금액에 맞게 로또를 발행 (1000원당 1개의 로또)
    public void generate(String amount){
        Integer purchaseAmount = StringUtil.parseToPositiveInt(amount);

        validatePurchaseAmount(purchaseAmount);
        calculateNumberOfLottoTickets(purchaseAmount);
        lotto = new Lotto[numberOfLottoTickets];

        for (int i = 0; i < numberOfLottoTickets; i++) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(randomNumbers);

            lotto[i] = new Lotto(randomNumbers);
        }
    }

    // 입력된 구매 금액이 1000원 단위로 입력되었는지 확인하는 메서드
    private void validatePurchaseAmount(int purchaseAmount) {
        if(purchaseAmount % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 단위여야 합니다.");
        }
    }

    // 총 발행할 로또의 수를 계산하는 메서드
    private void calculateNumberOfLottoTickets(int purchaseAmount) {
        numberOfLottoTickets = purchaseAmount / 1000;
    }

    // 발행된 로또를 출력하는 메서드
    public void printPurchasedLotto(){
        OutputHandler.promptPurchasedQuantity(numberOfLottoTickets);
        for (Lotto lotto : lotto) {
            System.out.println(lotto);
        }
    }
}
