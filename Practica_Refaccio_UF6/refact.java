import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.naming.InvalidNameException;
import java.io.FileReader;
import java.io.IOException;

class JsonParser {
    //parseJsonFile es un metode per llegir un arxiu
    public void parseJsonFile(String arxiuPath) {

        //Creem una instancia per analitzar l'arxiu json
        JSONParser lector = new JSONParser();

        //try per comprobar si llegeix l'arxiu
        try (FileReader llegir = new FileReader(arxiuPath)) {

            //Llegeix l'arxiu JSON i ho emmagatzema
            Object objecte = lector.parse(llegir);

            //Converteix l'objecte en un JsonArray
            JSONArray convertir = (JSONArray) objecte;

            //Itera per cada objecte del Array
            for (Object persona : convertir) {
                //Cada element el passa a objecte
                JSONObject jsonObject = (JSONObject) persona;

                //Obtinc el valor de la clau name perque sera utilitzat varies vegades
                Object vName = jsonObject.get("name");
                //Obtinc el valor de la clau age perque sera utilitzat varies vegades
                Object vAge = jsonObject.get("age");

                //Control d'errors per assegurar el seu valor com a String o Long.
                if (!(vName instanceof String)) {
                    throw new InvalidNameException("Invalid valor per name" ); }
                if (!(vAge instanceof Long)) {
                    throw new InvalidNameException("Invalid valor per age" ); }

                //Imprimeix el nom l'edat
                System.out.println("Nom: " + vName + ", Edat: " + vAge);
            }
            //Agafa l'error amb el catch i el guarda per que s'imprimeixi
        } catch (IOException | ParseException e) {
            System.out.println("Error llegint l'arxiu Json" + e.getMessage());
        } catch (InvalidNameException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
