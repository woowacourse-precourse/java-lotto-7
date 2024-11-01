package lotto.controller;

import lotto.domain.Wallet;
import lotto.domain.calculators.TicketCalculator;
import lotto.domain.calculators.TicketCalculatorImpl;
import lotto.domain.calculators.YieldCalculator;
import lotto.domain.factory.UserMainLottoFactory;
import lotto.domain.lottos.RandomLottos;
import lotto.domain.lottos.user.UserLotto;
import lotto.domain.lottos.user.WinningLotto;
import lotto.domain.number.NumbersMaker;
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
        Output.printPurchasedLottoList(wallet, randomLottos); //note 사용자 입력 받기 전 출력을 한번 해야하기 때문에 빈 List<lotto> 생성x

        UserLotto userLotto = createUserLotto();
        WinningLotto winningLotto = new WinningLotto();

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

    private RandomLottos createRandomLottos(Wallet wallet) {
        TicketCalculator ticketCalculator = new TicketCalculatorImpl();
        NumbersMaker numbersMaker = new RandomLottoNumberMaker();
        randomLottoMarket = new RandomLottoMarket(ticketCalculator, numbersMaker, wallet);
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
        while (true) {
            try {
                return new Wallet(Input.inputPurchaseAmount());
            } catch (IllegalArgumentException e) {
                Output.printError(e.getMessage());
            }
        }
    }

}
