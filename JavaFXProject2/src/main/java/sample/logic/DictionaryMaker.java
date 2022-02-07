package sample.logic;

import sample.model.WordCountModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;

//Создаём словарь
public class DictionaryMaker {

    private char[] separators = new char[]{' ', ',', '.',
            '"', ';', ':', '[', ']', '?','&','#',(char) 171,
            (char)187, '(', ')','\n', '\r', '\t','{','}','/'
            ,'=','!','-','@', '—'};

    //Получаем ХТМЛ отдаём список сущностей слово-кол-во
    public ArrayList<WordCountModel> CountUniqueWords(String document) {

        HTMLCleaner cleaner = new HTMLCleaner();
        document = cleaner.CleanDocument(document);
        String[] strings = SplitDocument(document);

        HashMap<String, Integer> dictionary = new HashMap<>();
        for (String string : strings) {
            if (dictionary.containsKey(string)) {
                dictionary.put(string, dictionary.get(string) + 1);
            } else {
                dictionary.put(string, 1);
            }
        }

        ArrayList<WordCountModel> result = new ArrayList();
        dictionary.forEach((k, v) -> result.add(new WordCountModel(k, v)));

        return result;
    }

    //используем список сепараторов для разделения
    private String[] SplitDocument(String document) {
        document = document.replaceAll("[\\t\\n\\r]", "");
        document = document.replaceAll("[ ]+?", " ");

        StringBuilder pattern = new StringBuilder("[");
        for (char separator : separators) {
            String currentChar = String.valueOf(separator);
            pattern.append(Pattern.quote(currentChar)+",");
        }
        pattern.deleteCharAt(pattern.length()-1);
        pattern.append("]+");

        String regexSplit = pattern.toString();
        String[] strings = document.split(regexSplit);
        return strings;
    }
}
