package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class Save extends Command{

    public Save(ConsoleUI consoleUI) {
        super(consoleUI, "Сохранить данные");
    }

    @Override
    public void execute() {
        getConsoleUI().save();
    }
}
