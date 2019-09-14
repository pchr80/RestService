package pl.rest.service;

import org.springframework.stereotype.Repository;
import pl.rest.entity.Example;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Repository
@Transactional
public class ExampleService {
    @PersistenceContext
    EntityManager entityManager;

    public void save(Example entity) {
        entityManager.persist(entity);
    }

    public void update(Example entity) {
        entityManager.merge(entity);
    }

    public Example getById(long id) {
        return entityManager.find(Example.class, id);
    }

    public void deleteById(long id) {
        Example entity = getById(id);
        if (entity != null) {
            entityManager.remove(entity);
        }
    }
    @SuppressWarnings("unchecked")
    public List<Example> getList() {
        List<Example> list = entityManager.createQuery("SELECT b FROM Example b").getResultList();
        Collections.shuffle(list);
        return list;
    }
}
