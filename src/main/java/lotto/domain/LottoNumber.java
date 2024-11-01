package lotto.domain;

public class LottoNumber {
    private final int number;
    public LottoNumber(int number){
        vaildateNumberRange(number);
        this.number=number;
    }
    private void vaildateNumberRange(int number){
        if(number <1 || number>45){
            throw new IllegalArgumentException("[ERROR] 번호는 1-45의 숫자여야 합니다.");
        }
    }

}
