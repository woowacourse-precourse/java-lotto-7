package lotto.model.service;

import java.util.List;
import java.util.Map;
import lotto.dto.LottoPurchasesDto;
import lotto.dto.LottoResultDto;
import lotto.dto.LottoResultMessageDto;
import lotto.model.domain.Lotto;
import lotto.model.domain.LottoPrize;

public class GenerateMessageService {

    public LottoPurchasesDto generatePurchasesMessage(List<Lotto> myLottos) {
        StringBuilder purchasesMessage = new StringBuilder();
        for (Lotto myLotto : myLottos) {
            purchasesMessage.append(myLotto.showLottoNumbers()).append("%n");
        }
        return new LottoPurchasesDto(myLottos.size(), purchasesMessage.toString());
    }

    public LottoResultMessageDto generateResultMessage(LottoResultDto lottoResultDto) {
        Map<LottoPrize, Integer> lottoResult = lottoResultDto.getResult();
        StringBuilder resultMessage = new StringBuilder();
        List<LottoPrize> forReverse = List.of(LottoPrize.FIFTH, LottoPrize.FOURTH, LottoPrize.THIRD,
                LottoPrize.SECOND, LottoPrize.FIRST);
        for (LottoPrize lottoPrize : forReverse) {
            resultMessage.append(lottoPrize.formatResultMessage(lottoResult.get(lottoPrize))).append("%n");
        }
        return new LottoResultMessageDto(lottoResultDto.getWinningRate(), resultMessage.toString());
    }
}
