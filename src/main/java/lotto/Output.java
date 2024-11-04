package lotto;

public class Output {
    private static final String LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다.%n";

    public static void printLottos(Lottos lottos) {
        System.out.printf(LOTTO_COUNT_MESSAGE, lottos.getCount());
        System.out.println(lottos);
    }
}
