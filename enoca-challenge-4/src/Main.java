import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        // Orjinal liste oluşturma
        List<Integer> orginal = new ArrayList<>();

        //Random sınıfı
        Random random = new Random();

        //orjinal listeyi random sayılarla doldurma
        for (int i = 0; i < 100; i++) {
            orginal.add(random.nextInt(100));
        }

        //Kopya liste olusturma
        List<Integer> copy = new ArrayList<>(orginal);

        //Silinecek sayıyı olusturma
        Integer randomNumber = Integer.valueOf(random.nextInt(100));

        //Silincek sayı ile eşlenşen liste elamanını bulup silme
        if(copy.stream().anyMatch(number -> number == randomNumber)){
            copy.remove(randomNumber);
        }

        System.out.println(getRemoveNumber(orginal,copy));

    }

    //Silinen sayıyı bulan metot
    public static String getRemoveNumber(List<Integer> orginalList,List<Integer> copyList) throws Exception {

        for(Integer num : orginalList){
            if(!copyList.contains(num)){
                return "Silinen sayı: " + num;
            }
        }
       throw new Exception("Sayı bulunamadı.");
    }
}