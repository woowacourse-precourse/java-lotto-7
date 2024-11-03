package lotto.util;

public class Saparater {

    private String delimiter;

    public Saparater(String delimiter) {
        validate(delimiter);
        this.delimiter = delimiter;
    }

    public String[] split(String input) {
        validate(input);
        return input.split(delimiter);
    }

    private void validate(String input){
        if(input==null || input==""){
            throw new IllegalArgumentException("[ERROR] 입력값이 NULL이거나 없습니다.");
        }
    }
}
