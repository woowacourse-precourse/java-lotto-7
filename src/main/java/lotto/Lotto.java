package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        validate(numbers);
        numbers.sort((a,b)->{if(a>b)return 1; else return -1;});
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // 투포인터 알고리즘
    public int checkWinCountWithWinNumbers(List<Integer> winNumbers){
        int count = 0;
        int lottoNumbersIterator = 0;
        int winNumbersIterator = 0;

        while(lottoNumbersIterator<=numbers.size() && winNumbersIterator <= winNumbers.size()){
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