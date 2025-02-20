package commands;

import managers.CollectionManager;
import utility.*;

/**
 * Команда для добавления нового элемента в заданную позицию коллекции.
 */
public class InsertAt extends Command {
    private final Console console;
    private final CollectionManager collectionManager;

    public InsertAt(Console console, CollectionManager collectionManager) {
        this.console = console;
        this.collectionManager = collectionManager;
    }

    @Override
    public ExecutionResponse apply(String[] arguments) {
        if (arguments[1].isEmpty()) return new ExecutionResponse(false, "Неправильное количество аргументов!\nИспользование: '" + getName() + "'");
        int ind = -1;
        try { ind = Integer.parseInt(arguments[1].trim()); } catch (NumberFormatException e) {  return new ExecutionResponse(false, "ID не распознан"); }

        try {
            var d = collectionManager.getCollection().get(ind);
            collectionManager.remove(d.getId());
            collectionManager.update();
            return new ExecutionResponse("Дракон успешно удалён!");
        } catch (IndexOutOfBoundsException e) { return new ExecutionResponse(false, "index за границами допустимых значений"); }
    }
}

