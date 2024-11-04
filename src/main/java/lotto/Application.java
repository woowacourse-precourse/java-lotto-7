package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 구입 금액 초기화
        int money = -1;

        while (money == -1) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                // 구입 금액 입력
                String input_money = Console.readLine();

                // 만약 숫자형태가 아닐시 NumberFormatException 발생 후 재 입력
                money = Integer.parseInt(input_money);

                // 음수거나 1,000원 맞아 떨어지지 않을 시 IllegalStateException 발생 후 재 입력
                if (money < 0 || money % 1000 != 0) {
                    throw new IllegalArgumentException();
                }
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 구입 금액은 숫자로 입력해야 합니다.");
                // 구입 금액을 -1을 입력 해 올바른 입력을 할때까지 루프문 반복
                money = -1;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 구입 금액은 1,000원 단위 금액이어야 합니다.");
                // 구입 금액을 -1을 입력 해 올바른 입력을 할때까지 루프문 반복
                money = -1;
            }
        }

        // 조건이 맞으면 구입 금액을 1,000으로 나누어 발행 갯수 초기화
        int n = money / 1000;

        // 로또 메소드 접근을 위한 객체 생성
        Lotto lotto = new Lotto();
        // n개 만큼의 로또 발행
        List<Lotto> lottos = lotto.number_generator(n);
        System.out.println("\n" + n + "개를 구매했습니다.");
        // 발행된 로또 출력
        for (Lotto arr : lottos) {
            arr.number_print();
        }
        // 담첨 번호 null로 초기화
        Lotto winnig_numbers = null;

        // 올바른 입력이 이루어질때까지 루프문 반복
        while (winnig_numbers == null) {
            try {
                System.out.println("\n당첨 번호를 입력해 주세요.");
                String input_winningNum = Console.readLine();
                // 입력 받은 값을 winning_numbers로 초기화 시도, 만약 조건에 맞지 않는다면 생성자에 있는
                // validate()에 걸려 올바른 입력까지 루프문 반복
                winnig_numbers = new Lotto(
                        Arrays.stream(input_winningNum.split(","))
                                .map(Integer::parseInt)
                                .collect(Collectors.toList())
                );
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 당첨 번호는 숫자로 입력해야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        // 보너스 번호 초기화
        int bonus_Num = 0;
        // 올바른 입력까지 루프문 반복
        while (bonus_Num == 0) {
            try {
                System.out.println("\n보너스 번호를 입력해 주세요.");
                // 숫자 입력이 아닐시 NumberFormatException 발생
                String input_bonusNum = Console.readLine();
                bonus_Num = Integer.parseInt(input_bonusNum);
                // 1 ~ 45의 범위인지, 6개의 숫자와 중복되는지 유효성 검사
                winnig_numbers.bonus_validate(bonus_Num);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 보너스 번호는 숫자로 입력해야 합니다.");
                // 잘못된 입력시 다시 0으로 초기화 후 루프문 반복
                bonus_Num = 0;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                // 잘못된 입력시 다시 0으로 초기화 후 루프문 반복
                bonus_Num = 0;
            }
        }
        // 2등 당첨(보너스 당첨) 횟수 카운트
        int bonus_cnt = 0;

        // 당첨 횟수 카운트를 위한 ArrayList 생성
        ArrayList<Integer> Winning_Details = new ArrayList<>(Collections.nCopies(6, 0));
        // 총 상금 액수 초기화
        int Sum_prize = 0;
        // 발행된 로또들과 당첨 번호가 일치하는지 확인
        for (Lotto arr : lottos) {
            // 발행된 로또와 당첨 번호를 비교해 일치하는 숫자를 반환 후 match에 저장
            int match = arr.number_matching(winnig_numbers);
            // 5개 가 일치할시 나머지 번호가 보너스 번호와 일치하는지 확인
            if (match == 5) {
                // 일치한다면 2등 당첨 횟수 증가 후 continue
                if (arr.bonus_matching(bonus_Num)) {
                    bonus_cnt++;
                    continue;
                }
            }
            // 번호가 3개 이상 일치할 시 Winning_Details에 기록(2등 제외)
            // 3개 일치(5등), 4개 일치(4등), 5개 일치(3등), 6개 일치(1등)
            if (match > 2) {
                Winning_Details.set(match - 1, Winning_Details.get(match - 1) + 1);
            }
        }

        // 통계 출력 후 총 당첨금에 누적 당첨금 추가
        System.out.println("\n당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + Winning_Details.get(2) + "개");
        Sum_prize += (Winning_Details.get(2) * 5000);
        System.out.println("4개 일치 (50,000원) - " + Winning_Details.get(3) + "개");
        Sum_prize += (Winning_Details.get(3) * 50000);
        System.out.println("5개 일치 (1,500,000원) - " + Winning_Details.get(4) + "개");
        Sum_prize += (Winning_Details.get(4) * 150000);
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + bonus_cnt + "개");
        Sum_prize += (bonus_cnt * 30000000);
        System.out.println("6개 일치 (2,000,000,000원) - " + Winning_Details.get(5) + "개");
        Sum_prize += (Winning_Details.get(5) * 2000000000);

        // 구매 금액 대비 당첨 총 수익률 비교 (소숫점 둘째 자리에서 반올림)
        double profit_rate = (double) Sum_prize / (double) money * 100;
        profit_rate = Math.round(profit_rate * 100.0) / 100.0;
        System.out.println("총 수익률은 " + profit_rate + "%입니다.");

    }

}

