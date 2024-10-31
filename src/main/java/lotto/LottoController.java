package lotto;

public class LottoController {

    public void strat(){
        InputView inputView = new InputView();
        LottoStore lottoStore = new LottoStore(inputView);
        LottoMachine lottoMachine = new LottoMachine(lottoStore.getTickets());
        LottoDrawer lottoDrawer = new LottoDrawer(lottoMachine, lottoStore.getLottoNumbers(),7);
        lottoDrawer.getWinningCount();

    }

}
