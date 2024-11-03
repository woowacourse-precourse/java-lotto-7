package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int purchaseAmount = getPurchaseAmount();
        List<Lotto> purchasedLottos = issueLottos(purchaseAmount);
        printLottos(purchasedLottos);

        // 당첨 번호와 보너스 번호 입력받기
        Set<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber(winningNumbers);
    }

    private static int getPurchaseAmount() {
        int amount = 0;

        while (true) {
            try {
                System.out.println("구입 금액을 입력해 주세요.");
                amount = Integer.parseInt(Console.readLine());

                // 1000원 단위 확인하기
                if (amount <= 0 || amount % 1000 != 0) {
                    throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
                }
                break; // 유효한 금액이면 반복문 탈출

            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return amount;
    }

    private static List<Lotto> issueLottos(int purchaseAmount) {
        int numberOfLottos = purchaseAmount / 1000; // 로또 한 장당 1,000원
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < numberOfLottos; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers); // 오름차순 정렬
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    private static void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    private static Set<Integer> getWinningNumbers() {
        Set<Integer> winningNumbers = new HashSet<>();

        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요. (쉼표로 구분된 6개의 숫자)");
                String[] input = Console.readLine().split(",");

                // 6개의 숫자인지 확인
                if (input.length != 6) {
                    throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개의 숫자여야 합니다.");
                }

                // 숫자 검증 및 중복 확인
                for (String num : input) {
                    int number = Integer.parseInt(num.trim());

                    if (number < 1 || number > 45) {
                        throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                    }
                    if (!winningNumbers.add(number)) {
                        throw new IllegalArgumentException("[ERROR] 중복된 번호가 있습니다.");
                    }
                }
                break; // 유효한 입력이면 반복문 탈출

            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해야 합니다.");
                winningNumbers.clear();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                winningNumbers.clear();
            }
        }

        return winningNumbers;
    }

    private static int getBonusNumber(Set<Integer> winningNumbers) {
        int bonusNumber = 0;

        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                bonusNumber = Integer.parseInt(Console.readLine());

                if (bonusNumber < 1 || bonusNumber > 45) {
                    throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
                }
                if (winningNumbers.contains(bonusNumber)) {
                    throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
                }
                break; // 유효한 보너스 번호이면 반복문 탈출

            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return bonusNumber;
    }

}
