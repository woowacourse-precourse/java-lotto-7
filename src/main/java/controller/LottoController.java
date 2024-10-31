package controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.Prize;
import view.InputHandler;
import view.OutputHandler;

import java.sql.Array;
import java.util.*;

public class LottoController {
    private InputHandler inputHandler;
    private OutputHandler outputHandler;
    public LottoController() {
        this.inputHandler = new InputHandler();
        this.outputHandler = new OutputHandler();
    }

    public void run(){
        List<Lotto> lottos = new ArrayList<>();
        EnumMap<Prize, Integer> prizeCount = new EnumMap<>(Prize.class);
        for (Prize prize : Prize.values()){
            prizeCount.put(prize, 0);
        }


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
        List<Integer> lottoNumbers = inputHandler.getLottoNumber();
        Lotto winningLottoNumber = new Lotto(lottoNumbers);
        outputHandler.promptForBonusNumber();
        int bonusNumber = inputHandler.getBonusNumber(lottoNumbers);


        for(Lotto lotto : lottos){
            int matchCount = lotto.compareTo(winningLottoNumber);

            for(Prize prize : Prize.values()){
                if(matchCount == prize.getRanking()){
                    if(lotto.hasBonusNumber(bonusNumber) && prize.equals(Prize.THIRD)){
                       continue;
                    }

                    prizeCount.put(prize,prizeCount.get(prize) + 1);
                }
            }
        }
        outputHandler.displayPrizes(prizeCount);
        outputHandler.displayWinningRate(calculateWinningRate(prizeCount, amountInput));
    }

    private double calculateWinningRate(EnumMap<Prize, Integer> prizeCount, int amountInput){
        int winningRate = 0;
        for(Prize prize : prizeCount.keySet()){
            winningRate += (int)(prize.getPrizeMoney() * prizeCount.get(prize));
        }
        return (double) winningRate /amountInput * 100;
    }
}
