package lotto;

import java.util.List;

public class MyLottos {
    List<Lotto> myLottos;
    static final int LOTTO_PRICE = 1000;

    public MyLottos(int buyingPrice) {
        LottoGenerator lottoGenerator = new LottoGenerator();
        int buyingAmount = buyingPrice / LOTTO_PRICE;
        myLottos = LottoGenerator.getLotto(buyingAmount);
        System.out.println(buyingAmount + "개를 구매했습니다.");
        myLottos.forEach(System.out::println);
    }

    public List<Lotto> getMyLottos() {
        return myLottos;
    }
}
