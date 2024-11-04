package lotto;

import java.util.List;

public class Matcher {
    private final List<Integer> inputList;
    private List<Integer> equalNumbers;

    //두 리스트에서 일치 값을 반환
    public int match(Lotto lotto){
        return (int) inputList.stream()
                .filter(lotto::contains)
                .count();
    }

    //로또그룹에서 일치값 리스트를 반환
    public List<Integer> matches(List<Lotto> ticket){
        for(Lotto lotto : ticket){
            int equalNum = match(lotto);
            equalNumbers.add(equalNum);
        }
        System.out.println(equalNumbers);
        return equalNumbers;
    }
    public Matcher(List<Integer> numbers){
        this.inputList = numbers;
    }


}
