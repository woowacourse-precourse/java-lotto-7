package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {

    private final static int TICKET_PRICE = 1000;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("구입금액을 입력해 주세요.");

        int price = Integer.parseInt(Console.readLine());
        List<Lotto> lottos = manyGenerators(price, TICKET_PRICE);
        printLotto(lottos);

        System.out.println("당첨 번호를 입력해 주세요.");
        Lotto targetLotto = LottoGenerator.generate(Console.readLine(), ",");

        System.out.println("보너스 번호를 입력해 주세요.");

        System.out.println("입력한 로또: " + targetLotto);

        System.out.println();
    }

    public static List<Lotto> manyGenerators(int totalprice, int ticketPrice){
        if(totalprice % ticketPrice != 0){
            throw new IllegalArgumentException("[ERROR]: " + ticketPrice + "에 나눠 떨어지지 않습니다.");
        }

        List<Lotto> lottos = new ArrayList<>();
        while(totalprice != 0){
            lottos.add(LottoGenerator.generateRandom());
            totalprice -= 1000;
        }

        return lottos;
    }

    public static void printLotto(List<Lotto> lottos){
        System.out.println(lottos.size());

        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }
}
