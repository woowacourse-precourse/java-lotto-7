package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class Application {
    private static int money;
    private static List<Lotto> lottos = new ArrayList<>();
    private static final int lottoNumbersCount = 6;
    private static HashSet<Integer> winNumbers = new HashSet<>();
    private static final int minimumLottoNumber = 1;
    private static final int maximumLottoNumber = 45;
    public static void main(String[] args) {
        init();
        playgame();
    }

    public static void playgame() {
        getWinNumbers();
    }

    public static void getWinNumbers() {
        while(true){
            try{
                System.out.println("당첨번호를 입력해 주세요.");
                askWinNumbers();
                break;
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void askWinNumbers() throws Exception{
        String input = Console.readLine();
        String[] numbers = splitWithComma(input);
        for(String number : numbers){
            isInteger(number);
            int numberInt = Integer.parseInt(number);
            validateInputRange(numberInt);
            winNumbers.add(numberInt);
        }
        System.out.println();
    }

    public static void init() {
        while(true){
            try{
                System.out.println("구입금액을 입력해 주세요.");
                money = getMoneyInput();
                buyLotto();
                break;
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void buyLotto() {
        int lottoCount = money/1000;
        System.out.println(lottoCount+"개를 구매했습니다.");
        for(int i = 0; i < lottoCount; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1,45,lottoNumbersCount);
            numbers.sort(Comparator.naturalOrder());
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
            System.out.println(lotto.toString());
        }
        System.out.println();
    }

    public static int getMoneyInput() throws Exception{
        String input = Console.readLine();
        validateMoney(input);
        return Integer.parseInt(input);
    }

    public static void validateMoney(String input) throws Exception{
        isInteger(input);
        isMultipleOf1000(Integer.parseInt(input));
    }

    public static void isMultipleOf1000(int inputInt) throws Exception{
        if(inputInt%1000 != 0){
            throw new IllegalArgumentException("1000으로 나누어 떨어져야 합니다.");
        }
    }

    public static void isInteger(String input) throws Exception{
        try{
            Integer.parseInt(input);
        }catch(Exception e){
            throw new NumberFormatException("정수여야 합니다.");
        }
    }

    public static String[] splitWithComma(String input) throws Exception{
        String[] splitted = input.split(",");
        if(splitted.length != lottoNumbersCount){
            throw new IllegalArgumentException("숫자들은 ,(콤마)로 구분되어야 합니다.");
        }
        return splitted;
    }

    public static void validateInputRange(int inputInt) throws Exception{
        if(inputInt < minimumLottoNumber || inputInt > maximumLottoNumber){
            throw new IllegalArgumentException("로또 번호는 1이상 45이하의 자연수여야 합니다.");
        }
    }
}
