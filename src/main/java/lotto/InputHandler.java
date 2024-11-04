package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputHandler {

    public Integer getAmountPaid(){
        while(true){
            try {
                String input = Console.readLine();
                isMultipleOfThousand(parseToInt(input));
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());;
            }
        }

    }


    private int parseToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효한 숫자를 입력해 주세요.");
        }
    }
    public List<Integer> getLottoNumber(){
        while(true){
            try{
                String input = Console.readLine();
                List<Integer> list = parseToIntegerList(input);
                validateLottoNumbers(list);
                return list;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

    }


    private void validateLottoNumbers(List<Integer> numbers) {
        checkWinningNumberSize(numbers);
        checkWinningNumberDuplicates(numbers);
        checkWinningNumberRange(numbers);
    }
    private void checkWinningNumberSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
    }

    // 중복 여부 확인
    private void checkWinningNumberDuplicates(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다.");
        }
    }

    // 번호 범위 확인
    private void checkWinningNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            validateNumberRange(number);
        }
    }
    private void validateNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 번호는 1에서 45 사이여야 합니다.");
        }
    }
    private List<Integer> parseToIntegerList(String input) {
        while(true){
            try {
                return Arrays.stream(input.split(","))
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 당첨 번호는 쉼표로 구분된 숫자여야 합니다.");
            }
        }

    }


    public int getBonusNumber(){
        while(true){
            try{
                String input = Console.readLine();
                int bonus = parseToInt(input);
                validateNumberRange(bonus);
                return bonus;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }


    }

    public void isMultipleOfThousand(int amount){
        if(amount%1000!=0){
            throw new IllegalArgumentException("[ERROR] 금액은 1000의 배수여야 합니다.");
        }
    }
    public List<Lotto> initializeLotto(int num){

        List<Lotto> lottos = new ArrayList<>();
        for(int i=0;i<num;i++){
            lottos.add(new Lotto(generateLottoNumbers()));
        }
        return lottos;
    }

    public List<Integer> generateLottoNumbers(){
        return Randoms.pickUniqueNumbersInRange(1,45,6);
    }



}
