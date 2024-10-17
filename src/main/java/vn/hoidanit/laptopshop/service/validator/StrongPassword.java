package vn.hoidanit.laptopshop.service.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

// đây là viết annotation trrang trí cho 1 field

@Constraint(validatedBy = StrongPasswordValidator.class)
// annotation này thể hiện rằng đây là 1 annotation, với mục đích là validate
// dữ liệu, truyền vô 1 class mà sau này sẽ dùng để java biết cách hoạt động của
// annotation này

@Target({ ElementType.METHOD, ElementType.FIELD })
// annotation này thì là phạm vi của nó là trên 1 trường thông tin hay trên cả 1
// class
@Retention(RetentionPolicy.RUNTIME)
// RUNTIME là thời gian khi ta đang chạy dự án thì sẽ chạy các annotation này
@Documented
// ràng buộc sẽ được bao gồm trong tài liệu Javadoc.
public @interface StrongPassword {
    String message() default "Must be 8 characters long and combination of uppercase letters, lowercase letters, numbers, special characters.";
    // đây là message mặc định, có thể custome được trên model

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
