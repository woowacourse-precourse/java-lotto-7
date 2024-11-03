package lotto.handler;

import java.util.List;

import lotto.domain.LottoTicket;
import lotto.domain.DrawingLottoTicket;
import lotto.util.WinningInfo;

public class LottoHandler {
    // 입력된 당첨 번호와 발급받은 로또 번호를 대조하여 일치하는 번호의 갯수를 반환
    public List<Double> compareNumbers(DrawingLottoTicket winningLottoTicket, LottoTicket lottoTicket) {
        return winningLottoTicket.determineLotto(lottoTicket.getLottoNumbers(),
                lottoTicket.getBonusNumber());
    }

    public double calculateRateOfReturn(List<Double> matchCounts, int purchaseMoney) {
        double prizeMoney = 0;

        // 총 당첨 금액 계산
        for (Double matchCount : matchCounts) {
            prizeMoney += WinningInfo.getWinningInfoByMatchCount(matchCount).getReturnMoney();
        }

        // 수익률을 계산하여 소수점 둘째 자리에서 반올림
        double rateOfReturn = (prizeMoney / purchaseMoney) * 100;
        return Math.round(rateOfReturn * 10) / 10.0;
    }
}
