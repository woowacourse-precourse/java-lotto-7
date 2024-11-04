package lotto.model.service;

import java.util.List;
import lotto.dto.LottoPurchasesDto;
import lotto.dto.LottoResultDto;
import lotto.dto.LottoResultMessageDto;
import lotto.dto.WinningLottoDto;
import lotto.model.domain.Lotto;

public class LottoService {

    private static final MyLottosGenerateService myLottosGenerateService = new MyLottosGenerateService();
    private static final LottoResultService lottoResultService = new LottoResultService();
    private static final GenerateMessageService generateMessageService = new GenerateMessageService();

    private List<Lotto> myLottos;

    public LottoPurchasesDto purchaseLottos(int amount) {
        myLottos = myLottosGenerateService.generateLottos(amount);
        return generateMessageService.generatePurchasesMessage(myLottos);
    }

    public LottoResultMessageDto matchMyLottoWith(WinningLottoDto winningLottoDto) {
        LottoResultDto lottoResultDto = lottoResultService.resultFrom(winningLottoDto, myLottos);
        return generateMessageService.generateResultMessage(lottoResultDto);
    }
}
