package lotto.service;

import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.model.LottoMachine;
import lotto.model.LottoRank;
import lotto.model.LottoResultCalculator;

public class LottoService {

    private final LottoMachine lottoMachine;

    public LottoService(LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    /**
     * 구입 금액을 기반으로 로또 티켓을 발행
     *
     * @param amount 구입 금액
     * @return 발행된 로또 티켓 리스트
     */
    public List<Lotto> purchaseLottoTickets(int amount) {
        return lottoMachine.issueLottoTickets(amount);
    }

    /**
     * 당첨 결과를 계산
     *
     * @param tickets 사용자 로또 티켓 리스트
     * @param winningNumbers 당첨 번호 리스트
     * @param bonusNumber 보너스 번호
     * @return 당첨 등수별 당첨 횟수 Map
     */
    public Map<LottoRank, Integer> calculateResults(
            List<Lotto> tickets,
            List<Integer> winningNumbers,
            int bonusNumber
    ) {
        LottoResultCalculator calculator = new LottoResultCalculator(winningNumbers, bonusNumber);
        return calculator.calculateResults(tickets);
    }
}