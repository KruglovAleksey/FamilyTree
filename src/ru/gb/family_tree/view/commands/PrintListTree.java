package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class PrintListTree extends Command{

    public PrintListTree(ConsoleUI consoleUI) {
        super(consoleUI, "Получить список людей");
    }

    @Override
    public void execute() {
        getConsoleUI().printListTree();
    }
}
