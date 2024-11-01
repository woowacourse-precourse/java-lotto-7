package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {

    private final static int TICKET_PRICE = 1000;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        lottoGameStart();

    }

    private static void lottoGameStart() {
        int price;
        List<Lotto> lottos = buyLottos();
        printLotto(lottos);

        System.out.println();
        Lotto targetLotto = inputTargetLotto();

        System.out.println();

        inputBonusNumber(targetLotto);

        successStaticsPrint(lottos, targetLotto);

        getRateOfReturn(lottos, targetLotto);
    }

    private static Lotto inputTargetLotto() {
        Lotto targetLotto;
        try {
            targetLotto = inputTargetLottoNumber();
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputTargetLotto();
        }
        return targetLotto;
    }

    public static List<Lotto> buyLottos() {
        List<Lotto> lottos;
        try {
            int price;
            price = inputPrice();
            System.out.println();
            lottos = manyGenerators(price, TICKET_PRICE);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return buyLottos();
        }
        return lottos;
    }

    private static int inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        int price;
        try {
            price = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR]: 숫자를 입력해 주세요.");
        }
        return price;
    }

    public static Lotto inputTargetLottoNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        Lotto targetLotto;
        try {
            targetLotto = LottoGenerator.generate(Console.readLine(), ",");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR]: 로또(n,n,n,n,n,n)형태의 값을 입력해 주세요.");
        }
        return targetLotto;
    }

    private static void inputBonusNumber(Lotto targetLotto) {
        System.out.println("보너스 번호를 입력해 주세요.");
        try {
            getBonusNumber(targetLotto);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            inputBonusNumber(targetLotto);
        }
    }

    private static void getBonusNumber(Lotto targetLotto) {
        try{
            LottoGenerator.addNumber(targetLotto, Integer.parseInt(Console.readLine()));
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR]: 숫자를 입력해 주세요.");
        }
    }

    private static void successStaticsPrint(List<Lotto> lottos, Lotto targetLotto) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(Grade.THREECOINSIDE + "" + checkLotto(lottos, targetLotto, 3) + "개");
        System.out.println(Grade.FOURCOINSIDE + "" + checkLotto(lottos, targetLotto, 4) + "개");
        System.out.println(Grade.FIVECOINSIDE + "" + checkLotto(lottos, targetLotto, 5) + "개");
        System.out.println(Grade.FIVECOINSIDE_BONUS + "" + checkLotto(lottos, targetLotto, 5, true) + "개");
        System.out.println(Grade.SIXCOINSIDE + "" + checkLotto(lottos, targetLotto, 6) + "개");
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

    public static int checkLotto(List<Lotto> lottos, Lotto targetLotto, int matchTarget) {
        boolean b = false;
        return checkLotto(lottos, targetLotto, matchTarget, b);
    }

    public static int checkLotto(List<Lotto> lottos, Lotto targetLotto, int matchTarget, boolean b) {
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

    private static void getRateOfReturn(List<Lotto> lottos, Lotto targetLotto) {
        int count = lottos.size();
        Long totalPrice = Grade.THREECOINSIDE.getPrice() * checkLotto(lottos, targetLotto, 3);
        totalPrice += Grade.FOURCOINSIDE.getPrice() * checkLotto(lottos, targetLotto, 4);
        totalPrice += Grade.FIVECOINSIDE.getPrice() * checkLotto(lottos, targetLotto, 5);
        totalPrice += Grade.FIVECOINSIDE_BONUS.getPrice() * checkLotto(lottos, targetLotto, 5, true);
        totalPrice += Grade.SIXCOINSIDE.getPrice() * checkLotto(lottos, targetLotto, 6);
        System.out.println(totalPrice);
        System.out.println(count * TICKET_PRICE);
        double rateOfReturn = (double) totalPrice / (count * TICKET_PRICE) * 100.0;
        System.out.println("총 수익률은 " + Math.round((rateOfReturn) * 100) / 100.0 + "%입니다.");
    }
}



