/*
Условие:
        Склонируйте заготовку проекта по ссылке.
        Всего 3 класса и одна зависимость.
        Класс App содержит метод main, который запускает Спринг при создании контекста. В контекст мы передаем
        класс AppConfig, который помечен аннотацией @Configuration - так Спринг понимает, что это настроечный
        класс.
        В классе AppConfig содержится метод, помеченный аннотацией как бин, этот метод будет выполнен при
        запуске и его результат станет объектом, управляемым Спрингом.
        Класс HelloWorld является обычным Java-классом, мы его используем без каких-либо сложностей.
        В методе main мы можем получить бин HelloWorld по имени и использовать в любом месте программы.
        Спринг позволяет использовать различные типы бинов, одни будут жить от старта до завершения программы,
        другие будут создаваться при каждом запросе или открытии новой сессии, третьи при каждом вызове будут
        создаваться новые. За это отвечает аннотация @Scope.

        Задание:
        1. Прочитайте про виды бинов.
        2. Создайте POJO-класс Cat.
        3. В классе AppConfig, по аналогии, создайте бин с именем “cat”.
        4. Настройте этот бин так, чтобы он создавался новым при каждом запросе.
        5. В классе App, по аналогии, вызовите еще раз бин HelloWorld, затем 2 раза вызовите бин cat.
          Сравните 2 пары бинов по ссылке и выведите результат в консоль. Для пары HelloWorld должно вернуться
          true, для cat - false. Так вы можете увидеть результат того, как работает наш контейнер.
        6. Раскомментируйте тестовый класс и проверьте своё решение.
*/



import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        HelloWorld bean =
                (HelloWorld) applicationContext.getBean("helloworld");
        System.out.println(bean.getMessage());

        System.out.println("-----------------");

        ApplicationContext applicationContext1 =
                new AnnotationConfigApplicationContext(AppConfig.class);
        HelloWorld bean1 =
                (HelloWorld) applicationContext.getBean("helloworld");
        System.out.println(bean1.getMessage());
        System.out.println("-----------------");
        ApplicationContext applicationContext2 =
                new AnnotationConfigApplicationContext(AppConfig.class);
        Cat bean2 =
                (Cat) applicationContext.getBean("cat");
        System.out.println(bean2.getMessage());

        System.out.println("-----------------");

        ApplicationContext applicationContext3 =
                new AnnotationConfigApplicationContext(AppConfig.class);
        Cat bean3 =
                (Cat) applicationContext.getBean("cat");
        System.out.println(bean3.getMessage());

        System.out.println("-----------------");

        System.out.println("Сравнение хэллоу: " + (bean==bean1));
        System.out.println("Сравнение котов: " + (bean2==bean3));
    }
}