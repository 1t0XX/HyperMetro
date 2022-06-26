import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.CharBuffer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // start coding here
        String data = reader.readLine();
        if (data.length() <= 50) {
            StringBuilder sb = new StringBuilder();
            sb.append(data);
            System.out.println(sb.reverse());
        }
        reader.close();
    }
}