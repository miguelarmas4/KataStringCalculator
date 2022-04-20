public class StringCalculator {

    public static int Add(String numbers) {
        int resultado = 0;

        //System.out.println(String.format("Original string: %s", numbers));

        //Checking for different delimiters
        numbers = check_DifferentDelimiter(numbers);

        //Checking for new lines
        int posic = numbers.indexOf("\n");
        if (posic > -1) {
            //System.out.println(String.format("Transforming: Position: %d Length: %d", posic, numbers.length()));

            if (posic == numbers.length()-1) {    // <-- Checking "\n" at end of string
                resultado = -1;
            } else {
                numbers = numbers.replaceAll("\n", ",").replaceAll(",,", ",");
            }

            //System.out.println(String.format("String result: %s", numbers));

        }

        // If numbers is not valid then resultado equals -1
        if (resultado == 0) {

            if (numbers.length() == 0)
                resultado = 0;
            else if (!numbers.contains(",")) {
                resultado = Integer.parseInt(numbers);
            } else {
                String[] valores = numbers.split(",");

                //checking for negative numbers;
                String negatives = "";
                for (String valor : valores) {
                    int num = Integer.parseInt(valor);
                    if (num < 0) {
                        negatives += " " + String.valueOf(num);
                    }
                }

                try {
                    if (!negatives.equals("")) {
                        throw new ArithmeticException("Negatives not allowed, they are: " + negatives);
                    }
                    for (String valor : valores) {
                        int num = Integer.parseInt(valor);

                        num = (num > 1000) ? 0 : num; // <-- Ignored if it is bigger than 1000
                        resultado += num;
                    }

                } catch (ArithmeticException e) {
                    resultado = -1;
                    System.out.println(e.getMessage());
                }
            }

        }
        return resultado;
    }

    //Checking for different delimiters
    private static String check_DifferentDelimiter(String numbers) {
        if (numbers.startsWith("//")) {  // <-- format: //delimiter\n[numbers...]
            String delimiter ="";

            if (numbers.startsWith("//[")) {
                delimiter = numbers.substring(3, numbers.indexOf("]"));

                //Replacing all separators with comma
                numbers = numbers.replaceFirst("//\\[" + delimiter + "]" + "\n", "" ).replaceAll(delimiter,",");

            } else {
                delimiter = numbers.substring(2,3);
                //Replacing all separators with comma
                numbers = numbers.replaceFirst("//" + delimiter + "\n", "" ).replaceAll(delimiter,",");
            }
            //System.out.println(String.format("String delimiter: %s result: %s", delimiter, numbers));
        }
        return numbers;
    }

}
