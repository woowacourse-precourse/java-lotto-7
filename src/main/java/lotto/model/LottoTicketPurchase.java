package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoTicketPurchase {
    List<Lotto> lottoTickets;

    public LottoTicketPurchase(Integer buyCount) {
        buyCountValidation(buyCount);
        this.lottoTickets = makeBuyLottoList(buyCount);
        validationTicketNullCheck(lottoTickets);
    }

    private void buyCountValidation(Integer buyCount) {
        if (buyCount == null || buyCount == 0) {
            throw new IllegalArgumentException("[ERROR] 구매 개수가 0개입니다.");
        }
    }

    private void validationTicketNullCheck(List<Lotto> lottoTickets) {
        if (lottoTickets == null || lottoTickets.isEmpty()) {
           throw new IllegalArgumentException("[ERROR] 로또 티켓이 발급되지 않았습니다!");
        }
    }

    private Lotto genarateLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    private List<Lotto> makeBuyLottoList(int buyCount) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < buyCount; i++) {
            lottoList.add(genarateLotto());
        }
        return lottoList;
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }
}
