package lotto;

public class OutputHandler {

    public static void printLottoCount(long lottoCount) {
        System.out.printf("%d개를 구매했습니다.%n", lottoCount);
    }

    public static void printLotto(Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }
}
