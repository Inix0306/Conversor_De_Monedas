
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Monedas base\n");
        System.out.print("USD\tBND\tDJF\tGTQ\tKES\tMKD\tPAB\tSHP\n");
        System.out.print("AED\tBOB\tDKK\tGYD\tKGS\tMMK\tPEN\tSLE\n");
        System.out.print("AFN\tBRL\tDOP\tHKD\tKHR\tMNT\tPGK\tSLL\n");
        System.out.print("ALL\tBSD\tDZD\tHNL\tKID\tMOP\tPHP\tSOS\n");
        System.out.print("AMD\tBTN\tEGP\tHRK\tKMF\tMRU\tPKR\tSRD\n");
        System.out.print("ANG\tBWP\tERN\tHTG\tKRW\tMUR\tPLN\tSSP\n");
        System.out.print("AOA\tBYN\tETB\tHUF\tKWD\tMVR\tPYG\tSTN\n");
        System.out.print("ARS\tBZD\tEUR\tIDR\tKYD\tMWK\tQAR\tSYP\n");
        System.out.print("AUD\tCAD\tFJD\tILS\tKZT\tMXN\tRON\tSZL\n");
        System.out.print("AWG\tCDF\tFKP\tIMP\tLAK\tMYR\tRSD\tTHB\n");
        System.out.print("AZN\tCHF\tFOK\tINR\tLBP\tMZN\tRUB\tTJS\n");
        System.out.print("BAM\tCLP\tGBP\tIQD\tLKR\tNAD\tRWF\tTMT\n");
        System.out.print("BBD\tCNY\tGEL\tIRR\tLRD\tNGN\tSAR\tTND\n");
        System.out.print("BDT\tCOP\tGGP\tISK\tLSL\tNIO\tSBD\tTOP\n");
        System.out.print("BGN\tCRC\tGHS\tJEP\tLYD\tNOK\tSCR\tTRY\n");
        System.out.print("BHD\tCUP\tGIP\tJMD\tMAD\tNPR\tSDG\tTTD\n");
        System.out.print("BIF\tCVE\tGMD\tJOD\tMDL\tNZD\tSEK\tTVD\n");
        System.out.print("BMD\tCZK\tGNF\tJPY\tMGA\tOMR\tSGD\tTWD\n\n");
        System.out.print("Ingrese la moneda base\n");
        System.out.print("DE:");
        String monedaUno = scanner.nextLine().toUpperCase().trim();

        System.out.print("Ingrese la moneda objetivo\n");
        System.out.print("A:");
        String monedaDos = scanner.nextLine().toUpperCase().trim();

        scanner.close();

        try {
            String apiUrl = "https://v6.exchangerate-api.com/v6/67af2377ae42c78a06ce9b20/latest/" + monedaUno;

            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode jsonNode = objectMapper.readTree(connection.getInputStream());

                String result = jsonNode.get("result").asText();
                if ("success".equals(result)) {
                    String baseCode = jsonNode.get("base_code").asText();
                    System.out.println("Tasa de cambio de " + baseCode + " a " + monedaDos + ":");

                    JsonNode rates = jsonNode.get("conversion_rates");
                    double rate = rates.get(monedaDos).asDouble();
                    System.out.printf("1 %s = %.2f %s%n", baseCode, rate, monedaDos);
                } else {
                    String errorMessage = jsonNode.get("error").get("type").asText();
                    System.out.println("Error en la solicitud: " + errorMessage);
                }
            } else {
                System.out.println("Error al realizar la solicitud HTTP. Código de respuesta: " + responseCode);
            }
        } catch (IOException e) {
            System.out.println("Error al conectar con la API: " + e.getMessage());
        }
    }
}