import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

    private static SessionFactory sessionAnnotationFactory;

    public static SessionFactory getSessionAnnotationFactory() {
        if (sessionAnnotationFactory == null) {
            sessionAnnotationFactory = buildAnnotationSessionFactory();
        }
        return sessionAnnotationFactory;
    }

    private static SessionFactory buildAnnotationSessionFactory() {
        SessionFactory sessionFactory = null;
        try {

            Configuration configuration = new Configuration();
            configuration.configure();
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                    configuration.getProperties()).build();

            sessionFactory = new Configuration().configure().buildSessionFactory(serviceRegistry);

        } catch (HibernateException e) {
        }
        return sessionFactory;
    }
}
