package ru.learnup;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.*;


public class TextUtils {

 //   private static final Logger LOG =LoggerFactory.getLogger(TextUtils.class);

    public static void main(String[] args) throws FileNotFoundException {
         //commands:
         // print all -p
         // most popular -m
         // count of char -c

     //1.Поскольку класс TextUtils и директория resources лежат в одном и том же пакете ru.learnup
     //из класса TextUtils можно достать файлы, содержащиеся в resources
//       URL resource = TextUtils.class.getResource("input.txt");
//        assert resource != null;
//        String pathToFile = resource.getFile(); //извлекаем содержимое файла

       //2.Тк первым путем файл "input.txt"  не получается извлечь из архива, создаваемого jar target
        // то файл "input.txt" кладем в папку target вручную после ее образования при операции maven package
       File file = new File("input.txt");       //создаем на этой основе новый файл File
        Scanner in = new Scanner(file);
        Map<String, Integer> wordsMap = new HashMap<>();
        List<String> content = new ArrayList<>();    //для отображения всех слов создадим List
        while (in.hasNext()) {
            String word = in.next();
            content.add(word);                      //добавляем каждое слово в список List
            wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1); //по словам считываем файл и помещаем в Map
                     //в результате в wordsMap будут лежать слова в качестве ключа и число их повторений в качестве Value

        }

//       LOG.debug("Application started...");

        String option = args[0];      //первый аргумент - опция (-p, -m, -с)
        switch (option) {
            case "-p" -> content.forEach(word -> System.out.print(word + " ")); // отображаем все слова
            case "-m" -> wordsMap.entrySet()
                    .stream()
                    .max(Map.Entry.comparingByValue())
                    .ifPresent(entry -> System.out.print(entry.getKey()));  //вытаскиваем значение ключа (слова) из Optional<Entry<K, V>>
            case  "-c" -> {
                String symbol = args[1];   //ввод второго аргумента (символ, количество которого надо найти)
                System.out.print(symbol + " - " + wordsMap.get(symbol) + " times in text");  //возвращаем значение из wordsMap по ключу
                                                                                           // = сколько раз встречается символ (или слово)
            }
        }
        //      LOG.debug("Application finished...");
    }
}
