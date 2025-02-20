package commands;
import utility.ExecutionResponse;

/**
 * Интерфейс для всех выполняемых команд.
 */
public interface Executable {
    /**
     * Выполнить что-либо.
     *
     * @param arguments Аргумент для выполнения
     */
    ExecutionResponse apply(String[] arguments);
}
