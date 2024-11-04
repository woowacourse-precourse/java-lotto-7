package lotto;

import static lotto.CorrectStatus.findByMatchCountAndSpecialNumber;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import lotto.handler.InputHandler;
import lotto.handler.OutputHandler;

public class LottoVendingMachine {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public LottoVendingMachine(){
        this.inputHandler = new InputHandler();
        this.outputHandler = new OutputHandler();
    }

    public void vend(){

        PurchaseAmount purchaseAmount = inputHandler.inputPurChaseAmount();
        List<Lotto> purchasedLottos = makeLottos(purchaseAmount.getTicket());
        outputHandler.printPurchasedLotto(purchaseAmount.getTicket(),purchasedLottos);

        WinningLottoNumberSelector winningLottoNumberSelector = getWinningLottoNumberSelector(purchasedLottos);
        LottoResult lottoResult = new LottoResult();
        lottoResult.adjustLottoResult(winningLottoNumberSelector);

        outputHandler.printWinningStatics(lottoResult.winningStatistics);
        outputHandler.printProfitRate(lottoResult.profit(),purchaseAmount.getMoney());

    }

    private WinningLottoNumberSelector getWinningLottoNumberSelector(final List<Lotto> purchasedLottos){

        WinningNumber winningNumber = inputHandler.inputWinningLottoNumber();

        return new WinningLottoNumberSelector(winningNumber,purchasedLottos);
    }

    private List<Lotto> makeLottos(int ticket){

        return IntStream.range(0, ticket)
                .mapToObj(i -> Lotto.createRandomLotto())
                .toList();
    }



}
