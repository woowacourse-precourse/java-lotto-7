package lotto;

import java.util.*;

import camp.nextstep.edu.missionutils.Console;

import static java.lang.Integer.parseInt;

public class Lotto {
    private final List<Integer> numbers;
    static int prize = 0;

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
        Collections.sort(numbers);
        for (int i = 0; i < numbers.size() - 1; i++) {
            if (numbers.get(i).equals(numbers.get(i + 1))) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복이 불가능합니다.");
            }
        }
    }
    public static void main(String[] args) {
        int tickets = 0;
        int price = 0;

        System.out.println("구입금액을 입력해 주세요.");

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

        List<Integer> inputNumbers = lottoNumInput();
        Lotto lotto = new Lotto(inputNumbers);
        printMethod(randomTickets, price, lotto.numbers);
    }

    // 로또 번호 입력 메소드
    public static List<Integer> lottoNumInput() {
        List<Integer> numbers = new ArrayList<>(); // 입력받은 번호를 저장할 리스트
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();

        try {
            // 입력된 번호를 리스트에 추가
            for (String num : input.split(",")) {
                numbers.add(Integer.parseInt(num.trim()));
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return numbers;
    }

    // 보너스 번호 입력 메소드
    private static int bonusNumInput() {
        int bonusNum = 0;
        System.out.println("보너스 번호를 입력해 주세요.");
        try {
            bonusNum = parseInt(Console.readLine());
            if (bonusNum < 1 || bonusNum > 45) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("보너스 번호는 1~45의 정수입니다.");
        }
        return bonusNum;
    }


    public static void printMethod(List<List<Integer>> randomTickets, int price, List<Integer> numbers){
        LottoChecker lottoChecker = new LottoChecker();
        lottoChecker.lottoChecker(numbers, randomTickets, bonusNumInput());

        List<Integer> winTickets = lottoChecker.getWinTickets();

        System.out.println("당첨통계");
        System.out.println("---");
        for(LottoRank rank : LottoRank.values()){
            if (rank != LottoRank.NONE) {
                int count = winTickets.get(rank.ordinal());
                System.out.println(rank.getMessage() + count + "개");

                int tmp = rank.getPrize() *count;
                prize+=tmp;
            }
        }
        ProfitCalc profit = new ProfitCalc();
        float profit_ = profit.profitCalc(price, prize);
        System.out.println("총 수익률은 " + String.format(".1f", profit_) + "% 입니다.");
    }

}

