package vn.hoidanit.laptopshop.domain.dto;

public class RegisterDTO {
    // DTO đơn thuần là 1 biến Object thôi, nó không chứ logic code, phần thực hiện
    // logic code là mapper, không là 1 lớp thực thể trong table mà chỉ là 1 lớp
    // trung gian mà thôi

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String confirmPassword;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstname(String firstname) {
        this.firstName = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String pasword) {
        this.password = pasword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Override
    public String toString() {
        return "RegisterDTO [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password="
                + password + ", confirmPassword=" + confirmPassword + "]";
    }

}
