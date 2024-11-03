package lotto.controller;

import lotto.domain.Wallet;
import lotto.domain.calculators.FinalPrizeCalculator;
import lotto.domain.calculators.TicketCalculator;
import lotto.domain.calculators.TicketCalculatorImpl;
import lotto.domain.calculators.YieldCalculator;
import lotto.domain.factory.UserSixLottoFactory;
import lotto.domain.lottos.RandomLottos;
import lotto.domain.lottos.user.UserLotto;
import lotto.domain.lottos.user.WinningRank;
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
        Output.printPurchasedLottoList(randomLottos);

        UserLotto userLotto = createUserLotto();
        WinningRank winningRank = new WinningRank(new FinalPrizeCalculator());

        processLotto(randomLottos, userLotto, winningRank, wallet);

        Output.printLottoWinningStatistics(winningRank);
        Output.printRateOfReturn(wallet);
    }

    private void processLotto(
            RandomLottos randomLottos, UserLotto userLotto, WinningRank winningRank, Wallet wallet) {

        matchLotto(randomLottos, userLotto, winningRank);
        calculateRateOfReturn(wallet, winningRank);
    }


    private void matchLotto(RandomLottos randomLottos, UserLotto userLotto, WinningRank winningRank) {
        lottoMatchService = new LottoMatchService(randomLottos, userLotto, winningRank);
        lottoMatchService.matchLottos();
    }

    private void calculateRateOfReturn(Wallet wallet, WinningRank winningRank) {
        YieldCalculator yieldCalculator = new YieldCalculator();
        yieldCalculateService = new YieldCalculateService(yieldCalculator, wallet, winningRank);
        yieldCalculateService.calculateRateOfReturn();
    }

    private void createRandomLottos(Wallet wallet, RandomLottos randomLottos) {
        TicketCalculator ticketCalculator = new TicketCalculatorImpl();
        randomLottoMarket = new RandomLottoMarket(ticketCalculator, randomLottos, wallet);
        randomLottoMarket.createRandomLottos();
    }


    private UserLotto createUserLotto() {
        UserLotto.Builder builder = new UserLotto.Builder();
        inputUserMainSixLottoBuilder(builder);
        inputUserBonusLottoBuilder(builder);

        return builder.build();
    }

    private void inputUserMainSixLottoBuilder(UserLotto.Builder builder) {
        UserSixLottoFactory factory = new UserSixLottoFactory();

        while (true) {
            try {
                builder.mainLotto(factory.make(Input.inputMainSixLotto()));
                break;
            } catch (IllegalArgumentException e) {
                Output.printError(e.getMessage());
            }
        }
    }

    private void inputUserBonusLottoBuilder(UserLotto.Builder builder) {
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
