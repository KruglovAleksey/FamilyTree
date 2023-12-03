package ru.gb.family_tree;

import ru.gb.family_tree.family_tree.FamilyTree;
import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.writer.FileHandler;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        FamilyTree tree = loadTree();
        //FamilyTree tree = Tree();
        System.out.println(tree);
        saveTree(tree);

    }

    static FamilyTree Tree(){
        FamilyTree tree = new FamilyTree();
        Human ira = new Human("Ира", Gender.Female, LocalDate.of(1964, 6,7));
        Human vadim = new Human("Вадим", Gender.Male, LocalDate.of(1966, 8,29));
        Human aleksey = new Human("Алексей", Gender.Male, LocalDate.of(1990, 4, 19));
        ira.addChildren(aleksey);
        vadim.addChildren(aleksey);
        tree.addHuman(aleksey);
        tree.addHuman(vadim);
        tree.addHuman(ira);
        return tree;
    }
    private static void saveTree(FamilyTree tree) throws IOException {
        String filePath = "src/ru/gb/family_tree/writer/tree.txt";
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(tree, filePath);
    }
    private static FamilyTree loadTree()throws IOException, ClassNotFoundException{
        String filePath = "src/ru/gb/family_tree/writer/tree.txt";
        FileHandler fileHandler = new FileHandler();
        return (FamilyTree) fileHandler.read(filePath);
    }
}
