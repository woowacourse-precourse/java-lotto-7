package lotto;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine();
        LottoGame lottoGame = new LottoGame();

        int moneys = getValidMoneyInput();
        int lottoCount = moneys / 1000;

        System.out.println();
        System.out.println(lottoCount + "개를 구매했습니다.");
        List<Lotto> purchasedTickets = lottoMachine.purchaseLottos(lottoCount);
        purchasedTickets.forEach(ticket -> System.out.println(ticket.getNumbers()));

        List<Integer> winningNumbers = getValidWinningNumbers();
        int bonusNumber = getValidBonusNumber(winningNumbers);

        int[] totalCount = lottoGame.calculateResults(purchasedTickets, winningNumbers, bonusNumber);
        printStatistics(totalCount, lottoGame.calculateTotalPrize(totalCount), moneys, lottoGame);
    }

    private static int getValidMoneyInput() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            try {
                int moneys = Integer.parseInt(readLine());

                if (moneys < 0) {
                    throw new IllegalArgumentException("[ERROR] 금액은 양수여야 합니다.");
                }

                if (moneys % 1000 != 0) {
                    throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위만 가능합니다.");
                }

                return moneys;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 유효한 숫자를 입력하세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static List<Integer> getValidWinningNumbers() {
        while (true) {
            System.out.println();
            System.out.println("당첨 번호를 입력해 주세요.");
            try {
                String[] input = readLine().split(",");
                if (input.length != 6) {
                    throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
                }

                List<Integer> numbers = new ArrayList<>();
                for (String num : input) {
                    int number = Integer.parseInt(num.trim());
                    if (number < 1 || number > 45) {
                        throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                    }
                    if (numbers.contains(number)) {
                        throw new IllegalArgumentException("[ERROR] 중복된 숫자는 입력할 수 없습니다.");
                    }
                    numbers.add(number);
                }
                return numbers;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자 형식만 입력 가능합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int getValidBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            System.out.println();
            System.out.println("보너스 번호를 입력해 주세요.");
            try {
                int bonusNumber = Integer.parseInt(readLine().trim());
                if (bonusNumber < 1 || bonusNumber > 45) {
                    throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
                }

                if (winningNumbers.contains(bonusNumber)) {
                    throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
                }
                return bonusNumber;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자 형식만 입력 가능합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void printStatistics(int[] totalCount, int totalPrize, int moneys, LottoGame game) {
        System.out.println();
        System.out.println("당첨 통계\n---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", totalCount[LottoRank.FIFTH.ordinal()]);
        System.out.printf("4개 일치 (50,000원) - %d개\n", totalCount[LottoRank.FOURTH.ordinal()]);
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", totalCount[LottoRank.THIRD.ordinal()]);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", totalCount[LottoRank.SECOND.ordinal()]);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", totalCount[LottoRank.FIRST.ordinal()]);
        double earningRate = game.calculateEarningRate(totalPrize, moneys);
        System.out.printf("총 수익률은 %.1f%%입니다.%n", earningRate);
    }
}
