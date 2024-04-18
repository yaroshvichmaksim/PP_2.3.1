package spring_mvc.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import spring_mvc.model.User;

import java.util.List;

@Repository
public class UserDaoIml implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addUser(User user) {

        entityManager.persist(user);
    }

    @Override
    public void editUser(User user) {

        entityManager.merge(user);
    }

    @Override
    public void deleteUser(int id) {

        entityManager.remove(getUser(id));
    }

    @Override
    public User getUser(int id) {
        User user = entityManager.find(User.class, id);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }
}
