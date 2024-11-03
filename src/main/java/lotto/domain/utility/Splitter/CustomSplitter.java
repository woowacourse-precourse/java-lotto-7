package lotto.domain.utility.Splitter;

public class CustomSplitter {

    private final String splitter;

    public CustomSplitter(String splitter) {
        this.splitter = splitter;
    }

    public String[] splitFrom(String input) {
        return input.split(splitter);
    }
}
