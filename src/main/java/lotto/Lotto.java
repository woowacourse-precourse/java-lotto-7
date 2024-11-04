package lotto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Lotto {
    private final ArrayList<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = new ArrayList<>(numbers);
        validate(numbers);
        this.numbers.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    @Override
    public String toString(){
        return numbers.toString();
    }

    // 투포인터 알고리즘
    public int checkWinCountWithWinNumbers(List<Integer> winNumbers){
        int count = 0;
        int lottoNumbersIterator = 0;
        int winNumbersIterator = 0;

        while(lottoNumbersIterator<numbers.size() && winNumbersIterator < winNumbers.size()){
            int lottoNumber = numbers.get(lottoNumbersIterator);
            int winNumber = winNumbers.get(winNumbersIterator);

            if(lottoNumber > winNumber){
                winNumbersIterator++; continue; }
            if(lottoNumber < winNumber){
                lottoNumbersIterator++; continue; }

            count++;
            lottoNumbersIterator++;
            winNumbersIterator++;
        }
        return count;
    }

    public boolean checkBonnusNumber(int bonnusNumber){
        return numbers.contains(bonnusNumber);
    }
}