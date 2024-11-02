package lotto.controller;

import lotto.domain.Wallet;
import lotto.domain.calculators.FinalPrizeCalculator;
import lotto.domain.calculators.TicketCalculator;
import lotto.domain.calculators.TicketCalculatorImpl;
import lotto.domain.calculators.YieldCalculator;
import lotto.domain.factory.UserMainLottoFactory;
import lotto.domain.lottos.RandomLottos;
import lotto.domain.lottos.user.UserLotto;
import lotto.domain.lottos.user.WinningLotto;
import lotto.domain.number.RandomLottoNumberMaker;
import lotto.service.LottoMatchService;
import lotto.service.RandomLottoMarket;
import lotto.service.YieldCalculateService;
import lotto.view.Input;
import lotto.view.Output;

public class MainController {
    private RandomLottoMarket randomLottoMarket;
    private LottoMatchService lottoMatchService;
    private YieldCalculateService yieldCalculateService;

    public void run() {
        Wallet wallet = createWallet();
        RandomLottos randomLottos = new RandomLottos(new RandomLottoNumberMaker());
        createRandomLottos(wallet, randomLottos);
        Output.printPurchasedLottoList(wallet, randomLottos);

        UserLotto userLotto = createUserLotto();
        WinningLotto winningLotto = new WinningLotto(new FinalPrizeCalculator());

        matchLotto(randomLottos, userLotto, winningLotto);
        calculateRateOfReturn(wallet, winningLotto);

        Output.printLottoWinningStatistics(winningLotto);
        Output.printRateOfReturn(wallet);
    }


    private void matchLotto(RandomLottos randomLottos, UserLotto userLotto, WinningLotto winningLotto) {
        lottoMatchService = new LottoMatchService(randomLottos, userLotto, winningLotto);
        lottoMatchService.matchLottos();
    }

    private void calculateRateOfReturn(Wallet wallet, WinningLotto winningLotto) {
        YieldCalculator yieldCalculator = new YieldCalculator();
        yieldCalculateService = new YieldCalculateService(yieldCalculator, wallet, winningLotto);
        yieldCalculateService.calculateRateOfReturn();
    }

    private void createRandomLottos(Wallet wallet, RandomLottos randomLottos) {
        TicketCalculator ticketCalculator = new TicketCalculatorImpl();
        randomLottoMarket = new RandomLottoMarket(ticketCalculator, randomLottos, wallet);
        randomLottoMarket.createRandomLottos();
    }


    private UserLotto createUserLotto() {
        UserLotto.Builder builder = new UserLotto.Builder();
        inputUserMainSixLottoBuild(builder);
        inputUserBonusLottoBuild(builder);

        return builder.build();
    }

    private void inputUserMainSixLottoBuild(UserLotto.Builder builder) {
        UserMainLottoFactory factory = new UserMainLottoFactory();

        while (true) {
            try {
                builder.mainLotto(factory.make(Input.inputMainSixLotto()));
                break;
            } catch (IllegalArgumentException e) {
                Output.printError(e.getMessage());
            }
        }
    }

    private void inputUserBonusLottoBuild(UserLotto.Builder builder) {
        while (true) {
            try {
                builder.bonusLotto(Input.inputBonusLotto());
                break;
            } catch (IllegalArgumentException e) {
                Output.printError(e.getMessage());
            }
        }
    }

    private Wallet createWallet() {
        while (true) {
            try {
                return new Wallet(Input.inputPurchaseAmount());
            } catch (IllegalArgumentException e) {
                Output.printError(e.getMessage());
            }
        }
    }

}
