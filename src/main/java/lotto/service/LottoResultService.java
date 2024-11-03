package lotto.service;

import lotto.dto.RankResultsDto;
import lotto.dto.LottosDto;

public interface LottoResultService {
    void receiveWinningLottoNumbers(String rawWinningNumbers);
    void receiveBonusNumber(String rawBonusNumbers);
    RankResultsDto getRankResultsDto(LottosDto lottosDto);


}
