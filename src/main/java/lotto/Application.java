package lotto;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        lottoController.strat();
        //LottoMachine lottoMachine = new LottoMachine(10);
        //System.out.println(lottoMachine.getLottoNumbers());
        //List<Integer> tt = List.of(1,2,3,4,5,6);

        //LottoDrawer lottoDrawer = new LottoDrawer(lottoMachine,tt,7);
        //System.out.println(lottoDrawer.getWinningCount());



    }
}
