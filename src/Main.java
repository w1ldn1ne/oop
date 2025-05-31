import java.util.Scanner;

abstract class HogwartsStudent {
    private final String name;
    private final int magicPower;
    private final int transgressionDistance;

    public HogwartsStudent(String name, int magicPower, int transgressionDistance) {
        this.name = name;
        this.magicPower = magicPower;
        this.transgressionDistance = transgressionDistance;
    }

    public String getName() {
        return name;
    }

    public abstract void describe();

    public abstract int calculateScore();

    public void compare(HogwartsStudent other) {
        if (this.getClass() != other.getClass()) {
            System.out.println("Нельзя сравнивать студентов разных факультетов!");
            return;
        }

        int thisScore = this.calculateScore();
        int otherScore = other.calculateScore();

        if (thisScore > otherScore) {
            System.out.println(this.getName() + " лучше, чем " + other.getName());
        } else if (otherScore > thisScore) {
            System.out.println(other.getName() + " лучше, чем " + this.getName());
        } else {
            System.out.println(this.getName() + " и " + other.getName() + " равны по силе");
        }
    }

    protected void printCommonAttributes() {
        System.out.println("\n=== Характеристики студента ===");
        System.out.println("Имя: " + name);
        System.out.println("Сила магии: " + magicPower);
        System.out.println("Расстояние трансгрессии: " + transgressionDistance);
    }
}

class Gryffindor extends HogwartsStudent {
    private final int nobility;
    private final int honor;
    private final int bravery;

    public Gryffindor(String name, int magicPower, int transgressionDistance,
                      int nobility, int honor, int bravery) {
        super(name, magicPower, transgressionDistance);
        this.nobility = nobility;
        this.honor = honor;
        this.bravery = bravery;
    }

    @Override
    public void describe() {
        printCommonAttributes();
        System.out.println("Факультет: Гриффиндор");
        System.out.println("Благородство: " + nobility);
        System.out.println("Честь: " + honor);
        System.out.println("Храбрость: " + bravery);
    }

    @Override
    public int calculateScore() {
        return nobility + honor + bravery;
    }
}

class Hufflepuff extends HogwartsStudent {
    private final int hardWork;
    private final int loyalty;
    private final int honesty;

    public Hufflepuff(String name, int magicPower, int transgressionDistance,
                      int hardWork, int loyalty, int honesty) {
        super(name, magicPower, transgressionDistance);
        this.hardWork = hardWork;
        this.loyalty = loyalty;
        this.honesty = honesty;
    }

    @Override
    public void describe() {
        printCommonAttributes();
        System.out.println("Факультет: Пуффендуй");
        System.out.println("Трудолюбие: " + hardWork);
        System.out.println("Верность: " + loyalty);
        System.out.println("Честность: " + honesty);
    }

    @Override
    public int calculateScore() {
        return hardWork + loyalty + honesty;
    }
}

class Ravenclaw extends HogwartsStudent {
    private final int intelligence;
    private final int wisdom;
    private final int wit;
    private final int creativity;

    public Ravenclaw(String name, int magicPower, int transgressionDistance,
                     int intelligence, int wisdom, int wit, int creativity) {
        super(name, magicPower, transgressionDistance);
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.wit = wit;
        this.creativity = creativity;
    }

    @Override
    public void describe() {
        printCommonAttributes();
        System.out.println("Факультет: Когтевран");
        System.out.println("Ум: " + intelligence);
        System.out.println("Мудрость: " + wisdom);
        System.out.println("Остроумие: " + wit);
        System.out.println("Творчество: " + creativity);
    }

    @Override
    public int calculateScore() {
        return intelligence + wisdom + wit + creativity;
    }
}

class Slytherin extends HogwartsStudent {
    private final int cunning;
    private final int determination;
    private final int ambition;
    private final int resourcefulness;
    private final int lustForPower;

    public Slytherin(String name, int magicPower, int transgressionDistance,
                     int cunning, int determination, int ambition,
                     int resourcefulness, int lustForPower) {
        super(name, magicPower, transgressionDistance);
        this.cunning = cunning;
        this.determination = determination;
        this.ambition = ambition;
        this.resourcefulness = resourcefulness;
        this.lustForPower = lustForPower;
    }

    @Override
    public void describe() {
        printCommonAttributes();
        System.out.println("Факультет: Слизерин");
        System.out.println("Хитрость: " + cunning);
        System.out.println("Решительность: " + determination);
        System.out.println("Амбициозность: " + ambition);
        System.out.println("Находчивость: " + resourcefulness);
        System.out.println("Жажда власти: " + lustForPower);
    }

    @Override
    public int calculateScore() {
        return cunning + determination + ambition + resourcefulness + lustForPower;
    }
}

public class Main {
    public static void main(String[] args) {
        HogwartsStudent[] students = {
                new Gryffindor("Гарри Поттер", 90, 50, 95, 90, 100),
                new Gryffindor("Гермиона Грейнджер", 100, 40, 90, 95, 85),
                new Gryffindor("Рон Уизли", 80, 45, 85, 80, 90),
                new Hufflepuff("Седрик Диггори", 80, 60, 95, 90, 85),
                new Hufflepuff("Захария Смит", 70, 50, 80, 75, 70),
                new Hufflepuff("Джастин Финч-Флетчли", 75, 55, 85, 80, 75),
                new Ravenclaw("Чжоу Чанг", 85, 45, 90, 85, 80, 75),
                new Ravenclaw("Падма Патил", 80, 50, 85, 80, 85, 80),
                new Ravenclaw("Маркус Белби", 75, 40, 80, 75, 70, 65),
                new Slytherin("Драко Малфой", 85, 55, 90, 85, 95, 80, 90),
                new Slytherin("Грэхэм Монтегю", 75, 45, 80, 75, 85, 70, 80),
                new Slytherin("Грегори Гойл", 70, 40, 75, 70, 80, 65, 75)
        };

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Хогвартс: Система управления ===");
            System.out.println("1. Показать список студентов");
            System.out.println("2. Просмотреть характеристики студента");
            System.out.println("3. Сравнить двух студентов");
            System.out.println("4. Выйти");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    printStudentList(students);
                    break;
                case 2:
                    viewStudentDetails(students, scanner);
                    break;
                case 3:
                    compareStudents(students, scanner);
                    break;
                case 4:
                    System.out.println("Программа завершена.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }

    private static void printStudentList(HogwartsStudent[] students) {
        System.out.println("\n=== Список студентов ===");
        for (int i = 0; i < students.length; i++) {
            System.out.println((i + 1) + ". " + students[i].getName());
        }
    }

    private static void viewStudentDetails(HogwartsStudent[] students, Scanner scanner) {
        printStudentList(students);
        System.out.print("Выберите студента: ");
        int index = scanner.nextInt() - 1;
        if (index >= 0 && index < students.length) {
            students[index].describe();
        } else {
            System.out.println("Неверный номер студента!");
        }
    }

    private static void compareStudents(HogwartsStudent[] students, Scanner scanner) {
        printStudentList(students);
        System.out.print("Выберите первого студента: ");
        int first = scanner.nextInt() - 1;
        System.out.print("Выберите второго студента: ");
        int second = scanner.nextInt() - 1;

        if (first >= 0 && first < students.length && second >= 0 && second < students.length) {
            students[first].compare(students[second]);
        } else {
            System.out.println("Неверные номера студентов!");
        }
    }
}