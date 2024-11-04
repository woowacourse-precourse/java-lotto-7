package lotto.back.lotto.domain.result;

import java.util.List;
import lotto.back.lotto.domain.Lotto;
import lotto.back.lotto.domain.LottoNumber;
import lotto.back.lotto.domain.Lottos;

public class LottoResults {

    private final List<LottoResult> lottoResults;

    private final Lotto prizeLotto;

    private final LottoNumber bonusNumber;

    private final Integer price;


    public LottoResults(Lottos lottos, Lotto prizeLotto, Integer bonusNumber) {
        this.prizeLotto = prizeLotto;
        this.bonusNumber = new LottoNumber(bonusNumber);
        this.lottoResults = lottos.getLottos().stream()
                .map(lotto -> new LottoResult(lotto, this.prizeLotto, this.bonusNumber))
                .toList();
        this.price = lottos.getPrice();
    }


    public List<LottoResult> getLottoResults() {
        return lottoResults;
    }

    public Integer getPrice() {
        return price;
    }
}
