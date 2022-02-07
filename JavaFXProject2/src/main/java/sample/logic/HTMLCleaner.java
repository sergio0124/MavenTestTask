package sample.logic;

import java.util.ArrayList;

public class HTMLCleaner {

    /**
     *
     * @param document with HTML text
     * @return text of the doc with no tags
     */
    public String CleanDocument(String document) {
        String result = document;
        result = DeleteTags(result);
        return result;
    }

    /**
     * Получает документ, удаляет оттуда <head></head>
     * и все теги.
     *
     * @param document with HTML code
     * @return Text with no tags
     */
    private String DeleteTags(String document) {

        document = document.replaceAll("[\\n\\t\\r]", "");
        //Удалим скрипты
        document = document.trim().replaceFirst("<head>.*</head>", " ");
        document = document.trim().replaceAll("<style[^>]*>[^<]*</style>", " ");
        document = document.trim().replaceAll("<script[^>]*>[^<]*</script>", " ");
        char[] text = document.toCharArray();
        ArrayList<Character> res = new ArrayList<Character>();

        //Добавялем в список значения между < и >
        boolean isDel=false;
        for (char c : text) {
            if (c == '<') isDel = true;
            if (!isDel) {
                res.add(Character.toLowerCase(c));
            }
            if (c == '>') {
                isDel = false;
                res.add(' ');
            }
        }

        //Собираем и подчищаем результат
        StringBuilder result = new StringBuilder();
        res.forEach(character->result.append(character));
        String r = result.toString();
        r = r.trim().replaceAll("\\n", " ");
        r = r.trim().replaceAll("\\s{2,}", " ");

        return r;
    }

}
