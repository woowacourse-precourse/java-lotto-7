package lotto.controller;

import lotto.domain.Wallet;
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
        RandomLottos randomLottos = createRandomLottos(wallet);
        Output.printPurchasedLottoList(wallet, randomLottos);

        UserLotto userLotto = createUserLotto();
        WinningLotto winningLotto = new WinningLotto();

        matchLotto(randomLottos, userLotto, winningLotto);
        calculateRateOfReturn(wallet, winningLotto);

        Output.printLottoWinningStatistics(winningLotto);
        Output.printRateOfReturn(wallet);
    }

    private void calculateRateOfReturn(Wallet wallet, WinningLotto winningLotto) {
        yieldCalculateService = new YieldCalculateService(wallet, winningLotto);
        yieldCalculateService.calculateRateOfReturn();
    }

    private void matchLotto(RandomLottos randomLottos, UserLotto userLotto, WinningLotto winningLotto) {
        lottoMatchService = new LottoMatchService(randomLottos, userLotto, winningLotto);
        lottoMatchService.matchLottos();
    }

    private RandomLottos createRandomLottos(Wallet wallet) {
        randomLottoMarket = new RandomLottoMarket(new RandomLottoNumberMaker(), wallet);
        return randomLottoMarket.createRandomLottos();
    }


    private UserLotto createUserLotto() {
        UserLotto.Builder builder = new UserLotto.Builder();
        createUserMainSixLottoBuilder(builder);
        createUserBonusLottoBuilder(builder);

        return builder.build();
    }

    private void createUserMainSixLottoBuilder(UserLotto.Builder builder) {
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

    private void createUserBonusLottoBuilder(UserLotto.Builder builder) {
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
        TicketCalculator ticketCalculator = new TicketCalculatorImpl();
        YieldCalculator yieldCalculator = new YieldCalculator();

        while (true) {
            try {
                return new Wallet(Input.inputPurchaseAmount(), ticketCalculator, yieldCalculator);
            } catch (IllegalArgumentException e) {
                Output.printError(e.getMessage());
            }
        }
    }

}
