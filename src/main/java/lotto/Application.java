package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoShop shop = new LottoShop();
        int insert = shop.insertMoney();
        List<Lotto> lottoes = shop.sell(insert);
        shop.printLottoes(lottoes);

        List<Integer> winNumbers = shop.winNumbers();
        int bonusNumber = shop.bonusNumber();

        System.out.println(shop.check(insert, winNumbers, bonusNumber, lottoes));
    }
}
