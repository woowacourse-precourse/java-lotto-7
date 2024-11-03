package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;


public class Application {
    public static void main(String[] args) {
        // 1 . 구매 금액 입력 및 로또 수량 계산
        System.out.println("구입금액을 입력해 주세요.");
        int purchasePrice = getValidPurchasePrice();
        int lottoQuantity = purchasePrice / 1000;

        // 2 . 로또 번호 생성 및 저장
        List<Lotto> lottoRepository = new ArrayList<>();
        for (int i = 0; i < lottoQuantity; i++) {
            List<Integer> lotto = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(lotto);
            lottoRepository.add(new Lotto(lotto));
        }

        // 3 . 로또 번호 출력
        System.out.println(lottoQuantity + "개를 구매했습니다.");
        for (Lotto lotto : lottoRepository) {
            System.out.println(lotto.getNumbers());
        }

        // 4 . 당첨 & 보너스 번호 입력
        System.out.println("\n당첨 번호를 입력해 주세요.");
        List<Integer> winningNumber = getValidWinningNo();

        System.out.println("\n보너스 번호를 입력해 주세요.");
        int bonusNumber = getValidBonus(winningNumber);

        // 5 . 당첨 통계 초기화
        Map<LottoRank, Integer> winningStatistics = new HashMap<>();
        for (LottoRank rank : LottoRank.values()) {
            winningStatistics.put(rank, 0);
        }
    }

    private static int getValidBonus(List<Integer> winningNumber) {
        while (true) {
            try {
                int bonus = getParseInt(Console.readLine());
                if (winningNumber.contains(bonus)) {
                    throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복 될수 없습니다.");
                }
                return bonus;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("\n보너스 번호를 입력해 주세요.");
            }
        }
    }

    private static List<Integer> getValidWinningNo() {
        while (true) {
            try {
                int[] numbers = getIntArray(split(Console.readLine()));
                validLotto(numbers);
                List<Integer> winningNumber = new ArrayList<>();
                for (int number : numbers) {
                    winningNumber.add(number);
                }
                return winningNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("\n당첨 번호를 입력해 주세요.");
            }
        }
    }

    private static void validLotto(int[] numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 1 ~ 45 사이의 숫자를 입력해주세요!");
            }
        }
    }

    private static int[] getIntArray(String[] input) {
        int[] number = new int[input.length];
        for (int i = 0; i < number.length; i++) {
            number[i] = getParseInt(input[i]);
        }
        return number;
    }

    private static String[] split(String input) {
        return input.split(",");
    }

    private static int getValidPurchasePrice() {
        while (true) {
            try {
                int purchasePrice = getParseInt(Console.readLine());
                if (purchasePrice < 1000 || purchasePrice % 1000 != 0) {
                    throw new IllegalArgumentException("[ERROR] 구매 금액은 1000이상, 1000원 단위여야 합니다.");
                }
                return purchasePrice;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("구입금액을 입력해 주세요.");
            }
        }
    }
    
    private static int getParseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주세요");
        }
    }
}
