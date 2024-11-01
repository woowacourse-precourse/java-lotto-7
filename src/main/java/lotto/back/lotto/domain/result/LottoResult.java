package lotto.back.lotto.domain.result;

import java.util.List;
import lotto.global.exception.CustomIllegalArgumentException;
import lotto.back.lotto.domain.Lotto;
import lotto.back.lotto.domain.LottoNumber;
import lotto.global.status.LottoStatus;

public class LottoResult {

    private final Lotto lotto;

    private final LottoStatus lottoStatus;


    public LottoResult(Lotto lotto, Lotto prizeLotto, LottoNumber bonusNumber) {
        this.lotto = lotto;

        if (prizeLotto.getNumbers().contains(bonusNumber.number())) {
            throw new CustomIllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
        this.lottoStatus = calculateLottoStatus(lotto, prizeLotto, bonusNumber);
    }


    public Lotto getLotto() {
        return lotto;
    }

    public LottoStatus getLottoStatus() {
        return lottoStatus;
    }

    private LottoStatus calculateLottoStatus(Lotto lotto, Lotto prizeLotto, LottoNumber bonusNumber) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        Integer matchCount = (int) lottoNumbers.stream()
                .filter(prizeLotto.getNumbers()::contains)
                .count();
        Boolean bonusMatched = lottoNumbers.contains(bonusNumber.number());

        return LottoStatus.getResult(matchCount, bonusMatched);
    }
}
