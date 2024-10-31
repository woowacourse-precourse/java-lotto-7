package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.model.LottoTicketPurchase;

import java.util.ArrayList;
import java.util.List;

public class LottoPurchaseController {
    private final LottoTicketPurchase lottoTicketPurchase;

    public LottoPurchaseController(Integer buyCount) {
        this.lottoTicketPurchase = new LottoTicketPurchase(getBuyLottoList(buyCount));
    }


    public List<Lotto> getBuyLottoList(int buyCount) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < buyCount; i++) {
            lottoList.add(genarateLotto());
        }
        return lottoList;
    }

    public Lotto genarateLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }



}
