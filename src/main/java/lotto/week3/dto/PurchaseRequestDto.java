package lotto.week3.dto;

public class PurchaseRequestDto {

    private final int lottoCount;

    public  PurchaseRequestDto(int lottoCount) {
        int count = count(lottoCount);
        this.lottoCount = count;
    }

    private static int count(int cost) {
        if (cost % 1000 != 0) {
            throw new IllegalArgumentException("[error] 천원  단워로 입력 해주세요. ");
        }
        return cost % 1000;
    }

}
