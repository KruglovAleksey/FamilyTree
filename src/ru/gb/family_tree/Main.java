package ru.gb.family_tree;

import ru.gb.family_tree.model.family_tree.FamilyTree;
import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.model.writer.FileHandler;
import ru.gb.family_tree.view.ConsoleUI;
import ru.gb.family_tree.view.View;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args){

        //FamilyTree tree = loadTree();
        FamilyTree<Human> tree = Tree();
        System.out.println(tree);
        //saveTree(tree);

        //tree.sortByName();
        //System.out.println(tree);

        tree.sortByAge();
        System.out.println(tree);
        View view = new ConsoleUI();
        view.start();
   }

    static FamilyTree<Human> Tree(){
        FamilyTree<Human> tree = new FamilyTree<>();
        Human ira = new Human("Ира", "Ж", LocalDate.of(1964, 6,7));
        Human vadim = new Human("Вадим", "М", LocalDate.of(1966, 8,29));
        Human aleksey = new Human("Алексей", "М", LocalDate.of(1990, 4, 19));
        ira.addChild(aleksey);
        vadim.addChild(aleksey);
        tree.add(ira);
        tree.add(aleksey);
        tree.add(vadim);
        return tree;
    }
    private static void saveTree(FamilyTree<Human> tree) throws IOException {
        String filePath = "src/ru/gb/family_tree/writer/tree.txt";
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(tree, filePath);
    }
    private static FamilyTree<Human> loadTree()throws IOException, ClassNotFoundException{
        String filePath = "src/ru/gb/family_tree/writer/tree.txt";
        FileHandler fileHandler = new FileHandler();
        return (FamilyTree<Human>) fileHandler.read(filePath);
    }
}
