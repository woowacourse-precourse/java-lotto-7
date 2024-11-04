package lotto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import lotto.app.CLILottoApp;
import lotto.app.LottoApp;

public class Application {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        LottoApp app = new CLILottoApp(br, bw);
        app.run();
        try {
            br.close();
            bw.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        } 
    }
}
