package lotto.model;

public enum LottoResult {
    FIFTH("3개 일치", 5000, 3), FOURTH("4개 일치",50000, 4),
    THIRD("5개 일치",1500000, 5), SECOND("5개 일치, 보너스 볼 일치", 30000000, 5),
    FIRST("6개 일치",2000000000, 6), NONE("3개 미만 일치", 0, 0);

    private final Integer price;
    private final String result;
    private final Integer count;

    LottoResult(String result, Integer price, Integer count)  {
        this.result = result;
        this.price = price;
        this.count = count;
    }

    public String getResult(){
        return result;
    }

    public Integer getPrice(){
        return price;
    }

    public Integer getCount(){
        return count;
    }
}
