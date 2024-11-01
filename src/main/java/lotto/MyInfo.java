package lotto;

import lotto.Messages.ErrorMessage;
import lotto.View.InputView;
import lotto.View.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MyInfo {

    private Integer purchasePrice;
    private Integer lottoCount;
    private List<Lotto> myLottos;

    public MyInfo() {
        this.purchasePrice = 0;
        this.lottoCount = 0;
        this.myLottos = new ArrayList<>();
    }

    public void gainPurchaseAmount(){
        int purchasePrice = 0;
        try {
            OutputView.printPurchaseAmount();
            purchasePrice = InputView.readPurchaseAmount();
            this.countLotto(purchasePrice);
        }
        catch(IllegalArgumentException e){
            OutputView.printError(ErrorMessage.ONLY_NUMBER.getError());
            gainPurchaseAmount();
        }
        this.purchasePrice = purchasePrice;
    }

    public void countLotto(Integer purchasePrice){
        int lottoCount = purchasePrice/1000;
        if (purchasePrice % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DIV.getError());
        }
        OutputView.printCount(lottoCount);
        OutputView.printBlank();
        this.lottoCount = lottoCount;
    }

    public Lotto getWinningInput(){
        OutputView.printWinning();
        Lotto answer;
        try {
            answer = InputView.readWinningNum();
        }
        catch (IllegalArgumentException e){
            OutputView.printError(ErrorMessage.WIN_INPUT.getError());
            return getWinningInput();
        }
        OutputView.printBlank();
        return answer;
    }

    public int gainBonusInput(Lotto answer){
        OutputView.printBonus();
        int bonus = 0;
        try{
            bonus  = InputView.readBonus(answer);
        }
        catch (IllegalArgumentException e){
            OutputView.printError(ErrorMessage.BONUS.getError());
            return gainBonusInput(answer);
        }
        OutputView.printBlank();
        return bonus;
    }

    public Integer getLottoCount(){
        return this.lottoCount;
    }

    public List<Lotto> getMyLottos(){
        return this.myLottos;
    }

    public Integer getPurchasePrice(){
        return this.purchasePrice;
    }
}
