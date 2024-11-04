package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        //로또 구입 금액을 입력 받는다. 구입 금액은 1,000원 단위로 입력 받으며 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다.
        //[ ] null | blank 예외처리
        //[ ] 1,000원보다 값이 작을 때
        //[ ] 1,000원으로 나누어 떨어지지 않을 때
        //[ ] 올바른 값이 입력되지 않았을 때(문자, 기호 등등)
        System.out.println("구입금액을 입력해 주세요.");
        final int TOTALPRICE = Integer.parseInt(readLine());

        final int LOTTOPRICE = 1000;

        final var LOTTO_AMOUNT = TOTALPRICE/LOTTOPRICE;

        System.out.println("\n"+ LOTTO_AMOUNT + "개를 구매했습니다");

        List<List<Integer>> YOUR_LOTTO_NUMBER_LIST = new ArrayList<>();
        //[ ]로또 번호는 오름차순으로 정렬하여 보여준다.
        int startNum = 1;
        int finalNum = 8;
        int amountNum = 6;
        for(int i = 0; i< LOTTO_AMOUNT; i++){
            List<Integer> YOUR_LOTTO_NUMBER = Randoms.pickUniqueNumbersInRange(startNum, finalNum, amountNum);
            Collections.sort(YOUR_LOTTO_NUMBER);

            YOUR_LOTTO_NUMBER_LIST.add(YOUR_LOTTO_NUMBER);
            System.out.println(YOUR_LOTTO_NUMBER);
        }

        System.out.println("\n당첨 번호를 입력해 주세요.");
        //[x]당첨 번호를 입력 받는다. 번호는 쉼표(,)를 기준으로 구분한다.
        //[ ]쉼표(,)가 아닌 옳지 않은 입력값이 들어왔을 때 예외처리
        //[ ]쉼표(,)가 2개 이상 연달아 있을 때 예외처리
        //[ ]입력된 숫자의 개수가 amountNum과 다를 때
        String INPUT_WINNING_NUMBERS = readLine();
        String[] parts = INPUT_WINNING_NUMBERS.split(",");
        if (parts.length != amountNum) {
            throw new IllegalArgumentException(String.format("[ERROR] 당첨 번호는 %d개여야 합니다.", amountNum));
        }

        List<Integer> WINNING_NUMBERS = new ArrayList<>();
        for (String part : parts) {
            int WINNING_NUMBER = Integer.parseInt(part.trim());
            if (WINNING_NUMBER < startNum || WINNING_NUMBER > finalNum) {
                throw new IllegalArgumentException(String.format("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.",startNum, finalNum));
            }
            WINNING_NUMBERS.add(WINNING_NUMBER);
        }

        //[ ]1-45 사이의 숫자 (음수, 문자 x)
        //[ ]6개의 당첨 번호와 중복 x
        //[x]보너스 번호가 2개 이상으로 변경하고 싶을 때(확장)
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String INPUT_BONUS_NUMBERS = readLine();
        if (INPUT_BONUS_NUMBERS.isEmpty()) {
            System.out.println("[ERROR] 보너스 번호를 입력해야 합니다.");
            return; // 또는 재입력을 유도하는 로직 추가
        }

        List<Integer> BONUS_NUMBERS = Arrays.stream(INPUT_BONUS_NUMBERS.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();  // 여러 개의 보너스 번호를 리스트로 변환

        WINNING_NUMBERS.addAll(BONUS_NUMBERS);
        //[ ]각 일치 개수에 따른 금액 format
        //[ ]구매한 로또 번호와 당첨번호 비교
        //[ ]보너스 볼 일치 여부 확인(5개가 일치하는 경우)
        //[ ]세자리마다 쉼표(,)로 구분(소수점 앞에서부터)
        System.out.println("당첨 통계\n---");
        final int PRIZE_1ST = 2000000000;
        final int PRIZE_2ND = 30000000;
        final int PRIZE_3RD = 1500000;
        final int PRIZE_4TH = 50000;
        final int PRIZE_5TH = 5000;

        int prizeCount = 5;
        int[] prizeCounts = new int[prizeCount];

        for (List<Integer> userLotto : YOUR_LOTTO_NUMBER_LIST){
            long matchCount = userLotto.stream().filter(WINNING_NUMBERS::contains).count();
            boolean bonusMatch = BONUS_NUMBERS.stream().anyMatch(userLotto::contains);

            switch ((int) matchCount){
                case 6:
                    prizeCounts[0]++;
                    break;
                case 5:
                    if(bonusMatch){
                        prizeCounts[1]++;
                    }else{
                        prizeCounts[2]++;
                    }
                    break;
                case 4:
                    prizeCounts[3]++;
                    break;
                case 3:
                    prizeCounts[4]++;
                    break;
                default:
                    break;
            }
        }
        System.out.printf("%d개 일치 (%,d원) - %d개%n", 3, PRIZE_5TH, prizeCounts[4]);
        System.out.printf("%d개 일치 (%,d원) - %d개%n", 4, PRIZE_4TH, prizeCounts[3]);
        System.out.printf("%d개 일치 (%,d원) - %d개%n", 5, PRIZE_3RD, prizeCounts[2]);
        System.out.printf("%d개 일치, 보너스 볼 일치 (%,d원) - %d개%n", 5, PRIZE_2ND, prizeCounts[1]);
        System.out.printf("%d개 일치 (%,d원) - %d개%n", 6, PRIZE_1ST, prizeCounts[0]);

        double totalPrize = PRIZE_1ST * prizeCounts[0] +
                PRIZE_2ND * prizeCounts[1] +
                PRIZE_3RD * prizeCounts[2] +
                PRIZE_4TH * prizeCounts[3] +
                PRIZE_5TH * prizeCounts[4];

        double LOTTO_PROFIT = (totalPrize / TOTALPRICE) * 100;
        double roundedProfit = (int)(LOTTO_PROFIT * 100 + 0.5) / 100.0;

        System.out.printf("총 수익률은 %, .2f%%입니다.%n", roundedProfit);

    }
}
