package lotto;

import static lotto.InputUtil.checkInputIsNotInNumbers;
import static lotto.InputUtil.checkOverThanMinAndLessThanMax;
import static lotto.InputUtil.isClearedByNum;
import static lotto.InputUtil.isNumeric;
import static lotto.InputUtil.isNumericWithCommas;
import static lotto.InputUtil.splitByComma;
import static lotto.Lotto.LOTTO_BASIC_PRICE;
import static lotto.Lotto.LOTTO_MAX_NUM;
import static lotto.Lotto.LOTTO_MIN_NUM;
import static lotto.Lotto.checkLotto;
import static lotto.Lotto.makeRandomLotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

    public static final String WINNING_NUMBERS_NAME = "당첨 번호";

    public static void main(String[] args) {

        // 구입 금액 입력 받고 유효성 검사
        int purchasesCount;
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.\n");
                String price = Console.readLine();

                isNumeric(price);
                isClearedByNum(price, LOTTO_BASIC_PRICE); // 구입금액이 1000원 단위인지 확인

                purchasesCount = Integer.parseInt(price) / LOTTO_BASIC_PRICE;
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("잘못된 입력입니다. 다시 입력해 주세요\n 예외 메세지: " + e.getMessage());
            }
        }

        // 구매 개수 출력
        System.out.println(purchasesCount + "개를 구매했습니다.\n");

        // 구매한 로또 발행
        List<Lotto> purchases = new ArrayList<>();
        for (int i = 0; i < purchasesCount; i++) {
            purchases.add(makeRandomLotto());
            System.out.println(purchases.get(i).getNumbers());
        }

        // 당첨 로또 번호 입력 받기
        Lotto winningLotto;
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.\n");
                String winningNumbers = Console.readLine();

                isNumericWithCommas(winningNumbers);

                // 당첨 번호로 로또 만들기
                winningLotto = new Lotto(splitByComma(winningNumbers));
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("잘못된 입력입니다. 다시 입력해 주세요\n 예외 메세지: " + e.getMessage());
            }
        }

        int bonusNumber;
        // 보너스 번호 입력 받기
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.\n");
                String enteredBonusNumber = Console.readLine();

                isNumeric(enteredBonusNumber);
                checkOverThanMinAndLessThanMax(Integer.parseInt(enteredBonusNumber), LOTTO_MIN_NUM,
                        LOTTO_MAX_NUM);
                checkInputIsNotInNumbers(winningLotto.getNumbers(), enteredBonusNumber,
                        WINNING_NUMBERS_NAME);

                bonusNumber = Integer.parseInt(enteredBonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("잘못된 입력입니다. 다시 입력해 주세요\n 예외 메세지: " + e.getMessage());
            }
        }

        ArrayList<Integer> statics = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0));

        // 당첨 내역 출력
        for (Lotto lotto : purchases) {
            int result = checkLotto(lotto.getNumbers(), winningLotto.getNumbers(), bonusNumber);
            if (result >= 0 && result < 5) {
                statics.set(result, statics.get(result) + 1);
            }
        }

        System.out.println("3개 일치 (5,000원) - " + statics.get(0) + "개");
        System.out.println("4개 일치 (50,000원) - " + statics.get(1) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + statics.get(2) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + statics.get(3) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + statics.get(4) + "개");

    }

}
