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
    private Lotto answerLotto;
    private Integer bonusNumber;
    private Integer revenue;
    private Double myReturn;

    public MyInfo() {
        this.purchasePrice = 0;
        this.lottoCount = 0;
        this.myLottos = new ArrayList<>();
        this.answerLotto = null;
        this.bonusNumber = 0;
        this.revenue = 0;
        this.myReturn = 0.0;
    }

    //함수 길이 문제
    public void gainPurchaseAmount(){
        int purchasePrice = 0;
        try {
            OutputView.printPurchaseAmount();
            purchasePrice = InputView.readPurchaseAmount();
            this.countLotto(purchasePrice);
        }
        catch(IllegalArgumentException e){
            if(e.getMessage().equals(ErrorMessage.NOT_DIV.getError())){
                OutputView.printError(ErrorMessage.NOT_DIV.getError());
                gainPurchaseAmount();
                return;
            }
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

    public Lotto gainWinningInput(){
        Lotto answer;
        OutputView.printWinning();
        try {
            answer = InputView.readWinningNum();
        }
        catch (IllegalArgumentException e){
            OutputView.printError(ErrorMessage.WIN_INPUT.getError());
            return gainWinningInput();
        }
        OutputView.printBlank();
        return answer;
    }

    public int gainBonusInput(Lotto answer){
        int bonus = 0;
        OutputView.printBonus();
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

    public int gainMyRevenue(WinningDetails grades){
        int revenue = 0;
        revenue += grades.getThird() * 5000;
        revenue += grades.getFourth() * 50000;
        revenue += grades.getFifth() * 1500000;
        revenue += grades.getFifthBonus() * 30000000;
        revenue += grades.getSixth() * 2000000000;
        return revenue;
    }

    public double gainReturn(int purchasePrice, int revenue){
        double myReturn = (double)revenue / (double)purchasePrice * 100;
        return Math.round(myReturn * 100)/100.0;
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

    public Integer getBonusNumber(){
        return this.bonusNumber;
    }

    public Lotto getAnswerLotto(){
        return this.answerLotto;
    }

    public Integer getRevenue(){
        return this.revenue;
    }

    public Double getMyReturn(){
        return this.myReturn;
    }

    public void setMyLottos(List<Lotto> myLottos){
        this.myLottos = myLottos;
    }

    public void setAnswerLotto(Lotto answerLotto){
        this.answerLotto = answerLotto;
    }

    public void setBonusNumber(Integer bonusNumber){
        this.bonusNumber = bonusNumber;
    }

    public void setLottoCount(Integer lottoCount){
        this.lottoCount = lottoCount;
    }

    public void setMyReturn(Double myReturn){
        this.myReturn = myReturn;
    }

    public void setPurchasePrice(Integer purchasePrice){
        this.purchasePrice = purchasePrice;
    }

    public void setRevenue(Integer revenue){
        this.revenue = revenue;
    }
}
