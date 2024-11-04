package lotto;

public class Amount {
    private static int amount;


    /*public Amount(int amount){
        this.amount = amount;
    }

    public Amount() {

    }*/

    //입력 값을 Long으로 변환
    private long toLong(String input){
        return Long.parseLong(input);
    }

    //money가 1000원 단위인지 확인
    private void validate(long money){
        if(money % 1000L !=0){
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }else if(money<1000){
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 이상이여야 합니다.");
        }
    }

    //long을 int로 변환
    private int toInt(long money){
        return Long.valueOf(money).intValue();
    }

    //amount에 money를 1000으로 나눈 값 저장
    private void toAmount(int money){
        this.amount = money/1000;
    }

    public Amount(String input){
        Long longMoney = toLong(input);
        validate(longMoney);
        int money = toInt(longMoney);
        toAmount(money);
    }

    public static int get(){
        return amount;
    }
}
