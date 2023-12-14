package ru.gb.family_tree;

import ru.gb.family_tree.family_tree.FamilyTree;
import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.writer.FileHandler;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        //FamilyTree tree = loadTree();
        FamilyTree<Human> tree = Tree();
        System.out.println(tree);
        //saveTree(tree);

        //tree.sortByName();
        //System.out.println(tree);

        tree.sortByAge();
        System.out.println(tree);
    }

    static FamilyTree<Human> Tree(){
        FamilyTree<Human> tree = new FamilyTree<>();
        Human ira = new Human("Ира", Gender.Female, LocalDate.of(1964, 6,7));
        Human vadim = new Human("Вадим", Gender.Male, LocalDate.of(1966, 8,29));
        Human aleksey = new Human("Алексей", Gender.Male, LocalDate.of(1990, 4, 19));
        ira.addChild(aleksey);
        vadim.addChild(aleksey);
        tree.addHuman(ira);
        tree.addHuman(aleksey);
        tree.addHuman(vadim);
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
