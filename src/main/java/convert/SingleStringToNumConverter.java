package convert;

public class SingleStringToNumConverter {
    private final String inputString;

    public SingleStringToNumConverter(String inputString) {
        this.inputString = inputString;
    }

    // 만약 int 범위를 넘는 숫자가 들어오면 어떻게 하려고? 인터페이스화 해야하나?
    public int convert() {
        return Integer.parseInt(inputString);
    }
}
