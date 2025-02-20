package models;

import java.time.ZonedDateTime;

/**
 * Класс, представляющий человека.
 */
public class HumanBeing implements Comparable<HumanBeing> {
    private int id; // Уникальный идентификатор (автоматически генерируется)
    private String name; // Не может быть null или пустым
    private Coordinates coordinates; // Не может быть null
    private ZonedDateTime creationDate; // Автоматически генерируется
    private boolean realHero;
    private boolean hasToothpick;
    private float impactSpeed;
    private WeaponType weaponType; // Может быть null
    private Mood mood; // Не может быть null
    private Car car; // Может быть null

    public HumanBeing(int id, String name, Coordinates coordinates, ZonedDateTime creationDate,
                      boolean realHero, boolean hasToothpick, float impactSpeed,
                      WeaponType weaponType, Mood mood, Car car) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID должен быть больше 0.");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым.");
        }
        if (coordinates == null) {
            throw new IllegalArgumentException("Координаты не могут быть null.");
        }
        if (creationDate == null) {
            throw new IllegalArgumentException("Дата создания не может быть null.");
        }
        if (mood == null) {
            throw new IllegalArgumentException("Настроение не может быть null.");
        }

        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.realHero = realHero;
        this.hasToothpick = hasToothpick;
        this.impactSpeed = impactSpeed;
        this.weaponType = weaponType;
        this.mood = mood;
        this.car = car;
    }

    // === Геттеры ===
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public boolean isRealHero() {
        return realHero;
    }

    public boolean isHasToothpick() {
        return hasToothpick;
    }

    public float getImpactSpeed() {
        return impactSpeed;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public Mood getMood() {
        return mood;
    }

    public Car getCar() {
        return car;
    }

    @Override
    public int compareTo(HumanBeing other) {
        return Integer.compare(this.id, other.id);
    }

    @Override
    public String toString() {
        return "HumanBeing{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", realHero=" + realHero +
                ", hasToothpick=" + hasToothpick +
                ", impactSpeed=" + impactSpeed +
                ", weaponType=" + weaponType +
                ", mood=" + mood +
                ", car=" + car +
                '}';
    }
}

