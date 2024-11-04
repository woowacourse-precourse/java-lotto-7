package lotto.controller;

import java.util.List;
import lotto.model.Rank;
import lotto.service.LottoService;
import lotto.view.Inputview;
import lotto.view.Outputview;

public class LottoController {
    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        int money = getPurchaseAmount();
        lottoService.issueLottoTickets(money / 1000);
        Outputview.printLottoTickets(lottoService.getLottoTickets());

        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber(winningNumbers);

        lottoService.setWinningNumbers(winningNumbers, bonusNumber);

        List<Rank> results = lottoService.calculateResults();
        Outputview.printResults(results);

        double yield = lottoService.calculateYield(money);
        Outputview.printYield(yield);
    }

    private int getPurchaseAmount() {
        while (true) {
            try {
                return Inputview.inputMoney();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> getWinningNumbers() {
        while (true) {
            try {
                String winningNumbers = Inputview.inputWinningNumbers();
                return lottoService.parseWinningNumbers(winningNumbers); // 유효성 검사 및 파싱
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                int bonusNumber = Inputview.inputBonusNumber();
                if (winningNumbers.contains(bonusNumber)) {
                    throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
                }
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
