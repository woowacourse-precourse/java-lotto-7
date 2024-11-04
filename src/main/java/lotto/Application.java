package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        int purchaseNum;
        List<Integer> winningNum;
        int bonusNum;

        while (true) {
            try {
                purchaseNum = getPurchaseNum();
                break;
            }catch(NumberFormatException e) {
                System.out.println("[ERROR] 정수를 입력하세요.");
            }catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println();

        Lotto[] lottos = new Lotto[purchaseNum];
        System.out.println(purchaseNum + "개를 구매했습니다.");
        for(int i = 0; i < purchaseNum; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos[i] = new Lotto(numbers);
            lottos[i].printNums();
        }
        System.out.println();

        while(true) {
            try {
                winningNum = getWinningNum();
                break;
            }catch(NumberFormatException e) {
                System.out.println("[ERROR] 정수를 입력하세요.");
            }catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println();

        while(true) {
            try {
                bonusNum = getBonusNum(winningNum);
                break;
            }catch(NumberFormatException e) {
                System.out.println("[ERROR] 보너스 번호는 1자리 정수여야 합니다.");
            }catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println();

        LottoStatistics lottoStatistics = new LottoStatistics(lottos, winningNum, bonusNum);
        lottoStatistics.run();
    }

    public static int getPurchaseNum() throws NumberFormatException {
        System.out.println("구입금액을 입력해 주세요.");
        int sum = Integer.parseInt(Console.readLine());

        if(sum % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액이 1000원으로 나누어 떨어지지 않습니다.");
        }
        return sum / 1000;
    }

    public static List<Integer> getWinningNum() throws NumberFormatException {
        System.out.println("당첨 번호를 입력해 주세요.");
        String nums = Console.readLine();
        String[] numbers = nums.split(",");

        if(numbers.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6자리여야 합니다.");
        }

        List<Integer> winningNum = new ArrayList<>();
        for(int i = 0; i < numbers.length; i++) {
            if(Integer.parseInt(numbers[i].trim()) > 45 || Integer.parseInt(numbers[i].trim()) < 1) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
            winningNum.add(Integer.parseInt(numbers[i].trim()));
        }

        Set<Integer> numSet = new HashSet<>(winningNum); // 중복 확인
        if(winningNum.size() != numSet.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 수가 존재합니다.");
        }

        Collections.sort(winningNum);
        return winningNum;
    }

    public static int getBonusNum(List<Integer> winningNum) throws NumberFormatException {
        System.out.println("보너스 번호를 입력해 주세요.");
        String num = Console.readLine();

        int bonusNum = Integer.parseInt(num.trim());
        if(bonusNum > 45 || bonusNum < 1) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if(winningNum.contains(bonusNum)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 중복되지 않아야 합니다.");
        }

        return bonusNum;
    }
}
