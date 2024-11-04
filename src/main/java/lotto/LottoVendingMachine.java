package lotto;

import static constant.LottoNumber.LOTTO_NUMBER_COUNT;
import static constant.LottoNumber.LOTTO_NUMBER_MAX;
import static constant.LottoNumber.LOTTO_NUMBER_MIN;

import camp.nextstep.edu.missionutils.Randoms;
import constant.OutputNotice;
import constant.Price;
import java.util.ArrayList;
import java.util.List;

public class LottoVendingMachine {

    public ArrayList<Lotto> giveLotto(Integer lottoPurchaseAmount) {
        Integer lottoCount = computeLottoCount(lottoPurchaseAmount);
        System.out.println(lottoCount + OutputNotice.PURCHASE_LOTTO_COUNT.show());
        ArrayList<Lotto> lottoTickets;
        lottoTickets = makeLottoTickets(lottoCount);
        return lottoTickets;
    }

    private Integer computeLottoCount(Integer lottoPurchaseAmount) {
        return lottoPurchaseAmount / Price.LOTTOPRICE.getPrice();
    }

    private ArrayList<Lotto> makeLottoTickets(Integer lottoCount) {
        ArrayList<Lotto> lottoTickets = new ArrayList<>();
        for (int count = 1; count <= lottoCount; count++) {
            List<Integer> lottoNumbers = makeLottoNumbers();
            Lotto lotto = new Lotto(lottoNumbers);
            lottoTickets.add(lotto);
        }
        return lottoTickets;
    }

    private List<Integer> makeLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN.getLottoNumber(),
                LOTTO_NUMBER_MAX.getLottoNumber(),
                LOTTO_NUMBER_COUNT.getLottoNumber());
    }
}
