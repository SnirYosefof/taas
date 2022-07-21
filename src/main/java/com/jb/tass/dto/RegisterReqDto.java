package com.jb.tass.dto;

import lombok.AllArgsConstructor;
        import lombok.Builder;
        import lombok.Data;
        import lombok.NoArgsConstructor;
        import org.hibernate.validator.constraints.Length;

        import javax.validation.constraints.Email;

//Created by sniryosefof on 30 יוני
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterReqDto {
    @Email
    private String email;
    @Length(min = 3, max = 8)
    private String password;
}
