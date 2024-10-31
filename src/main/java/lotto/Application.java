package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {

    private final static int TICKET_PRICE = 1000;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int price = inputPrice();

        System.out.println();

        List<Lotto> lottos = manyGenerators(price, TICKET_PRICE);
        printLotto(lottos);

        System.out.println();
        Lotto targetLotto = inputTargetLottoNumber();

        System.out.println();
        inputBonusNumber(targetLotto);

        successStaticsPrint(lottos, targetLotto);
    }

    private static int inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");

        int price = Integer.parseInt(Console.readLine());
        return price;
    }

    private static Lotto inputTargetLottoNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        Lotto targetLotto = LottoGenerator.generate(Console.readLine(), ",");
        return targetLotto;
    }

    private static void inputBonusNumber(Lotto targetLotto) {
        System.out.println("보너스 번호를 입력해 주세요.");
        LottoGenerator.addNumber(targetLotto, Integer.parseInt(Console.readLine()));
    }

    private static void successStaticsPrint(List<Lotto> lottos, Lotto targetLotto) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(Grade.THREECOINSIDE + "" + congratulation(lottos, targetLotto, 3) + "개");
        System.out.println(Grade.FOURCOINSIDE + "" + congratulation(lottos, targetLotto, 4) + "개");
        System.out.println(Grade.FIVECOINSIDE + "" + congratulation(lottos, targetLotto, 5) + "개");
        System.out.println(Grade.FIVECOINSIDE_BONUS + "" + congratulation(lottos, targetLotto, 5, true) + "개");
        System.out.println(Grade.SIXCOINSIDE + "" + congratulation(lottos, targetLotto, 6) + "개");
        System.out.println();
    }

    public static List<Lotto> manyGenerators(int totalprice, int ticketPrice) {
        if (totalprice % ticketPrice != 0) {
            throw new IllegalArgumentException("[ERROR]: " + ticketPrice + "에 나눠 떨어지지 않습니다.");
        }

        List<Lotto> lottos = new ArrayList<>();
        int count = 0;
        while (totalprice != 0) {
            count++;
            lottos.add(LottoGenerator.generateRandom());
            totalprice -= ticketPrice;
        }

        return lottos;
    }

    public static void printLotto(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");

        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static int congratulation(List<Lotto> lottos, Lotto targetLotto, int matchTarget) {
        boolean b = false;
        return congratulation(lottos, targetLotto, matchTarget, b);
    }

    public static int congratulation(List<Lotto> lottos, Lotto targetLotto, int matchTarget, boolean b) {
        int matchCount = 0;
        for (Lotto lotto : lottos) {
            matchCount = getMatchCount(targetLotto, matchTarget, lotto, matchCount, b);
        }

        return matchCount;
    }

    private static int getMatchCount(Lotto targetLotto, int matchTarget, Lotto lotto, int matchCount,
                                     boolean checkBonus) {
        int matchValue = 0;
        if (checkBonus && lotto.getNumbers().contains(targetLotto.getBonus())) {
            return returnMatchCount(targetLotto, matchTarget, lotto, matchCount, matchValue);
        }
        if (!checkBonus && lotto.getNumbers().contains(targetLotto.getBonus()) && matchTarget == 5) {
            return 0;
        }
        return returnMatchCount(targetLotto, matchTarget, lotto, matchCount, matchValue);
    }

    private static int returnMatchCount(Lotto targetLotto, int matchTarget, Lotto lotto, int matchCount,
                                        int matchValue) {
        for (Integer number : lotto.getNumbers()) {
            matchValue = getMatchValue(targetLotto, number, matchValue);
        }
        if (matchTarget == matchValue) {
            matchCount++;
        }
        return matchCount;
    }

    private static int getMatchValue(Lotto targetLotto, Integer number, int matchValue) {
        if (targetLotto.getNumbers().contains(number)) {
            matchValue++;
        }

        return matchValue;
    }

}



