package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.LottoRound;
import lotto.dto.IssuedLottoDTO;
import lotto.dto.LottoGradingNumbersDTO;
import lotto.dto.LottoWinStatisticDTO;
import lotto.view.LottoInput;
import lotto.view.LottoOutput;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int issueCount = LottoInput.getIssueCount().count();

        LottoRound lottoRound = new LottoRound();
        lottoRound.issueLottoes(issueCount);

        LottoOutput.printIssuedLotto(new IssuedLottoDTO(lottoRound));

        LottoGradingNumbersDTO gradingNumbersDTO = LottoInput.getGradingNumbers();

        List<Integer> gradingLottoNumbers = gradingNumbersDTO.winNumbers();
        int bonusLottoNumber = gradingNumbersDTO.bonusNumber();
        lottoRound.setWinNumbers(gradingLottoNumbers, bonusLottoNumber);

        List<Integer> winHistory = lottoRound.getWinHistory();
        float profitRate = lottoRound.getProfitRate();

        LottoOutput.printWinStatistic(new LottoWinStatisticDTO(winHistory, profitRate));
    }
}
