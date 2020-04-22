package com.company;


public class Helper {
    //создаём экзмепляр класса дерево
    private static Tree tree;
    //указываем уровень, на котором мы находимся
    private static int level = 1;
    //метод cutter для преобразования строки в удобный формат для изменения
    public static void cutter(String parsingString){
        parsingString = parsingString.replaceAll("\\s", "")
                .replaceAll("=", "")
                .replaceAll("\\{", "%")
                .replaceAll("\\}", "% ");
        //заменяем ковычки на =(w+)%
        parsingString = indexsChar(parsingString);
        parsingString.replaceAll("\n", "%");
        //перебираем все линии в строке
        for (String retval : parsingString.split("%")) {
            analyseString(retval);
        }
    }
//вспомагательная функция для замены значений в ковычках
    static String indexsChar (String str){
        int coof = 0;
        for(int i=0; i< str.length(); i++){
            if(str.charAt(i) == '\"') {
                coof++;
                if(coof % 2 == 0) {
                    str = str.substring(0,i)+'%'+str.substring(i+1);
                } else {
                    str = str.substring(0,i)+'='+str.substring(i+1);
                }
            };
        }
        return str;
    }
//анализируем полученную линия
    static void analyseString(String str) {
        int lvl = level;
        String name, value;
//если в строке есть =, то разбиваем на ключ + значение
        if (str.indexOf('=') != -1) {
            String[] exp = str.split("=");
            name = exp[0];
            value = exp[1];
//иначе поднимаемся или опускаемся на уровень выше
        } else {
            name = str;
            value = null;
            if(str.trim().length() == 0) level--;
            else level++;
        }
//если имя не пустое, добавляем новую "ветку" в дерево
        if(name.length() > 0) tree.insert(name, value, lvl);
    }
}
