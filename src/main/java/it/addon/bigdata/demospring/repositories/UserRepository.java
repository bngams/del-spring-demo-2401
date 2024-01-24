package it.addon.bigdata.demospring.repositories;

import it.addon.bigdata.demospring.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    public User findByUsername(String username);

    public List<User> findByConnectionNumberGreaterThan(Integer value);

    // @Query(nativeQuery = true, value = "SELECT * FROM T_Users WHERE login LIKE '%?%' ")
    // public User findByUsernameLike(String username);


}
