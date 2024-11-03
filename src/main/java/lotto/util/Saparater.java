package lotto.util;

public class Saparater {
    private String delimiter;

    public Saparater(String delimiter){
        this.delimiter = delimiter;
    }

    public String[] split(String input){
        return input.split(delimiter);
    }
}
