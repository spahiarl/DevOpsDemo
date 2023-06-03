package ch.zhaw.iwi.devops.stringcalculator;

public class StringCalculator  {

    private static final String DEFAULTTRENNZEICHEN = ",";

    public int add(String zahlen) {
        if (zahlen.isEmpty()) {
            return 0;
        }

        String delimiter = DEFAULTTRENNZEICHEN;
        if (zahlen.startsWith("//")) {
            delimiter = Character.toString(zahlen.charAt(2));
            zahlen = zahlen.substring(4);
        }

        String[] zahlenArray = zahlen.split("[\n" + delimiter + "]");
        int sum = 0;
        StringBuilder negativeZahlen = new StringBuilder();

        for (String nummer : zahlenArray) {
            int num = Integer.parseInt(nummer);
            if (num < 0) {
                negativeZahlen.append(num).append(" ");
            } else if (num <= 1000) {
                sum += num;
            }
        }

        if (negativeZahlen.length() > 0) {
            throw new IllegalArgumentException("Negatives not allowed: " + negativeZahlen.toString());
        }

        return sum;
    }
}