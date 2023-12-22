package ru.gb.family_tree.view;

import ru.gb.family_tree.present.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View{
    private Scanner scanner;
    private Presenter presenter;
    boolean work;
    private Menu menu;

    public ConsoleUI(){
        presenter = new Presenter(this);
        scanner = new Scanner(System.in);
        menu = new Menu(this);
        work = true;
    }

    @Override
    public void start() {
        while (work){
            printMenu();
            choise();
        }
    }

    @Override
    public void print(String str) {
        System.out.println(str);
    }

    public void printMenu() {
        System.out.println(menu.menu());
    }
    private void choise() {
        String choiceStr = scanner.nextLine();
        int choice = Integer.parseInt(choiceStr);
        menu.execute(choice);
    }

    public void addHuman(){
        System.out.println("Введите имя человека");
        String name = scanner.nextLine();
        System.out.println("Введите пол человека: M, Ж");
        String gender = scanner.nextLine();
        System.out.println("Укажите дату рождения человека формата: ****-**-** гггг-мм-дд");
        String birthDateStr = scanner.nextLine();
        LocalDate birthDate = LocalDate.parse(birthDateStr);
        System.out.println("Укажите id Матери");
        String idMotherStr = scanner.nextLine();
        int idMother = Integer.parseInt(idMotherStr);
        System.out.println("Укажите id Отца");
        String idFatherStr = scanner.nextLine();
        int idFather = Integer.parseInt(idFatherStr);
        presenter.addHuman(name, gender, birthDate, idMother, idFather);

    }

    public void printListTree(){
        presenter.printListTree();
    }

    public void save(){
        presenter.save();
    }

    public void load(){
        presenter.load();
    }
    public void sortByName(){
        presenter.sortByName();
    }

    public void sortByAge(){
        presenter.sortByAge();
    }


    public void finish(){
        System.out.println("Досвидание");
        work = false;
    }
}
