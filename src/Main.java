import managers.CollectionManager;
import managers.CommandManager;
import managers.DumpManager;
import managers.FileManager;
import utility.Console;
import utility.Runner;
import utility.StandardConsole;

/**
 * Главный класс приложения
 */
public class Main {
    public static void main(String[] args) {
        try {
            Console console = new StandardConsole();
            FileManager fileManager = new DumpManager();
            CollectionManager collectionManager = new CollectionManager(fileManager);
            CommandManager commandManager = new CommandManager(collectionManager, console);
            Runner runner = new Runner(commandManager, console);
            runner.interactiveMode();
        } catch (Exception e) {
            System.err.println("Ошибка инициализации: " + e.getMessage());
            System.exit(1);
        }
    }
}