package lotto.model;

public class LottoVendingMachine {


    private void checkMoney(int money){
        if(money % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }
}
