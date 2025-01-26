import main.callback.Calculator;

import java.io.File;

public class Main {
    public static void main(String[] args) throws Exception {
        String currentPath = System.getProperty("user.dir");
        String filePath = currentPath + File.separator + "practice"+File.separator+"src"+ File.separator + "a.txt";
        Calculator calculator = new Calculator();
        System.out.println(calculator.calSum(filePath));
    }
}