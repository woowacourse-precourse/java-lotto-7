package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        int price = Integer.parseInt(Console.readLine());
        if (price % 1000 != 0)
            System.out.println("천원단위만 입력하세요");

        int total = price / 1000;

        LottoList lottoList = new LottoList(total);

        System.out.println(lottoList.getLottoList().size());
        for (Lotto lotto : lottoList.getLottoList()) {
            System.out.println(lotto.getNumbers());
        }

        String input = Console.readLine();
        List<Integer> WinningNumber = getLottoWinningNumber(input);
        int bonusNumber = getBonusNumber();
    }

    private static int getBonusNumber() {
        return Integer.parseInt(Console.readLine());
    }

    private static List<Integer> getLottoWinningNumber(String input) {
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .toList();
    }
}
