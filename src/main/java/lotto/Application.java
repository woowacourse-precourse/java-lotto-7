package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {

        int buy = Input.buyMoney(); // 구입 금액 입력 받기
        LottoBox purchase = new LottoBox(buy/1000); // 로또 번호 생성
        purchase.Print(); // 생성한 로또 번호 print

        System.out.println("당첨 번호를 입력해 주세요.");
        String numbers = Console.readLine(); // 당첨 번호
        Lotto winNumber = new Lotto(changeType(numbers)); // 당첨 번호 Lotto 클래스 생성

        System.out.println("보너스 번호를 입력해 주세요.");
        String bonus = Console.readLine(); // 보너스 번호 입력받기

        LottoStatistics statics = new LottoStatistics(); // 통계 생성
        statics.calculateStatistics(purchase.getLotto(), winNumber, Integer.parseInt(bonus)); // 통계 생성
        statics.printStatistics(); // 당첨 통계 출력
        statics.getTotalPrize(buy); // 총 수익률 출력
    }

    public static List<Integer> changeType(String numbers) {
        return Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
