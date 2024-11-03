package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine();

        readCost(lottoMachine);
        writeLottos(lottoMachine);
        readWinningNumbers(lottoMachine);
        readBonusNumber(lottoMachine);
        writeWinningResult(lottoMachine);
    }

    static void readCost(LottoMachine lottoMachine) {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            lottoMachine.buy(Integer.parseInt(Console.readLine()));
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 구입 금액은 숫자 형태여야 합니다.");
            readCost(lottoMachine);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            readCost(lottoMachine);
        }
        System.out.println();
    }

    static void writeLottos(LottoMachine lottoMachine) {
        List<Lotto> lottos = lottoMachine.getLottos();
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
        System.out.println();
    }

    static void readWinningNumbers(LottoMachine lottoMachine) {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] substrings = Console.readLine().split(",");
        List<Integer> winningNumbers = new ArrayList<>();
        try {
            for (String substring : substrings) {
                winningNumbers.add(Integer.parseInt(substring));
            }
            lottoMachine.setWinningLotto(new Lotto(winningNumbers));
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 로또 번호는 숫자 형태여야 합니다.");
            readWinningNumbers(lottoMachine);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            readWinningNumbers(lottoMachine);
        }
        System.out.println();
    }

    static void readBonusNumber(LottoMachine lottoMachine) {
        System.out.println("보너스 번호를 입력해 주세요.");
        try {
            int bonusNumber = Integer.parseInt(Console.readLine());
            lottoMachine.setBonusNumber(bonusNumber);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 로또 번호는 숫자 형태여야 합니다.");
            readBonusNumber(lottoMachine);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            readBonusNumber(lottoMachine);
        }
        System.out.println();
    }

    static void writeWinningResult(LottoMachine lottoMachine) {
        System.out.println("당첨 통계");
        System.out.println("---");
        lottoMachine.getWinningResult()
                .forEach((w, i) -> System.out.println(w.getDescription() + " - " + i + "개"));
        System.out.printf("총 수익률은 %.1f%%입니다.", lottoMachine.calculateRate() * 100);
    }
}
