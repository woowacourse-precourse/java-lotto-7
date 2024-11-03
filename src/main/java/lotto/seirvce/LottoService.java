package lotto.seirvce;

import lotto.dto.LottoControllerInputDto;
import lotto.entity.LottoMachine;
import lotto.entity.ProfitReport;

public class LottoService {
    public LottoMachine createLottoMachine(LottoControllerInputDto inputDto) {
        return new LottoMachine(inputDto.getPaymentAmount(), inputDto.getWinnerNumbers(), inputDto.getBonusNumber());
    }

    public ProfitReport generateProfitReport(LottoMachine lottoMachine) {
        return new ProfitReport(lottoMachine.getPurchasedLottos(), lottoMachine.getWinningNumbers());
    }
}
