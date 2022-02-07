package sample.logic;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class PageLoader {

    //Загружаем HTML из адреса
    public String LoadPage(String address) {
        String result = "";
        InputStream is = null;

        try {
            URL url = new URL(address);
            is = url.openStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;
            StringBuilder sb = new StringBuilder("");
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
            }
            result = sb.toString();
        } catch (Exception ex) {
            System.console().printf(ex.getMessage());
        } finally {
            try {
                if(is!=null) is.close();
            } catch (Exception ex) {
            }
        }

        return result;
    }

}
