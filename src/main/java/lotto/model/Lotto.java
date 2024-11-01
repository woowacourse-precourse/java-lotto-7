package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
    }

    // TODO: 추가 기능 구현
    public void printLottoNumbers(List<Integer> numbers){
        Collections.sort(numbers);
        StringBuilder sb = new StringBuilder("[");
        for(int i  =0; i < numbers.size(); i++){
            sb.append(numbers.get(i));
            if(i != numbers.size() - 1){
                sb.append(", ");
            }
        }
        sb.append("]");
        System.out.println(sb);
    }

}
