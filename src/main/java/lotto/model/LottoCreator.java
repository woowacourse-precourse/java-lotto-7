package lotto.model;

public class LottoCreator {
    private static final int LOTTO_PRICE = 1000;
    public static final int INITIAL_NUMBER_OF_LOTTO=0;

    public int chooseNumberOfLotto(int purchasePrice){
        int numberOfLotto=INITIAL_NUMBER_OF_LOTTO;
        whetherPossiblePurchasePrice(purchasePrice);
        numberOfLotto = purchasePrice/LOTTO_PRICE;
        return numberOfLotto;
    }

    private void whetherPossiblePurchasePrice(int purchasePrice){
        if (purchasePrice <LOTTO_PRICE) {
            throw new IllegalArgumentException("\n[ERROR] 구입 금액은 "+String.format("%,d", LOTTO_PRICE)+"이상이여야 합니다.");
        }
        else if(purchasePrice%LOTTO_PRICE!=INITIAL_NUMBER_OF_LOTTO){
            throw new IllegalArgumentException("\n[ERROR] 구입 금액은 "+String.format("%,d", LOTTO_PRICE)+"원으로 나누어 떨어져야합니다.");
        }
    }

}
