package lotto;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class Application {
    public static void main(String[] args) {
        int lottoLen = getValidatedLottoAmount();
        List<Integer> winNumbers;
        Integer bonusNumber;
        int[] winStatus;
        System.out.println();

        List<Lotto> LottoList = generateLottoList(lottoLen);

        for (Lotto list : LottoList){
            System.out.println(list.getNumbers());
        }

        System.out.println();

        winNumbers = getWinningNumbers();

        System.out.println();

        bonusNumber = getBonusNumber();

        System.out.println();

        winStatus = calculateWinStatus(LottoList, winNumbers, bonusNumber);
        printStatisticsAndProfit(winStatus, lottoLen * 1000);

    }

    private static int getValidatedLottoAmount() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String input = Console.readLine();

                int amount = Integer.parseInt(input);
                if (amount % 1000 != 0) {
                    throw new IllegalArgumentException("[ERROR] 로또 구입 값은 1000원 단위로만 받을 수 있습니다.");
                }
                return amount / 1000;  // 유효한 값이면 구매 가능한 로또 개수를 반환

            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 금액은 숫자 형식이어야 합니다. 다시 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static List<Lotto> generateLottoList(int lottoLen) {
        List<Lotto> lottoList = new ArrayList<>();
        System.out.println("\n" + lottoLen + "개를 구매했습니다.");
        for (int i = 0; i < lottoLen; i++) {
            try {
                List<Integer> newPick = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
                newPick.sort(Comparator.naturalOrder());
                lottoList.add(new Lotto(newPick));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                i--;  // 예외 발생 시 해당 로또 재생성
            }
        }
        return lottoList;
    }

    private static List<Integer> getWinningNumbers() {
        while (true) {
            System.out.println("\n당첨 번호를 입력해 주세요.");
            String input = Console.readLine();
            List<Integer> winNumbers = new ArrayList<>();

            try {
                Arrays.stream(input.split(","))
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .forEach(winNumbers::add);

                if (winNumbers.size() != 6) {
                    throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
                }

                return winNumbers; // 올바른 입력일 경우 리스트 반환

            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 당첨 번호는 숫자 형식이어야 합니다. 다시 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + " 다시 입력해 주세요.");
            }
        }
    }


    private static int getBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        try {
            int bonusNumber = Integer.parseInt(Console.readLine());
            if (bonusNumber < 1 || bonusNumber > 45) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
            return bonusNumber;
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 보너스 번호는 숫자 형식이어야 합니다.");
            System.exit(0);  // 프로그램 종료
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        return -1;
    }

    private static int[] calculateWinStatus(List<Lotto> lottoList, List<Integer> winNumbers, int bonusNumber) {
        int[] winStatus = new int[5];
        for (Lotto lotto : lottoList) {
            int count = 0;
            for (Integer target : winNumbers) {
                if (lotto.contains(target)) {
                    count++;
                }

                if (count == 5 && lotto.contains(bonusNumber)) {
                    count = 7;
                }
            }
            updateWinStatus(winStatus, count);
        }
        return winStatus;
    }

    private static void updateWinStatus(int[] winStatus, int count) {
        if (count == 3) {
            winStatus[0]++;
        } else if (count == 4) {
            winStatus[1]++;
        } else if (count == 5) {
            winStatus[2]++;
        } else if (count == 7) {
            winStatus[3]++;
        } else if (count == 6) {
            winStatus[4]++;
        }
    }

    private static void printStatisticsAndProfit(int[] winStatus, int totalCost) {
        int[] prizes = {5000, 50000, 1500000, 30000000, 2000000000};
        String[] labels = {
                "3개 일치 (5,000원) - %d개",
                "4개 일치 (50,000원) - %d개",
                "5개 일치 (1,500,000원) - %d개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개",
                "6개 일치 (2,000,000,000원) - %d개"
        };
        int totalPrize = 0;

        System.out.println("\n당첨 통계\n---");
        for (int i = 0; i < winStatus.length; i++) {
            System.out.printf(labels[i] + "\n", winStatus[i]);
            totalPrize += winStatus[i] * prizes[i];
        }

        double profitRate = ((double) totalPrize / totalCost) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }

}
