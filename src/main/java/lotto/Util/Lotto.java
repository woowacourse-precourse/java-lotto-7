package lotto.Util;

import java.util.List;

public class Lotto {
    static final int LOTTO_PRICE = 1000;
    private final List<Integer> numbers;
    int amount;

    //numbers는 곧 당첨 번호
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public int buyLotto(int money) {
        int remainder = money % LOTTO_PRICE;

        amount = money / LOTTO_PRICE;
        if (remainder != 0) {
            int neededMoney = LOTTO_PRICE - remainder;
            throw new IllegalArgumentException("[ERROR]" + remainder + "원으로는 구매가 불가능합니다." + neededMoney + "원 더 채워주세요");
        }
        return amount;
    }

    /*public List<Integer> drawLotto(List<Integer> numbers) {

    }*/

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (numbers.stream().anyMatch(number -> number > 45)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 숫자 범위는 1~45 까지입니다.");
        }
        /*private void amountValidate {


        }*/
    }

    public List<Integer> getNumbers(){
        return numbers;
    }
}
