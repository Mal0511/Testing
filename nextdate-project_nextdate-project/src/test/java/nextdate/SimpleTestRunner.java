package nextdate;

public class SimpleTestRunner {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("NEXTDATE TESTING - SIMPLE TEST RUNNER");
        System.out.println("========================================\n");
        
        System.out.println("Run tests using Maven commands:");
        System.out.println("1. mvn test                    - Run all tests");
        System.out.println("2. mvn test -Dtest=NextDateTest - Run NextDateTest only");
        System.out.println("3. mvn clean test jacoco:report - Run tests with coverage");
        System.out.println("\nOr run from IDE (IntelliJ/Eclipse)");
        
        // Run some simple tests manually
        System.out.println("\n=== MANUAL TESTS ===");
        
        // Test 1
        String result1 = NextDate.getNextDate(31, 1, 2023);
        System.out.println("Test 1: 31/1/2023 -> " + result1 + 
                          (result1.equals("1/2/2023") ? " ✓" : " ✗"));
        
        // Test 2
        String result2 = NextDate.getNextDate(28, 2, 2023);
        System.out.println("Test 2: 28/2/2023 -> " + result2 + 
                          (result2.equals("1/3/2023") ? " ✓" : " ✗"));
        
        // Test 3
        String result3 = NextDate.getNextDate(29, 2, 2023);
        System.out.println("Test 3: 29/2/2023 -> " + result3 + 
                          (result3.equals("INVALID") ? " ✓" : " ✗"));
        
        // Test 4
        String result4 = NextDate.getNextDate(31, 4, 2023);
        System.out.println("Test 4: 31/4/2023 -> " + result4 + 
                          (result4.equals("INVALID") ? " ✓" : " ✗"));
        
        System.out.println("\n========================================");
    }
}
