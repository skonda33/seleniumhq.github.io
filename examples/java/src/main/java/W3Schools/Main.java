import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        HashMap<String, String> capitalCities = new HashMap<String, String>();
        capitalCities.put("England", "London");
        capitalCities.put("Germany", "Berlin");
        capitalCities.put("Norway", "Oslo");
        capitalCities.put("USA", "Washington DC");

        for (String k :capitalCities.keySet()){
            System.out.println(capitalCities.get(k));

        }

        if(capitalCities.isEmpty()){
            System.out.println("empty");
        }else if(!capitalCities.isEmpty()){
            Set<String> sset = capitalCities.keySet();
            Iterator itr = sset.iterator();
            while (itr.hasNext()){
                System.out.println(capitalCities.get(itr.next()));
            }

        }


    }
}

