package lotto.service;

import lotto.dto.FinalResultsDto;
import lotto.dto.LottosDto;

public interface LottoResultService {
    void receiveWinningLottoNumbers(String rawWinningNumbers);
    void receiveBonusNumber(String rawBonusNumbers);
    FinalResultsDto getFinalResultsDto(LottosDto lottosDto);


}
