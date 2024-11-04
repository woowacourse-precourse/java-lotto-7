package lotto.application;

import lotto.domain.Lotto;
import lotto.global.LottoPrize;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    private static final int LOTTO_PRICE = 1000;
    private static LottoService instance;
    private final LottoGenerator lottoGenerator;

    private LottoService(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public static LottoService getInstance(LottoGenerator lottoGenerator) {
        if (instance == null) {
            instance = new LottoService(lottoGenerator);
        }
        return instance;
    }

    public List<Lotto> buyLottos(int price) {
        validatePrice(price);
        List<Lotto> lottos = new ArrayList<>();

        for(int i = 0; i < price / LOTTO_PRICE; i++) {
            lottos.add(lottoGenerator.generate());
        }

        return lottos;
    }

    public LottoPrize calculatePrize(Lotto myLotto, Lotto LottoResult, int bonusNumber) {
        long matchLottoCount = myLotto.getNumbers().stream()
                .filter(LottoResult.getNumbers()::contains)
                .count();

        boolean matchBonusNumber = myLotto.getNumbers().contains(bonusNumber);

        return LottoPrize.from(matchLottoCount, matchBonusNumber);
    }

    public Double calculateProfitRate(List<LottoPrize> results, int purchaseQuantity) {
        int totalPrize = results.stream()
                .map(result -> result.getPrizeMoney().replace(",", ""))
                .mapToInt(Integer::parseInt)
                .sum();
        return (double) totalPrize / purchaseQuantity;
    }

    private void validatePrice(int price) {
        if (price <= 0 || price % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }
}
