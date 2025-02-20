package commands;

import managers.CollectionManager;
import utility.Console;
import models.Car;
import utility.ExecutionResponse;

/**
 * Команда для удаления первого элемента из коллекции.
 */
public class RemoveFirst extends Command {
    private final Console console;
    private final CollectionManager collectionManager;

    public RemoveFirst(Console console, CollectionManager collectionManager) {
        this.console = console;
        this.collectionManager = collectionManager;
    }

    @Override
    public void ExecutionResponse apply(String[] arguments) {
        if (!arguments[1].isEmpty()) return new ExecutionResponse(false, "Неправильное количество аргументов!\nИспользование: '" + getName() + "'");
        var d = collectionManager.getCollection().getFirst();
        collectionManager.remove(d.getId());
        collectionManager.update();
        return new ExecutionResponse("Первый элемент успешно удалён.");
    }
}

//нужно праваить