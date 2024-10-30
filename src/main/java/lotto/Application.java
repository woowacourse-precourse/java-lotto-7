package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        int price = Integer.parseInt(Console.readLine());
        if (price % 1000 != 0)
            System.out.println("[ERROR] 로또 금액은 천원 단위로 입력할 수 있습니다.");

        int total = price / 1000;

        LottoList lottoList = new LottoList(total);

        System.out.println(lottoList.getLottoList().size());
        for (Lotto lotto : lottoList.getLottoList()) {
            System.out.println(lotto.getNumbers());
        }

        String input = Console.readLine();
        List<Integer> WinningNumber = InputHandler.getLottoWinningNumber(input);
        String input2 = Console.readLine();

        int bonusNumber = InputHandler.getBonusNumber(input2,WinningNumber);

    }
}
