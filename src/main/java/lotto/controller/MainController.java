package lotto.controller;

import java.util.EnumMap;
import java.util.Map;
import lotto.domain.Rank;
import lotto.domain.Wallet;
import lotto.domain.factory.RandomLottoFactory;
import lotto.domain.factory.RandomLottoMachine;
import lotto.domain.factory.UserMainLottoFactory;
import lotto.domain.lottos.Lotto;
import lotto.domain.lottos.RandomLottos;
import lotto.domain.lottos.user.BonusLotto;
import lotto.domain.lottos.user.UserLotto;
import lotto.domain.lottos.user.WinningLottos;
import lotto.domain.number.NumbersMaker;
import lotto.domain.number.RandomLottoNumberMaker;
import lotto.service.LottoMatchService;
import lotto.service.YieldCalculateService;
import lotto.view.Input;
import lotto.view.Output;

/**
 * 구매 내역 출력
 *
 */
public class MainController {
    private LottoMatchService lottoMatchService;
    private YieldCalculateService yieldCalculateService;

    public void run(){
        Wallet wallet = createWallet();
        RandomLottos randomLottos = createRandomLottos(wallet);

        Output.printPurchasedLottoList(wallet, randomLottos);

        UserLotto userLotto = createUserLotto();
        WinningLottos winningLottos = new WinningLottos();

        lottoMatchService = new LottoMatchService(randomLottos,userLotto,winningLottos);
        lottoMatchService.matchLottos();
        yieldCalculateService = new YieldCalculateService(wallet,winningLottos);
        yieldCalculateService.calculateYield();


        Output.printLottoWinningStatistics(winningLottos);
        Output.printRateOfReturn(wallet);

    }



    private UserLotto createUserLotto(){
        while (true){
            try{
                return new UserLotto(createUserSixMainLotto(),createBonusLotto());
            }catch (IllegalArgumentException e){
                Output.printError(e.getMessage());
            }
        }
    }

    private BonusLotto createBonusLotto() {
        return new BonusLotto(Input.inputBonusLotto());
    }

    private Lotto createUserSixMainLotto(){
        UserMainLottoFactory factory = new UserMainLottoFactory();
        return factory.make(Input.inputMainSixLotto());
    }

    private RandomLottos createRandomLottos(Wallet wallet) {
        NumbersMaker numbersMaker = new RandomLottoNumberMaker(); //6자리 숫자를 만듦
        RandomLottoMachine randomLottoMachine = new RandomLottoMachine(numbersMaker,wallet); //List<Lotto>만듦
        RandomLottoFactory randomLottoFactory = new RandomLottoFactory(randomLottoMachine); //RandomLotto 객체를 만듦

        return randomLottoFactory.make();
    }

    private Wallet createWallet() {
        while (true){
            try{
                return new Wallet(Input.inputPurchaseAmount());
            }catch (IllegalArgumentException e){
                Output.printError(e.getMessage());
            }
        }
    }


}
