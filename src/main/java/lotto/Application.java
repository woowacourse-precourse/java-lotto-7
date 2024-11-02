package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import lotto.Lotto;

public class Application {
    public static void main(String[] args) {
        List<Lotto> lottos = new ArrayList<>();
        int inputPrice = 0;
        int turn, bonusNumber;

        // 로또 구입금액 입력 받기
        System.out.println("구입금액을 입력해 주세요.");
        try {
            inputPrice = Integer.parseInt(Console.readLine());
        }catch(IllegalArgumentException e) {
            System.out.println("[ERROR] 구입금액은 숫자여야 합니다.");
        }

        // 구매 금액에서 로또 개수 세기
        if ((inputPrice % 1000) != 0) {
            System.out.println("[ERROR] 구입금액은 1000의 배수여야 합니다.");
        }
        turn = inputPrice / 1000;
        System.out.println(turn + "개를 구매했습니다.");

        // 구매 금액만큼 로또 생성
        for (int i = 0; i < turn; i++) {
            List<Integer> tempLotto = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(tempLotto);
            lottos.add(new Lotto(tempLotto));
            System.out.println(tempLotto.toString());
        }

        // 당첨 번호를 입력받기
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String[] inputNumbers = Console.readLine().split(",");
        List<Integer> winningNumbers = new ArrayList<>();
        for (String inputNumber : inputNumbers) {
            winningNumbers.add(Integer.parseInt(inputNumber));
        }

        // 보너스 번호를 입력받기
        System.out.println("\n보너스 번호를 입력해 주세요.");
        bonusNumber = Integer.parseInt(Console.readLine());

        // 당첨 통계 구하기
        System.out.println("\n당첨 통계\n---");
        int first = 0;
        int second = 0;
        int third = 0;
        int forth = 0;
        int fifth = 0;
        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            int correctNumber = 0;
            int bonusInLotto = 0;
            for (Integer number : numbers) {
                if (winningNumbers.contains(number)) {
                    correctNumber += 1;
                }
                if (bonusNumber == number) {
                    bonusInLotto += 1;
                }
            }

            if (correctNumber == 6){
                first += 1;
            } else if (correctNumber == 5){
                if (bonusNumber == 1) {
                    second += 1;
                } else {
                    third += 1;
                }
            } else if (correctNumber == 4) {
                forth += 1;
            } else if (correctNumber == 3){
                fifth += 1;
            }
        }
        System.out.println("3개 일치 (5,000원) - " + fifth + "개");
        System.out.println("4개 일치 (50,000원) - " + forth + "개");
        System.out.println("5개 일치 (1,500,000원) - " + third + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + second + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + first + "개");
        int totalPrice = 5000 * fifth + 50000 * third + 1500000 * forth + 30000000 * second + 2000000000 * first;
        double returnPrice = Math.round((totalPrice / (double) inputPrice) * 1000) / 10.00;
        System.out.println("총 수익률은 " + returnPrice + "%입니다.");
    }
}
