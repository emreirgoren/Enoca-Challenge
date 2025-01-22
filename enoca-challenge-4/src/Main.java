import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");


        List<Integer> orginal = new ArrayList<>();

        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            orginal.add(random.nextInt(100));
        }

        List<Integer> copy = new ArrayList<>(orginal);

        Integer randomNumber = Integer.valueOf(random.nextInt(100));

        if(copy.stream().anyMatch(number -> number == randomNumber)){
            copy.remove(randomNumber);
        }

        System.out.println(getRemoveNumber(orginal,copy));

    }

    public static String getRemoveNumber(List<Integer> orginalList,List<Integer> copyList) throws Exception {

        for(Integer num : orginalList){
            if(!copyList.contains(num)){
                return "Silinen sayı: " + num;
            }
        }
       throw new Exception("Sayı bulunamadı.");
    }
}