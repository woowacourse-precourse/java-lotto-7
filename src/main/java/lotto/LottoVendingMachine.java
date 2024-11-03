package lotto;

import java.util.List;
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






    }

    private WinningLottoNumberSelector getWinningLottoNumber(){

        Lotto winningLotto = inputHandler.inputWinningLottoNumber();
        SpecialNumber specialNumber = inputHandler.inputSpecialNumber();

        return new WinningLottoNumberSelector(winningLotto,specialNumber);
    }

    private List<Lotto> makeLottos(int ticket){

        return IntStream.range(0, ticket)
                .mapToObj(i -> Lotto.createRandomLotto())
                .toList();
    }
}
