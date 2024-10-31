package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoStatistics;
import lotto.services.LottoServices;
import lotto.view.LottoView;

import java.util.List;

public class LottoController {
    private final LottoView view;
    private final LottoServices services;
    private final LottoStatistics statistics;

    public LottoController(LottoView view, LottoServices services, LottoStatistics statistics) {
        this.view = view;
        this.services = services;
        this.statistics = statistics;
    }

    public void start() {
        // 구입 금액을 입력받아 검증
        int amount = readValidPurchaseAmount();
        int quantity = amount / 1000;

        // 랜덤 로또 N장 생성 및 출력
        List<Lotto> randomLotteries = services.createRandomLotteries(quantity);
        view.displayLottoCount(quantity);
        view.displayLottos(randomLotteries);

        // 사용자 로또 번호 입력 받기
        Lotto userLotto = services.createLotto(readValidWinningNumbers());

        // 사용자 로또 보너스 번호 입력 받기
        int bonusNumber = readValidBonusNumber();

        // 당첨 결과 확인 및 출력
        services.checkLottoResults(statistics, randomLotteries, userLotto, bonusNumber);
        services.checkLottoYield(statistics, amount);
        view.printLottoResult(statistics);

    }

    public int readValidPurchaseAmount() {
        int amount;
        while (true) {
            try {
                amount = view.readPurchaseAmount();
                if(amount < 1000) {
                    throw new IllegalArgumentException("금액은 최소 1,000원 이상이어야 합니다.");
                }
                if(amount % 1000 != 0) {
                    throw new IllegalArgumentException("금액은 1,000원 단위여야 합니다.");
                }
                return amount;
            } catch(IllegalArgumentException e) {
                view.displayError(e.getMessage());
            }
        }
    }

    public List<Integer> readValidWinningNumbers() {
        while (true) {
            List<Integer> winningNumbers = view.readWinningNumbers();
            try {
                return new Lotto(winningNumbers).getNumbers();
            } catch (IllegalArgumentException e) {
                view.displayError(e.getMessage());
            }
        }
    }

    public int readValidBonusNumber() {
        int bonusNumber;
        while (true) {
            bonusNumber = view.readBonusNumber();
            if (bonusNumber >= 1 && bonusNumber <= 45) {
                break;
            }
            view.displayError("보너스 번호는 1~45 사이의 숫자여야 합니다.");
        }
        return bonusNumber;
    }
}
