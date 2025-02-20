package commands;

import managers.CollectionManager;
import models.HumanBeing;
import models.WeaponType;
import utility.Console;

import java.util.List;

/**
 * Команда для вывода элементов, значение поля weaponType которых меньше заданного.
 */
public class FilterLessThanWeaponType implements Command {
    private final CollectionManager collectionManager;
    private final Console console;

    public FilterLessThanWeaponType(CollectionManager collectionManager, Console console) {
        this.collectionManager = collectionManager;
        this.console = console;
    }

    @Override
    public void execute(String argument) {
        if (argument == null || argument.trim().isEmpty()) {
            console.println("Ошибка: необходимо указать одно из значений weaponType.");
            console.println("Доступные значения: AXE, SHOTGUN, RIFLE.");
            return;
        }

        try {
            WeaponType weaponType = WeaponType.valueOf(argument.trim().toUpperCase());
            List<HumanBeing> filteredList = collectionManager.filterLessThanWeaponType(weaponType);

            if (filteredList.isEmpty()) {
                console.println("Нет элементов с weaponType меньше, чем " + weaponType);
            } else {
                console.println("Элементы с weaponType меньше, чем " + weaponType + ":");
                for (HumanBeing human : filteredList) {
                    console.println(human);
                }
            }
        } catch (IllegalArgumentException e) {
            console.println("Ошибка: некорректное значение weaponType.");
            console.println("Доступные значения: AXE, SHOTGUN, RIFLE.");
        }
    }
}

