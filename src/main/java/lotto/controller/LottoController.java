package lotto.controller;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.LottoTicket;
import lotto.domain.WinningLotto;
import lotto.domain.WinningLottoTicket;
import lotto.handler.InputHandler;
import lotto.handler.OutputHandler;
import lotto.util.WinningInfo;

public class LottoController {
    private InputHandler inputHandler;
    private OutputHandler outputHandler;

    public LottoController(InputHandler inputHandler, OutputHandler outputHandler) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    public void lottoStart() {
        try {
            int purchaseMoney = inputHandler.getPurchasePrice();
            WinningLottoTicket winningLottoTicket = makeWinningLottoTicket(purchaseMoney / 1000);
            LottoTicket lottoTicket = makeLottoTicket();
            List<Double> matchNumbers = compareNumbers(winningLottoTicket, lottoTicket);
            double rateOfReturn = calculateRateOfReturn(matchNumbers, purchaseMoney);

            outputHandler.printPurchaseResult(purchaseMoney / 1000, winningLottoTicket.getWinningNumbers());
            outputHandler.printLottoResult(matchNumbers, rateOfReturn);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // 입력된 구입금액 만큼 로또를 발행
    private WinningLottoTicket makeWinningLottoTicket(int count) {
        List<WinningLotto> winningNumbers = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            winningNumbers.add(new WinningLotto());
        }

        return new WinningLottoTicket(winningNumbers);
    }

    // 입력된 당첨 번호와 보너스 번호로 로또 정보를 발행
    private LottoTicket makeLottoTicket() {
        List<Integer> numbers = inputHandler.getLottoNumber();
        int bonusNumber = inputHandler.getBonusNumber();

        return new LottoTicket(numbers, bonusNumber);
    }

    // 입력된 당첨 번호와 발급받은 로또 번호를 대조하여 일치하는 번호의 갯수를 반환
    private List<Double> compareNumbers(WinningLottoTicket winningLottoTicket, LottoTicket lottoTicket) {
        return winningLottoTicket.determineWin(lottoTicket.getLottoNumbers(),
                lottoTicket.getBonusNumber());
    }

    private double calculateRateOfReturn(List<Double> matchCounts, int purchaseMoney) {
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
