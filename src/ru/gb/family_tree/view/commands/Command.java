package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public abstract class Command {
    private ConsoleUI consoleUI;
    private String description;

    public Command(ConsoleUI consoleUI, String description) {
        this.consoleUI = consoleUI;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public abstract void execute();
    ConsoleUI getConsoleUI() {
        return consoleUI;
    }
}
