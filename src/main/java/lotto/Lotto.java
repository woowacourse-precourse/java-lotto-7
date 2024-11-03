package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Console;

import static java.lang.Integer.parseInt;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        for(int i=0;i<numbers.size();i++){
            if(numbers.get(i)<1 || numbers.get(i)>45){
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45의 숫자여야 합니다.");
            }
        }
        Collections.sort(numbers); // 리스트 정렬
        for (int i = 0; i < numbers.size() - 1; i++) {
            if (numbers.get(i).equals(numbers.get(i + 1))) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복이 불가능합니다.");
            }
        }
    }

    // TODO: 추가 기능 구현
    public void main() {
        //입력받기
        System.out.println("구입금액을 입력해 주세요.");
        int tickets = 0;
        int price = 0;

        try {
            price = parseInt(Console.readLine());
            if (price <= 0 || price % 1000 != 0) {
                throw new IllegalArgumentException();
            }
            tickets = price / 1000;
        } catch (IllegalArgumentException e) {
            System.out.println("[Error] 구입 금액은 1,000원 단위로 입력되어야 합니다.");
        }

        MakeTickets makeTickets = new MakeTickets();
        makeTickets.makeTickets(tickets);
        List<List<Integer>> randomTickets = makeTickets.getTickets();

        System.out.println(tickets + "개를 구매했습니다.");
        for (int i = 0; i < randomTickets.size(); i++) {
            System.out.println(randomTickets.get(i));
        }

        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        for (String num : input.split(",")) {
            numbers.add(Integer.parseInt(num.trim()));
        }
        new Lotto(numbers);

        System.out.println("보너스 번호를 입력해 주세요.");
        try {
            int bonusNum = parseInt(Console.readLine());
            if (bonusNum < 1 || bonusNum > 45) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("보너스번호는 1~45의 정수 입니다.");
        }

        //당첨확인 메소드
        LottoChecker lottoChecker = new LottoChecker();
        lottoChecker.lottoChecker(randomTickets);

//        수익률계산 메소드
        ProfitCalc profit = new ProfitCalc();
        float profit_ = profit.profitCalc(price);

        //출력하기
        System.out.println("당첨통계");
        System.out.println("---");


        System.out.println("총 수익률은 "+String.format(".1f",profit_)+"% 입니다.");

    }



}
