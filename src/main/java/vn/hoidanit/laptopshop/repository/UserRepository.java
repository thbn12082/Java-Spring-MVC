package vn.hoidanit.laptopshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import vn.hoidanit.laptopshop.domain.User;
import java.util.List;

//CRUD create read update delete
@Repository
// đây là tầng lấy dữ liệu từ db(domain/model )
public interface UserRepository extends CrudRepository<User, Long> {
    // public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findFirstByEmailAndAddress(String email, String address);

    User findById(long id);// tại sao lại là long mà không phải là Optinal?? bởi vì đang xử lý th kh null
                           // id

    void deleteById(long id);

    List<User> findAll();

    User findByFullname(String name);

    User findByEmail(String email);

    boolean existsByEmail(String email);
}