package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoPrice;
import lotto.domain.User;
import lotto.domain.WinningLotto;

import java.util.Arrays;
import java.util.List;

public class LottoService {

    private static final int PRICE_SIZE = 6;

    private static LottoService lottoService;

    private LottoService() {
    }

    public static LottoService getInstance() {
        if (lottoService == null) lottoService = new LottoService();
        return lottoService;
    }

    public int[] calculateLottoResult(User user, WinningLotto winningLotto) {
        int[] priceList = new int[PRICE_SIZE];
        Arrays.fill(priceList, 0);

        List<Lotto> lottos = user.getLottos();

        for (Lotto lotto : lottos) {
            int matchNum = getMatchCount(lotto, winningLotto);
            boolean bonusNumber = isBonusMatch(lotto, winningLotto);

            LottoPrice matchPrice = LottoPrice.getLottoPrice(matchNum, bonusNumber);
            priceList[matchPrice.getPrice()]++;
        }

        return priceList;
    }


    public long getTotalProfit(int[] prize) {
        long sum = 0;
        for (int price = 5; price >= 1; price--) {
            LottoPrice lottoPrice = LottoPrice.getLottoPriceByPrice(price);
            sum += (long) lottoPrice.getPriceMoney() * prize[price];
        }

        return sum;
    }

    private int getMatchCount(Lotto lotto, WinningLotto winningLotto) {
        return (int) winningLotto.getWinningLotto().getNumbers().stream()
                .filter(lotto.getNumbers()::contains)
                .count();
    }

    private boolean isBonusMatch(Lotto lotto, WinningLotto winningLotto) {
        return lotto.getNumbers().contains(winningLotto.getBonusNumber());
    }
}
