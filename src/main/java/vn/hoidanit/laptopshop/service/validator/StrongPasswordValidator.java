package vn.hoidanit.laptopshop.service.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
// sau khi định nghĩa annotation xong thì vô đây

public class StrongPasswordValidator implements ConstraintValidator<StrongPassword, String> {
    // class cũ và kiểu dữ liệu ktra
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // value là giá trị muốn ktra
        // check if string contains at least one digit, one lowercase letter, one
        // uppercase letter, one special character and 8 characters long
        return value.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!*()]).{8,}$");
        // check xem value có thỏa mãn regular expression
    }
}