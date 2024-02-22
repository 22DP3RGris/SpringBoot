package rvt;

import java.time.LocalDate;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class User {

    @NotEmpty(message = "Vārds nevar būt tukšs")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Atļauti tikai burti")
    private String fullname;

    @NotEmpty(message = "E-pasts nedrīkst būt tukšs")
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "E-pastam jābūt derīgam!")
    private String email;

    @NotEmpty(message = "Parole nedrīkst būt tukša")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Atļauti tikai burti un cipari")
    private String password;

    private String gender;

    private String note;

    private boolean married;

    @NotNull(message = "Lūdzu, ievadiet datumu")
    private LocalDate date;

    private String group;


    public String toString() {
        return "User{" +
                "fullname='" + fullname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", note='" + note + '\'' +
                ", married=" + married +
                ", Date=" + date +
                ", group='" + group + '\'' +
                '}';
    }
}
