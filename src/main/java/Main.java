import enums.Type;
import hw1.models.Car;
import hw1.models.Word;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();
        Metadata metadata = new MetadataSources(serviceRegistry)
                .addAnnotatedClass(Word.class)
                .addAnnotatedClass(Car.class)
                .getMetadataBuilder()
                .build();

        try (
                SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
                Session session = sessionFactory.openSession();
        ) {
            Transaction transaction = session.beginTransaction();
            Word word1 = new Word();
            Word word2 = new Word();
            Word word3 = new Word();

            word1.setValue("apple");
            word2.setValue("pen");
            word3.setValue("notebook");

            session.save(word1);
            session.save(word2);
            session.save(word3);

            List<Word> words = session.createQuery("from Word", Word.class).list();
            System.out.println(words);

            Car car = new Car();
            car.setModel("BWM");
            car.setBody(Type.HATCHBACK);
            car.setPower(200);
            car.setPrice(20000);
            car.setYear(2022);
            session.save(car);

            List<Car> cars = session.createQuery("from Car", Car.class).list();
            System.out.println(cars);
            transaction.commit();
        }


    }
}