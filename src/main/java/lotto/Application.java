package lotto;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static final String CREDIT_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String NOT_MULTIPLE_1000 = "[ERROR] 구입 금액은 1,000의 배수여야 합니다.";
    public static final String WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static int pieces;
    public static List<Lotto> lottos = new ArrayList<>();
    public static List<Integer> winningNumbers = new ArrayList<>();
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println(CREDIT_MESSAGE);
        int credit = Integer.parseInt(Console.readLine());
        try {
            pieces = checkCredit(credit);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println(CREDIT_MESSAGE);
            int newCredit = Integer.parseInt(Console.readLine());
            pieces = checkCredit(newCredit);
        }
        System.out.println(pieces + "개를 구매했습니다.");
        publishLotto();
        for(Lotto lotto : lottos) {
            printLottos(lotto);
        }
        System.out.println(WINNING_NUMBER_MESSAGE);
        getWinningNumbers(Console.readLine());
    }

    public static int checkCredit(int credit) throws IllegalArgumentException {
        if (credit % 1000 != 0) {
            throw new IllegalArgumentException(NOT_MULTIPLE_1000);
        }
        return credit / 1000;
    }

    public static void publishLotto() throws IllegalArgumentException {
        for(int i=0; i<pieces; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
    }

    public static void printLottos(Lotto lotto) {
        String lottoNumber = "[";
        List<Integer> numbers = lotto.getNumbers();
        for(int number : numbers) {
            lottoNumber += number + ",";
        }
        lottoNumber = lottoNumber.substring(0,lottoNumber.length() - 1);
        lottoNumber += "]";
        System.out.println(lottoNumber);
    }

    public static void getWinningNumbers(String input) {
        String[] winningNumbersString = input.split(",");
        for(String number : winningNumbersString) {
            winningNumbers.add(Integer.parseInt(number));
        }
    }
}
