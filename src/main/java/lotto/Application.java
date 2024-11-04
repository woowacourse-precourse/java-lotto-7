package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // 당첨 번호와 보너스 번호 입력받기
        System.out.println("당첨 번호를 입력하세요.(숫자는 쉼표(,) 기준으로 구분)");
        String input = readLine();
        List<Integer> winningNumbers = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Collections.sort(winningNumbers); // 당첨 번호 정렬

        System.out.println("보너스 번호를 입력하세요.");
        input = readLine();
        int bonusNumer = Integer.parseInt(input);
        WinningNumbers winningNumber = new WinningNumbers(winningNumbers, bonusNumer);

        // 로또 구입 금액 입력받기
        System.out.println("구입 금액을 입력해 주세요.");
        input = readLine();
        int numberOfLottos = buyLotto(Integer.parseInt(input));

        // 전체 로또 발행하기
        // 각각의 로또 숫자 뽑기
        List<Lotto> tickets = new ArrayList<>();

        for (int i = 0; i < numberOfLottos; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            Lotto lotto = new Lotto(numbers);
            tickets.add(lotto);
        }

        // 로또 출력하기
        System.out.println(numberOfLottos + "개를 구매했습니다.");
        for (Lotto ticket : tickets) {
            System.out.println(ticket);
        }

        // 당첨 확인하고 금액 계산하기
        LottoGame lottoGame = new LottoGame(tickets, winningNumber);
        lottoGame.calculateResults();

    }


    static public int buyLotto(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000으로 나눠떨어져야 합니다.");
        }

        int numberOfLottos = amount / 1000; // 로또 개수 계산

        return numberOfLottos;
    }
}
