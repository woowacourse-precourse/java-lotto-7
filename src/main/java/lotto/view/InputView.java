package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String PURCHASE_MESSAGE = "\n구입금액을 입력해 주세요.";
    public static final String WINNING_LOTTO_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_MESSAGE = "\n보너스 번호를 입력해 주세요.";

    public int getLottoCost() {
        while (true) {
            try {
                System.out.println(PURCHASE_MESSAGE);
                int cost = Integer.parseInt(Console.readLine());

                if (cost % 1000 != 0) {
                    throw new IllegalArgumentException("[ERROR] 천원 단위로 입력하세요");
                }

                return cost; // 올바른 값이면 반환
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // 에러 메시지 출력
            }
        }
    }

    public String getWinningLotto() {
        System.out.println(WINNING_LOTTO_MESSAGE);
        return Console.readLine();
    }

    public int getBonusNumber() {
        System.out.println(BONUS_MESSAGE);
        return Integer.parseInt(Console.readLine());
    }
}
