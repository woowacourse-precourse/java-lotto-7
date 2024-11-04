package lotto;

public class OutputHandler {

    public static void printLottoCount(long lottoCount) {
        System.out.printf("%d개를 구매했습니다.%n", lottoCount);
    }

    public static void printLotto(Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }

    public static void printResult(User user) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Price price : Price.values()) {
            if (price == Price.SIXTH) {
                continue;
            }
            long count = user.getPrices().stream().filter(it -> (it == price)).count();
            if(price == Price.SECOND) {
                System.out.printf("%d개 일치, 보너스 볼 일치 (%,d원) - %d개%n",
                        price.getMatching(), price.getPriceMoney(), count);
            }
            System.out.printf("%d개 일치 (%,d원) - %d개%n",
                    price.getMatching(), price.getPriceMoney(), count);
        }
        System.out.printf("총 수익률은 %.1f%%입니다.%n", user.getReturns());
    }
}
