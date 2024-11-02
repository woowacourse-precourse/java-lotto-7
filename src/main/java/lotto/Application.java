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
                continue;
            }

            try {
                goldenNumbers = new Lotto(numbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        //당첨번호 테스트용 코드
        System.out.println("golden Numbers: "+goldenNumbers.getNumbers());

        int bonus=0;
        while (bonus<1 || bonus>46) {
            System.out.println("보너스 번호를 입력해 주세요.");
            String bonusInput = Console.readLine();
            try {
                bonus = getBonus(bonusInput);
                checkBonus(bonus, goldenNumbers);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        //보너스 테스트용 코드
        System.out.println("bonus: "+bonus);


    }

    public static int getBonus(String bonusInput) throws IllegalArgumentException{
        int bonus=0;

        try{
            bonus=Integer.parseInt(bonusInput);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이 정수여야 합니다.");
        }

        return bonus;

    }

    public static void checkBonus(int bonus, Lotto golden) throws IllegalArgumentException{
        for (Integer i : golden.getNumbers()) {
            if(bonus==i){
              throw new IllegalArgumentException("[ERROR] 보너스 번호와 당첨 번호는 중복될 수 없습니다.");
            }
        }
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
        List<Integer> numbers = new ArrayList<>();
        for (String s : numbersInput.split(",")) {
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
