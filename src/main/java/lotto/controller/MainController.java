package lotto.controller;

import lotto.domain.Wallet;
import lotto.domain.factory.UserMainLottoFactory;
import lotto.domain.lottos.RandomLottos;
import lotto.domain.lottos.user.UserLotto;
import lotto.domain.lottos.user.WinningLottos;
import lotto.domain.number.NumbersMaker;
import lotto.domain.number.RandomLottoNumberMaker;
import lotto.service.LottoMatchService;
import lotto.service.RandomLottoFactory;
import lotto.service.YieldCalculateService;
import lotto.view.Input;
import lotto.view.Output;

/**
 * 구매 내역 출력
 */
public class MainController {
    private LottoMatchService lottoMatchService;
    private YieldCalculateService yieldCalculateService;

    public void run() {
        Wallet wallet = createWallet();
        wallet.buyTicket();
        RandomLottos randomLottos = createRandomLottos(wallet);

        Output.printPurchasedLottoList(wallet, randomLottos);

        UserLotto userLotto = createUserLotto();
        WinningLottos winningLottos = new WinningLottos();

        lottoMatchService = new LottoMatchService(randomLottos, userLotto, winningLottos);
        lottoMatchService.matchLottos();
        yieldCalculateService = new YieldCalculateService(wallet, winningLottos);
        yieldCalculateService.calculateYield();

        Output.printLottoWinningStatistics(winningLottos);
        Output.printRateOfReturn(wallet);

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

    private RandomLottos createRandomLottos(Wallet wallet) {
        NumbersMaker numbersMaker = new RandomLottoNumberMaker(); //6자리 숫자를 만듦
        RandomLottoFactory randomLottoFactory = new RandomLottoFactory(numbersMaker, wallet); //RandomLotto 객체를 만듦

        return randomLottoFactory.createRandomLottos();
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
