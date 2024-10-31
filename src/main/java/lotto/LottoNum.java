package lotto;

public class LottoNum {
    public LottoNum(int money){
        if(money % 1000 != 0){
            throw new IllegalArgumentException("1000원으로 나누어 떨어지지 않습니다.");
        }
    }
}
