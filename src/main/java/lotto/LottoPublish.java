package lotto;

import java.util.List;

public class LottoPublish {
    private final int count; // 로또 개수

    public LottoPublish(int price) {
        validatePrice(price);
        count = getCount(price);

        System.out.println("[debug] 구매한 로또개수: " + count);
    }

    // 로또 1장 가격 유효성 검사
    private void validatePrice(Integer price){
        if (price % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 1,000원 단위의 금액을 입력해주세요.");
        }
    }

    // 로또 발행 개수
    private int getCount(Integer price){
        return price/1000;
    }

}
