package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ConfirmRankAndRate {

    private List<Lotto> purchasedLottos;
    private int purchaseAmount;
    private List<Integer> LottoWinningNumbers;
    private int bonusNumber;

    private int[] rankCount;
    private double rateOfReturn;

    public ConfirmRankAndRate() {

    }

    public void setPurchasedLottos(List<Lotto> inputData) {
           this.purchasedLottos=inputData;
    }

    public void setPurchaseAmount(int inputData) {
        this.purchaseAmount=inputData;
    }

    public void setLottoWinningNumbers(List<Integer> inputData) {
        this.LottoWinningNumbers=inputData;
    }

    public void setBonusNumber(int inputData) {
        this.bonusNumber=inputData;
    }

    public void setRankCount(int[] inputData) {
        this.rankCount=inputData;
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }

    public int[] getRankCount() {
        return rankCount;
    }

    public void countRankCount() {

        //인덱스 1에는 1등인 사람수 저장
        rankCount= new int[6];
        for(Lotto lotto : purchasedLottos) {
            if(check1st(lotto)) { rankCount[1]+=1; }
            if(check2st(lotto)) { rankCount[2]+=1; }
            if(check3st(lotto)) { rankCount[3]+=1; }
            if(check4st(lotto)) { rankCount[4]+=1; }
            if(check5st(lotto)) { rankCount[5]+=1; }

        }
    }

    public boolean check1st(Lotto lotto) {
        List<Integer> purchaseLottoNums=lotto.getNumbers();
        List<Integer> winningLottoNums=this.LottoWinningNumbers;
        int lottoNumSize=6;
        for(int i=0;i<lottoNumSize;i++) {
            if(purchaseLottoNums.get(i) !=winningLottoNums.get(i)) {
                return false;
            }
        }

        return true;
    }

    public boolean check2st(Lotto lotto) {
        List<Integer> purchaseLottoNums=lotto.getNumbers();
        List<Integer> winningLottoNums=this.LottoWinningNumbers;
        int lottoNumSize=6;
        int incorrectNum=0;
        boolean bonusNumCorrect=false;
        for(int i=0;i<lottoNumSize;i++) {
            if(purchaseLottoNums.get(i) !=winningLottoNums.get(i)) { incorrectNum+=1; }
            if(purchaseLottoNums.get(i) == bonusNumber) { bonusNumCorrect=true; }
        }
        if(bonusNumCorrect==true && incorrectNum==1) { return true; }
        return false;
    }

    public boolean check3st(Lotto lotto) {
        List<Integer> purchaseLottoNums=lotto.getNumbers();
        List<Integer> winningLottoNums=this.LottoWinningNumbers;
        int lottoNumSize=6;
        int incorrectNum=0;
        boolean bonusNumCorrect=false;
        for(int i=0;i<lottoNumSize;i++) {
            if(purchaseLottoNums.get(i) !=winningLottoNums.get(i)) { incorrectNum+=1; }
            if(purchaseLottoNums.get(i) == bonusNumber) { bonusNumCorrect=true; }
        }
        if(bonusNumCorrect==false && incorrectNum==1) { return true; }
        return false;
    }

    public boolean check4st(Lotto lotto) {
        List<Integer> purchaseLottoNums=lotto.getNumbers();
        List<Integer> winningLottoNums=this.LottoWinningNumbers;
        int lottoNumSize=6;
        int incorrectNum=0;
        boolean bonusNumCorrect=false;
        for(int i=0;i<lottoNumSize;i++) {
            if(purchaseLottoNums.get(i) !=winningLottoNums.get(i)) { incorrectNum+=1; }
        }
        if(incorrectNum==2) { return true; }
        return false;
    }

    public boolean check5st(Lotto lotto) {
        List<Integer> purchaseLottoNums=lotto.getNumbers();
        List<Integer> winningLottoNums=this.LottoWinningNumbers;
        int lottoNumSize=6;
        int incorrectNum=0;
        boolean bonusNumCorrect=false;
        for(int i=0;i<lottoNumSize;i++) {
            if(purchaseLottoNums.get(i) !=winningLottoNums.get(i)) { incorrectNum+=1; }
        }
        if(incorrectNum==3) { return true; }
        return false;
    }

    public void calRateOfReturn() {
        double totalPrice=0;
        totalPrice+=rankCount[1] *LottoRank.FIRST_PRICE.getValue();
        totalPrice+=rankCount[2] *LottoRank.SECOND_PRICE.getValue();
        totalPrice+=rankCount[3] *LottoRank.THIRD_PRICE.getValue();
        totalPrice+=rankCount[4] *LottoRank.FOURTH_PRICE.getValue();
        totalPrice+=rankCount[5] *LottoRank.FIFTH_PRICE.getValue();
        rateOfReturn=totalPrice/purchaseAmount;

    }
}
