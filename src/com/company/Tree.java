package com.company;

import java.util.ArrayList;
import java.util.List;

public class Tree {
    //список всех узлов
    public static List<Node> nodes = new ArrayList<Node>();
    //вспомагательные переменные
    static int previousLevel = 0;
    static int childCoof = 1;
    //метод для заполнения узлов значениеями
    public static void insert(String name, String value, int level){
        Node node = null;
        if(level - previousLevel+1 > 2) {
            childCoof = 0;
        } else if (level < previousLevel) {
            previousLevel--;
        } else if (level > previousLevel) {
            previousLevel++;
        }
        if (value == null) {
            value = "";
        }
        int parentId = generateParentId(previousLevel);
        int id = generateId(parentId);
        if(name.trim().length() != 0) {
            node = new Node(id, parentId, name, value);
            nodes.add(node);
        }
    }
    //получения родительского id (честно - работает плохо)
    public static int generateParentId(int previousLevel) {
        int c = (int) ((previousLevel) * Math.pow(10, previousLevel-1));
        return c;
    }
    //создание id
    public static int generateId(int parentId) {
        int c = parentId * 10 + childCoof;
        childCoof++;
        return c;
    }
    //перебор узлов и запись в удобной форме
    public static List<String> addToFile() {
        List<String> out = new ArrayList<String>();
        for(Node r : nodes) {
            String adding = "ID - " + r.id + " ParentID - " + r.parentId + " Name - " + r.name;
            if(r.value.length() > 0) adding += " Value - " + r.value;
            else adding += " It is collection!";
            out.add(adding + "\n");
        }
        return out;
    }
}
