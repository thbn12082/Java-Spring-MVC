package vn.hoidanit.laptopshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import vn.hoidanit.laptopshop.domain.User;
import java.util.List;

//CRUD create read update delete
@Repository
// đây là tầng lấy dữ liệu từ db(domain/model )
// public interface UserRepository extends CrudRepository<User, Long> {
public interface UserRepository extends JpaRepository<User, Long> {
    // User save(User thebinh);
    // mặc định khi kế thừa CrudRepository thì có các method sẵn của framework r
    // khi dùng thế này sẽ trả về List, ArrayList sẽ bị lỗi
    // Crud thì trả về Iterable => khó thao tác
    // còn Jpa trả về List => dễ thao tác
    List<User> findFirstByEmailAndAddress(String email, String address);
}