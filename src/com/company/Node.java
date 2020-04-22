package com.company;

import java.util.ArrayList;
import java.util.List;

//узел со значениями id, id родителя, имя и значение
public class Node {
    public int id;
    public int parentId;
    public String name;
    public String value;
//конструктор
    public Node(int id, int parentId, String name, String value) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
        this.value = value;
    }
}
