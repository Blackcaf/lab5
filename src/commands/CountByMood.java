package commands;

import managers.CollectionManager;
import models.Mood;
import utility.Console;

/**
 * Команда для вывода количества элементов, значение поля mood которых равно заданному.
 */
public class CountByMood implements Command {
    private final CollectionManager collectionManager;
    private final Console console;

    public CountByMood(CollectionManager collectionManager, Console console) {
        this.collectionManager = collectionManager;
        this.console = console;
    }

    @Override
    public void execute(String argument) {
        if (argument == null || argument.trim().isEmpty()) {
            console.println("Ошибка: необходимо указать одно из значений mood.");
            console.println("Доступные значения: SADNESS, CALM, RAGE, FRENZY.");
            return;
        }

        try {
            Mood mood = Mood.valueOf(argument.trim().toUpperCase());
            long count = collectionManager.countByMood(mood);
            console.println("Количество элементов с настроением " + mood + ": " + count);
        } catch (IllegalArgumentException e) {
            console.println("Ошибка: некорректное значение mood.");
            console.println("Доступные значения: SADNESS, CALM, RAGE, FRENZY.");
        }
    }
}

