package lotto.service;

import java.util.List;
import lotto.common.LottoRank;
import lotto.domain.bonus.BonusDto;
import lotto.domain.lotto.LottoDto;
import lotto.domain.purchase.PurchaseDto;

public interface LottoService {
    void buyLotto(String amount);

    void assignWinningLotto(String numbers);

    void assignBonus(String number);

    PurchaseDto getPurchaseDto();

    LottoDto getWinningLottoDto();

    BonusDto getBonusDto();

    List<LottoRank> calculateLottoRank();

    double calculateProfitRate(List<LottoRank> lottoRanks);
}
