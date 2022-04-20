import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestStringCalculator {

    @Test
    void testValorVacio () {
        int esperado = 0;
        int valor = StringCalculator.Add("");
        Assertions.assertEquals(esperado, valor);
    }

    @Test
    void testValorUnDigito () {
        int esperado = 5;
        int valor = StringCalculator.Add("5");
        Assertions.assertEquals(esperado, valor);
    }

    @Test
    void testValorDosDigito () {
        int esperado = 4;
        int valor = StringCalculator.Add("3,1");
        Assertions.assertEquals(esperado, valor);
    }

    // Allow the Add method to handle an unknown amount of numbers
    @Test
    void testValorVariosDigitos () {
        int esperado = 7;
        int valor = StringCalculator.Add("3,1,2,1");
        Assertions.assertEquals(esperado, valor);
    }

    // Allow the Add method to handle new lines between numbers
    @Test
    void testValorVariasLinea () {
        int esperado = 6;
        int valor = StringCalculator.Add("1,\n2,3");
        Assertions.assertEquals(esperado, valor);
        //System.out.println(String.format("Answer: %d", valor));
    }

    // Allow the Add method to handle new lines between numbers
    @Test
    void testValorVariasLineaFail () {
        int esperado = -1;
        int valor = StringCalculator.Add("1,\n");
        Assertions.assertEquals(esperado, valor);
        //System.out.println(String.format("Answer: %d", valor));
    }

    // Different delimiters
    @Test
    void testValorDiferenteDelimitador () {
        int esperado = 3;
        int valor = StringCalculator.Add("//;\n1;2");
        Assertions.assertEquals(esperado, valor);
        //System.out.println(String.format("Answer: %d", valor));
    }

    // Negative numbers exception
    @Test
    void testValorNegativos () {
        int esperado = -1;
        int valor = StringCalculator.Add("1,2,-4,3,-1,5");
        Assertions.assertEquals(esperado, valor);
        //System.out.println(String.format("Answer: %d", valor));
    }

    // Different delimiters
    @Test
    void testValorDiferenteDelimitadorAnyLength () {
        int esperado = 6;
        int valor = StringCalculator.Add("//[xxx]\n1xxx2xxx3");
        Assertions.assertEquals(esperado, valor);
        //System.out.println(String.format("Answer: %d", valor));
    }

}
