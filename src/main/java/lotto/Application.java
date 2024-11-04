package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lotto.Lotto;

public class Application {
    public static void main(String[] args) {
        int buget;
        List<Lotto> severalLottos = new ArrayList<>();
        int lottoCount;
        int bunusNumber;
        String winningNumbers;

        System.out.println("구입금액을 입력해 주세요.");
        buget = Integer.parseInt(Console.readLine());
        System.out.println();

        lottoCount = buget / 1000;

        for (int i = 0; i < lottoCount; i++) {
            severalLottos.add(new Lotto());
        }
        System.out.println(lottoCount + "개를 구매했습니다.");
        for (int i = 0; i < lottoCount; i++) {
            System.out.println(severalLottos.get(i).getNumbers());
        }

        System.out.println("\n당첨 번호를 입력해 주세요.");
        winningNumbers = Console.readLine();

        Console.close();// TODO: 프로그램 구현
    }
}
