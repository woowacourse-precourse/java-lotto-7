package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class LottoLogic {
    private List<Lotto> lottos;
    private int lottoPrice;
    
    //디폴트 생성자.
    public LottoLogic() {
        this(1000);
    }

    public LottoLogic(int lottoPrice) {
        this.lottoPrice = lottoPrice;
        this.lottos = new ArrayList<Lotto>();
    }

    public List<Lotto> issueLottoAsPrice(int purchaseAmount) throws IllegalArgumentException {
        validatePurchaseAmount(purchaseAmount);

        int ticketCount = getTicketCount(purchaseAmount);

        for (int i = 0; i < ticketCount; ++i) {
            Lotto lotto = issueValidatedLotto();
            lottos.add(lotto);
        }

        return lottos;
    }

    private void validatePurchaseAmount(int purchaseAmount) throws IllegalArgumentException {
        if (purchaseAmount < lottoPrice) {
            throw new IllegalArgumentException("[ERROR] 입력하신 값은 로또 값 " + lottoPrice + "(원) 보다 작습니다." );
        }

        if (purchaseAmount % lottoPrice != 0) {
            throw new IllegalArgumentException("[ERROR] 입력하신 값은 로또 값 " + lottoPrice + "(원) 단위가 아닙니다." );
        }
    }

    private Lotto issueValidatedLotto() {
        while (true) {
            try {
                List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(Lotto.MIN_VALUE, Lotto.MAX_VALUE, Lotto.LOTTO_COUNT);
                randomNumbers.sort(Comparator.naturalOrder());
                Lotto lotto = new Lotto(randomNumbers);
                return lotto;
            } catch (IllegalArgumentException iae) {
                continue;
            }
        }
    }

    public int getTicketCount(int purchaseAmount) {
        return purchaseAmount / this.lottoPrice;
    }
    
}
