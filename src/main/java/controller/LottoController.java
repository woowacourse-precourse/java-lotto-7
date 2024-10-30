package controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import view.InputHandler;
import view.OutputHandler;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoController {
    private InputHandler inputHandler;
    private OutputHandler outputHandler;
    public LottoController() {
        this.inputHandler = new InputHandler();
        this.outputHandler = new OutputHandler();
    }

    public void run(){
        List<Lotto> lottos = new ArrayList<>();
        Map<Integer, Integer> prizes = new HashMap<>(Map.of(
                0, 0,
                1, 0,
                2, 0,
                3, 0,
                4, 0,
                5, 0,
                6, 0,
                7, 0
        ));
        outputHandler.promptForAmountInput();
        int amountInput = inputHandler.getAmountInput();
        int count = amountInput / 1000;
        outputHandler.displayPurchasedLottoCount(count);
        for(int i = 0; i < count; i++){
            Lotto lotto =  new Lotto(Randoms.pickUniqueNumbersInRange(1,45,6));
            lottos.add(lotto);
            System.out.println(lotto.showNumbers()); //로또 번호는 오름차순이여야함
        }

        outputHandler.promptForLottoNumber();
        List<Integer> lottoNumber = inputHandler.getLottoNumber();
        Lotto winningLotto = new Lotto(lottoNumber);
        outputHandler.promptForBonusNumber();
        int bonusNumber = inputHandler.getBonusNumber();

        for(Lotto lotto : lottos){
            int winningCount = lotto.compareTo(winningLotto);

            if(winningCount == 5 && lotto.hasBonusNumber(bonusNumber)){
                int winningLottoWithBonus = prizes.get(7);
                prizes.put(7, ++winningLottoWithBonus);
                continue;
            }
            int winningLottoCount  = prizes.get(winningCount);
            prizes.put(winningCount, ++winningLottoCount);

        }
        outputHandler.displayPrizes(prizes);


    }
}
