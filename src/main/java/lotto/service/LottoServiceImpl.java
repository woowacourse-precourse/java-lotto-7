package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.common.LottoConstants;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoDto;
import lotto.domain.purchase.Purchase;
import lotto.domain.purchase.PurchaseDto;

public class LottoServiceImpl implements LottoService {
    private Purchase purchase;
    private Lotto winningLotto;

    @Override
    public void buyLotto(String amount) {
        purchase = new Purchase(amount);
        List<Lotto> lottos = makeRandomLottos(purchase.getAmount());
        purchase.setLottos(lottos);
    }

    @Override
    public void assignWinningLotto(String numbers) {
        winningLotto = new Lotto(numbers);
    }

    public PurchaseDto getPurchaseDto() {
        List<LottoDto> lottoDtos = convertLottosToLottoDtos(purchase.getLottos());
        return new PurchaseDto(purchase.getAmount(), lottoDtos);
    }

    private List<Lotto> makeRandomLottos(int amount) {
        List<Lotto> purchasedLottos = new ArrayList<>();

        int count = amount / LottoConstants.PRICE;
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LottoConstants.MIN_NUMBER, LottoConstants.MAX_NUMBER,
                    LottoConstants.NUMBERS_COUNT);
            purchasedLottos.add(new Lotto(numbers));
        }

        return purchasedLottos;
    }

    private List<LottoDto> convertLottosToLottoDtos(List<Lotto> lottos) {
        List<LottoDto> lottoDtos = new ArrayList<>();
        for (Lotto lotto : lottos) {
            lottoDtos.add(new LottoDto(lotto.getNumbers()));
        }

        return lottoDtos;
    }
}
