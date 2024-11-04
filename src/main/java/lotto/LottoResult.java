package lotto;

import LottoEnum.LottoEnum;

public class LottoResult {
    private int three=0,four=0,five=0,six=0,bonus=0;

    public void addResult(int winCount, boolean isBonus){
        if(winCount < 3)
            return ;
        if(winCount == 3){
            three++; return;}
        if(winCount == 4){
            four++; return;}
        if(winCount == 5){
            if(isBonus) {
                bonus++; return;
            }
            five++; return;
        }
        if(winCount == 6)
            six++;
    }

    @Override
    public String toString(){
        String resultFormatWithPrice = LottoEnum.getResultFormat();
        String resultWithNumber = String.format(resultFormatWithPrice, three, four, five, bonus, six);
        return resultWithNumber;
    }

    public int getTotalWinnings(){
        return three*LottoEnum.THREE.getPrice() + four*LottoEnum.FOUR.getPrice() + five*LottoEnum.FIVE.getPrice() + bonus*LottoEnum.BONUS.getPrice() + six * LottoEnum.SIX.getPrice();
    }
}
