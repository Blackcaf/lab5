package managers;

import models.HumanBeing;
import java.time.LocalDateTime;
import java.util.Vector;

/**
 * Управляет коллекцией объектов {@link HumanBeing}, предоставляя методы для загрузки, сохранения и изменения коллекции.
 */
public class CollectionManager {
    private final Vector<HumanBeing> collection;
    private final LocalDateTime initializationDate;
    private final FileManager fileManager;
    private final IdGenerator idGenerator;

    /**
     * Создаёт новый экземпляр CollectionManager с указанным менеджером файлов.
     * @param fileManager менеджер файлов для загрузки и сохранения
     */
    public CollectionManager(FileManager fileManager) {
        this.collection = new Vector<>();
        this.initializationDate = LocalDateTime.now();
        this.fileManager = fileManager;
        this.idGenerator = new IdGenerator(collection);
        loadCollection();
    }

    private void loadCollection() {
        try {
            Vector<HumanBeing> loaded = fileManager.readCollection();
            collection.addAll(loaded);
            System.out.println("Загружено " + loaded.size() + " элементов из файла:");
            for (HumanBeing human : collection) {
                System.out.println(human);
            }
        } catch (Exception e) {
            System.err.println("Ошибка при загрузке коллекции: " + e.getMessage());
        }
    }

    public void saveCollection() {
        try {
            fileManager.writeCollection(collection);
            System.out.println("Коллекция сохранена в файл. Всего элементов: " + collection.size());
        } catch (Exception e) {
            System.err.println("Ошибка при сохранении: " + e.getMessage());
        }
    }

    /**
     * Генерирует уникальный идентификатор для нового элемента.
     * @return уникальный ID
     */
    public long generateId() {
        return idGenerator.generateId();
    }

    /**
     * Добавляет новый объект в коллекцию с уникальным идентификатором.
     * @param human объект для добавления
     */
    public void add(HumanBeing human) {
        long newId = generateId(); // Генерируем ID только здесь
        human.setId(newId);
        collection.add(human);
        System.out.println("Добавлен элемент с id=" + newId + ": " + human);
    }

    public void removeById(long id) { collection.removeIf(h -> h.getId() == id); }
    public void clear() { collection.clear(); }
    public HumanBeing getById(long id) { return collection.stream().filter(h -> h.getId() == id).findFirst().orElse(null); }
    public Vector<HumanBeing> getCollection() { return collection; }
    public String getInfo() {
        return String.format("Тип: %s, Дата инициализации: %s, Количество элементов: %d",
                collection.getClass().getSimpleName(), initializationDate, collection.size());
    }
}