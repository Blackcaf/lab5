package commands;

import managers.CollectionManager;
import models.HumanBeing;
import utility.Console;
import utility.ExecutionResponse;
import utility.HumanBeingAsker;

/**
 * Команда для удаления всех элементов, меньших заданного.
 */
public class RemoveLower extends Command {
    private final Console console;
    private final CollectionManager collectionManager;
    private final HumanBeingAsker asker;

    public RemoveLower(Console console, CollectionManager collectionManager, HumanBeingAsker asker) {
        super("remove_lower", "удалить из коллекции все элементы, меньшие, чем заданный");
        this.console = console;
        this.collectionManager = collectionManager;
        this.asker = asker;
    }

    @Override
    public ExecutionResponse apply(String[] arguments) {
        if (arguments.length > 0) return new ExecutionResponse(false, "Команда 'remove_lower' не принимает аргументы в строке");
        try {
            HumanBeing human = asker.askHumanBeing();
            int initialSize = collectionManager.getCollection().size();
            collectionManager.getCollection().removeIf(h -> h.compareTo(human) < 0);
            int removedCount = initialSize - collectionManager.getCollection().size();
            return new ExecutionResponse(true, "Удалено элементов: " + removedCount);
        } catch (Exception e) {
            return new ExecutionResponse(false, "Ошибка: " + e.getMessage());
        }
    }
}