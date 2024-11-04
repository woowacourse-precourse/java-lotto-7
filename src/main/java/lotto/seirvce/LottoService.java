package lotto.seirvce;

import lotto.dto.LottoControllerInputDto;
import lotto.entity.LottoMachine;
import lotto.entity.ProfitReport;

public class LottoService {
    public LottoMachine createLottoMachine(LottoControllerInputDto inputDto) {
        return new LottoMachine(inputDto.paymentAmount(), inputDto.winnerNumbers(), inputDto.bonusNumber());
    }

    public ProfitReport generateProfitReport(LottoMachine lottoMachine) {
        return new ProfitReport(lottoMachine.getPurchasedLottos(), lottoMachine.getWinningNumbers());
    }
}
