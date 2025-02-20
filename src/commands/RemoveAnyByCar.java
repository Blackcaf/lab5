package commands;

import managers.CollectionManager;
import models.Car;
import utility.Console;
import utility.ExecutionResponse;

/**
 * Команда для удаления одного элемента из коллекции по значению поля car.
 */
public class RemoveAnyByCar extends Command {
    private final Console console;
    private final CollectionManager collectionManager;

    public RemoveAnyByCar(Console console, CollectionManager collectionManager) {
        this.console = console;
        this.collectionManager = collectionManager;
    }

    @Override
    public ExecutionResponse apply(String[] arguments) {
        try {
            if (!arguments[1].isEmpty()) return new ExecutionResponse(false, "Неправильное количество аргументов!\nИспользование: '" + getName() + "'");

            var ch = Ask.askDragonCharacter(console, true);
            Dragon d = null;
            for (var e : collectionManager.getCollection()) {
                if ((ch == null && e.getCharacter() == null) || (ch != null && e.getCharacter().equals(ch))) {
                    d = e;
                    break;
                }
            }
            if (d != null) {
                collectionManager.remove(d.getId());
                collectionManager.update();
                return new ExecutionResponse("Дракон успешно удалён!");
            } else {
                return new ExecutionResponse("Не найден Character");
            }
        } catch (Ask.AskBreak e) {
            return new ExecutionResponse(false, "Отмена...");
        }
    }
}

//надо допилить для машины