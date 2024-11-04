package lotto;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        int tickets = PurchaseTickets();
        List<Integer> inputNumber = NumberOfLotto();
        List<Lotto> lottoNumbers = getLotto(tickets);
        printLottoNumber(lottoNumbers);
    }

    //로또 구매
    private static int PurchaseTickets(){
        System.out.println("구입 금액을 입력해 주세요.");
        int tickets = Integer.parseInt(Console.readLine());
        if(tickets % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 로또는 1,000원 단위로 구매해야 합니다.");
        }
        return tickets/1000;
    }

    //로또 번호 입력
    private static List<Integer> NumberOfLotto(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();

        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    //구매한 로또 번호
    private static List<Lotto> getLotto(int count){
        List<Lotto> lottoNumbers = new ArrayList<>();
        for(int i = 0 ; i < count ; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoNumbers.add(new Lotto(numbers));
        }
        return lottoNumbers;
    }
    //구매한 로또 번호 출력
    private static void printLottoNumber(List<Lotto> lottoNumbers){
        System.out.println(lottoNumbers.size() + "개를 구매했습니다.");
        for(Lotto lotto : lottoNumbers){
            System.out.println(lotto.getNumbers());
        }
    }


}