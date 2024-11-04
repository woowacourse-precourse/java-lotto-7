package lotto.cotroller;

import static lotto.utils.Parser.parseBonusNum;
import static lotto.utils.Parser.parseMoney;
import static lotto.utils.Parser.parseWinningNumbs;

import java.util.List;
import lotto.domain.Lotto;
import lotto.service.LottoGenerator;
import lotto.service.LottoRevenueCalculator;
import lotto.service.LottoWinningChecker;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class LottoController {
    private final LottoInputView lottoInputView;
    private final LottoOutputView lottoOutputView;
    private final LottoGenerator lottoGenerator;
    private final LottoWinningChecker lottoWinningChecker;
    private final LottoRevenueCalculator lottoRevenueCalculator;

    public LottoController(LottoInputView lottoInputView, LottoOutputView lottoOutputView,
                           LottoGenerator lottoGenerator, LottoWinningChecker lottoWinningChecker,
                           LottoRevenueCalculator lottoRevenueCalculator) {
        this.lottoInputView = lottoInputView;
        this.lottoOutputView = lottoOutputView;
        this.lottoGenerator = lottoGenerator;
        this.lottoWinningChecker = lottoWinningChecker;
        this.lottoRevenueCalculator = lottoRevenueCalculator;
    }

    public void run() {
        int money = requestMoney();
        List<Lotto> lottos = createLottos(money);

        requestWinningNumbs();
        requestBonusNumb();

        response(lottos, money);
    }

    private int requestMoney() {
        int money = 0;
        while (true) {
            String inputMoney = lottoInputView.inputMoney();
            try {
                money = parseMoney(inputMoney);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return money;
    }

    private List<Lotto> createLottos(int money) {
        List<Lotto> lottos = lottoGenerator.generateMany(money);
        lottoOutputView.printLottos(lottos);
        return lottos;
    }

    private void requestWinningNumbs() {
        List<Integer> winningNumbs;
        while (true) {
            String inputWinningNums = lottoInputView.inputWinningNums();
            try {
                winningNumbs = parseWinningNumbs(inputWinningNums);
                lottoWinningChecker.saveWinningNumbs(winningNumbs);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void requestBonusNumb() {
        int bonusNum;
        while (true) {
            String inputBonusNum = lottoInputView.inputBonusNum();
            try {
                bonusNum = parseBonusNum(inputBonusNum);
                lottoWinningChecker.saveBonusNumber(bonusNum);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void response(List<Lotto> lottos, int money) {
        int[] checkRanks = lottoWinningChecker.checkRanks(lottos);
        float rateOfRevenue = lottoRevenueCalculator.calculateRateOfRevenue(checkRanks, money);
        lottoOutputView.printResult(checkRanks, rateOfRevenue);
    }
}
