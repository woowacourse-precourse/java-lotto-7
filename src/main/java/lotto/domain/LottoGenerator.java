package lotto.domain;

public class LottoGenerator {
    private int money;

    private LottoGenerator(int money){
        validateMoney(money);
        this.money=money;
    }

    public static LottoGenerator of(int money){
        return new LottoGenerator(money);
    }

    private void validateMoney(int money){
        if(money<0){
            throw new IllegalArgumentException("로또 구매 금액은 음수가 될 수 없습니다.");
        }

        if(money==0 || money%1000!=0){
            throw new IllegalArgumentException("로또 구매 금액은 1,000원 단위가 되어야 합니다.");
        }
    }

    public int getMoney(){
        return money;
    }

}
