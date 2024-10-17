package vn.hoidanit.laptopshop.service.validator;

import org.springframework.stereotype.Service;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import vn.hoidanit.laptopshop.domain.dto.RegisterDTO;
import vn.hoidanit.laptopshop.service.UserService;

@Service
public class RegisterValidator implements ConstraintValidator<RegisterChecked, RegisterDTO> {
    // đây là class cũ và tên biến cta cần check

    private final UserService userService;

    public RegisterValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean isValid(RegisterDTO user, ConstraintValidatorContext context) {
        boolean valid = true;

        // Check if password fields match
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            // so sánh giữa pass và confirm pass

            context.buildConstraintViolationWithTemplate("Passwords must match") // đây là message mặc định, mỗi 1 lần
                                                                                 // báo lỗi hãy trả về message này
                    .addPropertyNode("confirmPassword")// trường thông tin báo lỗi sẽ là trường này
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
            valid = false;
        }
        if (this.userService.checkValidEmail(user.getEmail())) {

            context.buildConstraintViolationWithTemplate("Email has exist") // đây là message mặc định, mỗi 1 lần
                                                                            // báo lỗi hãy trả về message này
                    .addPropertyNode("email")// trường thông tin báo lỗi sẽ là trường này
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
            valid = false;
        }

        // Additional validations can be added here

        return valid;
    }
}
