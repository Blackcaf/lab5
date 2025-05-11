package commands;

import managers.CollectionManager;
import utility.Console;
import utility.ExecutionResponse;

/**
 * Команда для сохранения коллекции в файл
 */
public class Save extends Command {
    private final Console console;
    private final CollectionManager collectionManager;

    public Save(Console console, CollectionManager collectionManager) {
        super("save", "сохранить коллекцию в файл");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    @Override
    public ExecutionResponse apply(String[] arguments) {
        if (arguments.length > 0) return new ExecutionResponse(false, "Команда 'save' не принимает аргументы");
        try {
            collectionManager.saveCollection();
            return new ExecutionResponse(true, "Коллекция успешно сохранена в файл");
        } catch (Exception e) {
            return new ExecutionResponse(false, "Ошибка при сохранении коллекции: " + e.getMessage());
        }
    }
}