package lotto;

import java.util.List;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class ConsoleView implements LottoView {
    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    @Override
    public String getInput(String prompt) {
        System.out.println(prompt);
        return readLine();
    }

    @Override
    public void displayResults(List<List<Integer>> lottoNumbers, List<Integer> winningNumbers, List<Integer> bonusNumbers, double profit) {
        System.out.println("당첨 통계\n---");
        for (List<Integer> numbers : lottoNumbers) {
            System.out.println(numbers);  // 각 로또 번호 출력
        }
        System.out.printf("%d개 일치 (%,d원) - %d개%n", 3, 5000, 0);
        System.out.printf("%d개 일치 (%,d원) - %d개%n", 4, 50000, 0);
        System.out.printf("%d개 일치 (%,d원) - %d개%n", 5, 1500000, 0);
        System.out.printf("%d개 일치, 보너스 볼 일치 (%,d원) - %d개%n", 5, 30000000, 0);
        System.out.printf("%d개 일치 (%,d원) - %d개%n", 6, 2000000000, 0);
        System.out.printf("총 수익률은 %, .2f%%입니다.%n", profit);
    }
}
