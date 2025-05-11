package commands;

import managers.CollectionManager;
import models.HumanBeing;
import utility.Console;
import utility.ExecutionResponse;
import utility.HumanBeingAsker;

/**
 * Команда для добавления нового элемента в коллекцию.
 */
public class Add extends Command {
    private final Console console;
    private final CollectionManager collectionManager;
    private final HumanBeingAsker asker;

    public Add(Console console, CollectionManager collectionManager, HumanBeingAsker asker) {
        super("add", "добавить новый элемент в коллекцию");
        this.console = console;
        this.collectionManager = collectionManager;
        this.asker = asker;
    }

    @Override
    public ExecutionResponse apply(String[] arguments) {
        if (arguments.length > 0) return new ExecutionResponse(false, "Команда 'add' не принимает аргументы");
        try {
            HumanBeing human = asker.askHumanBeing();
            collectionManager.add(human); // ID генерируется внутри add
            return new ExecutionResponse(true, "Элемент успешно добавлен в коллекцию");
        } catch (Exception e) {
            return new ExecutionResponse(false, "Ошибка при добавлении: " + e.getMessage());
        }
    }
}

//return new ExecutionResponse(arguments.length == 0, arguments.length > 0 ? "Команда 'add' не принимает аргументы" : "OK");