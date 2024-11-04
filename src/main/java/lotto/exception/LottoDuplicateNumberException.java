package lotto.exception;

import java.util.Set;
import java.util.stream.Collectors;

public class LottoDuplicateNumberException extends IllegalArgumentException{

    public LottoDuplicateNumberException(Set<Integer> duplicateLottoNumber){
        super(duplicateLottoNumber.stream()
                .map(i -> String.valueOf(i))
                .collect(Collectors.joining(", ","[ERROR] 중복 요소: ","가 하나 이상 존재"))
        );
    }

}
