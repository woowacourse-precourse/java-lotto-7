package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int price=0;
        while(price<=0) {
            System.out.println("구입 금액을 입력해주세요.");
            String priceInput = Console.readLine();

            try {
                price=getPrice(priceInput);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }

        }

        //가격 정상 입력 테스트용
        System.out.println("price: "+price);

        int amount=price/1000;
        ArrayList<Lotto> lottos=new ArrayList<>();
        for(int i=0;i<amount;i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            lottos.add(new Lotto(numbers));
        }

        System.out.println(amount+"개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }

        Lotto goldenNumbers=null;
        while (goldenNumbers==null) {

            System.out.println("당첨 번호를 입력해주세요.");
            String numbersInput = Console.readLine();

            List<Integer> numbers = null;
            try {
                numbers = getNumbers(numbersInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            try {
                goldenNumbers = new Lotto(numbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        //당첨번호 테스트용 코드
        System.out.println("golden Numbers: "+goldenNumbers.getNumbers());


    }

    public static int getPrice(String priceInput) throws IllegalArgumentException{
        int price=0;
        String ERRORMESSAGE="[ERROR] 가격은 양의 정수이고 1000으로 나눠떨어져야 합니다.";

        try{
            price=Integer.parseInt(priceInput);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(ERRORMESSAGE);
        }

        if(price<=0 || price%1000!=0) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }


        return price;
    }

    public static List<Integer> getNumbers(String numbersInput) throws IllegalArgumentException {
        String[] splitted = numbersInput.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String s : splitted) {
            int number = 0;

            try {
                number = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 1~45 사이 정수만 써주십시오.");
            }

            if (number < 1 || number > 45)
                throw new IllegalArgumentException("[ERROR] 1~45 사이 정수만 써주십시오.");

            numbers.add(number);
        }
        Collections.sort(numbers);
        return numbers;
    }
}
