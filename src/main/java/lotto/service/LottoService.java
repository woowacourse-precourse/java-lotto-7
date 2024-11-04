package lotto.service;

import lotto.domain.LottoRound;
import lotto.dto.IssuedLottoDTO;
import lotto.dto.LottoGradingNumbersDTO;
import lotto.dto.LottoWinStatisticDTO;
import lotto.view.LottoInput;
import lotto.view.LottoOutput;

import java.util.List;

public class LottoService {
    private final LottoRound lottoRound;

    public LottoService() {
        this.lottoRound = new LottoRound();
    }

    private LottoRound getLottoRound() {
        return this.lottoRound;
    }

    public void issue() {
        int issueCount = LottoInput.getIssueCount().count();

        LottoRound lottoRound = getLottoRound();
        lottoRound.issueLottoes(issueCount);

        LottoOutput.printIssuedLotto(new IssuedLottoDTO(lottoRound));
    }

    public void lot() {
        LottoGradingNumbersDTO gradingNumbersDTO = LottoInput.getGradingNumbers();

        LottoRound lottoRound = getLottoRound();
        List<Integer> gradingLottoNumbers = gradingNumbersDTO.winNumbers();
        int bonusLottoNumber = gradingNumbersDTO.bonusNumber();

        lottoRound.setWinNumbers(gradingLottoNumbers, bonusLottoNumber);
    }

    public void scratch() {
        LottoRound lottoRound = getLottoRound();

        List<Integer> winHistory = lottoRound.getWinHistory();
        float profitRate = lottoRound.getProfitRate();

        LottoOutput.printWinStatistic(new LottoWinStatisticDTO(winHistory, profitRate));
    }
}
