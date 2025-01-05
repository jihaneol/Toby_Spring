public class Main {
    public static void main(String[] args) throws Exception {
        String currentPath = System.getProperty("user.dir");
        String filePath = currentPath + "/src/a.txt";
        Calculator calculator = new Calculator();

        System.out.println(calculator.calSum(filePath));
    }
}