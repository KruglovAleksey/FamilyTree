package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class Load extends Command{

    public Load(ConsoleUI consoleUI) {
        super(consoleUI, "Загрузить данные");
    }

    @Override
    public void execute() {
        getConsoleUI().load();
    }
}
