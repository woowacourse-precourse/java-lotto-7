package lotto.util;

import lotto.model.Lotto;
import lotto.dto.UserInputDTO;
import lotto.dto.WinningResultDTO;
import lotto.input.matcher.LottoNumbersMatcher;
import lotto.model.MatchResult;

import java.util.List;

public class WinningCalculator {
    private final LottoNumbersMatcher lottoNumbersMatcher;

    public WinningCalculator(LottoNumbersMatcher lottoNumbersMatcher) {
        this.lottoNumbersMatcher = lottoNumbersMatcher;
    }

    public WinningResultDTO getWinningResult(UserInputDTO userInputDTO, List<Lotto> randomLottoList) {
        WinningResultDTO winningResultDTO = new WinningResultDTO();

        for (Lotto randomLotto : randomLottoList) {
            Integer matchPoint = lottoNumbersMatcher.runByLottoNumbers(userInputDTO.getWinningLotto(), randomLotto);
            boolean hasBonus = lottoNumbersMatcher.runByBonusNumbers(userInputDTO.getBonusNumber(), randomLotto);

            MatchResult matchResult = MatchResult.getMatchResult(matchPoint, hasBonus);

            if (matchResult != null) {
                matchResult.applyResult(winningResultDTO);
            }
        }
        return winningResultDTO;
    }
}
