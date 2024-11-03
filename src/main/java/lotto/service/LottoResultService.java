package lotto.service;

import lotto.dto.FinalResultDto;
import lotto.dto.LottosDto;

public interface LottoResultService {
    void receiveWinningLottoNumbers(String rawWinningNumbers);
    void receiveBonusNumber(String rawBonusNumbers);
    FinalResultDto getFinalResultDto(LottosDto lottosDto);

}
