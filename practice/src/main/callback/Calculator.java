package main.callback;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Calculator {
    private <T> T lineReadTempate(String filepath, LineCallback<T> callback, T initVal) throws Exception {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filepath));
            T res = initVal;
            String line = null;
            while ((line = br.readLine()) != null) {
                res = callback.doSomethingWithLine(line, res);
            }
            return res;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {

            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            }
        }


    }

    public Integer fileReadTemplate(String filepath, BufferedReaderCallback callback) throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filepath));
            Integer ret = callback.doSomethingWithReader(br);
            return ret;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {

            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            }
        }
    }

    public Integer calSum(String filepath) throws Exception {
//        return fileReadTemplate(filepath, br -> {
//            Integer sum = 0;
//            String line = null;
//            while ((line = br.readLine()) != null) {
//                sum += Integer.parseInt(line);
//            }
//            return sum;
//        });
        return lineReadTempate(filepath, (line, value) -> value + Integer.parseInt(line), 0);
    }

    public Integer multiply(String filepath) throws Exception {
//        return fileReadTemplate(filepath, br -> {
//            Integer mul = 1;
//            String line = null;
//            while ((line = br.readLine()) != null) {
//                mul *= Integer.parseInt(line);
//            }
//            return mul;
//        });
        return lineReadTempate(filepath, (line, value) -> value * Integer.parseInt(line), 1);
    }

    public String concatenate(String filepath) throws Exception {
        return lineReadTempate(filepath, (line, value) -> value + line, "");
    }
}
