package LottoEnum;

public enum LottoEnum {
    THREE(5000),
    FOUR(50000),
    FIVE(1500000),
    BONUS(30000000),
    SIX(2000000000);

    private int lottoPrice;
    private static final String RESULTFORMAT =
            "3개 일치 (%,d원) - %%d개\n" +
                    "4개 일치 (%,d원) - %%d개\n" +
                    "5개 일치 (%,d원) - %%d개\n" +
                    "5개 일치, 보너스 볼 일치 (%,d원) - %%d개\n" +
                    "6개 일치 (%,d원) - %%d개";

    LottoEnum( int price) {
        this.lottoPrice = price;
    }
    public int getPrice(){
        return lottoPrice;
    }

    public static String getResultFormat(){
        return String.format(RESULTFORMAT, THREE.getPrice(), FOUR.getPrice(), FIVE.getPrice(), BONUS.getPrice(), SIX.getPrice());
    }
}
