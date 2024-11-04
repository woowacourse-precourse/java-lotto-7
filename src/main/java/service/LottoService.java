package service;


public class LottoService {
    public int[] getLotto(String input) {
        String[] list = input.split(",");
        int[] numbers = new int[list.length];
        for (int i = 0; i < list.length; i++) {
            numbers[i] = Integer.parseInt(list[i]);
        }
        return numbers;
    }
}
