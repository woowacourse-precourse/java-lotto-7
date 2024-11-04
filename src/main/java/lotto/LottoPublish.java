package lotto;

public class LottoPublish {
    private final int count; // 로또 개수

    public LottoPublish(int price) {
        validatePrice(price);
        count = calculateCount(price);

        System.out.println("[result] 구매한 로또개수: " + count);
    }

    // 로또 1장 가격 유효성 검사
    private void validatePrice(Integer price){
        if (price % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 1,000원 단위의 금액을 입력해주세요.");
        }
    }

    // 로또 발행 개수
    private int calculateCount(Integer price){
        return price/1000;
    }

    // getter 메서드
    public int getCount() {
        return count;
    }
}
