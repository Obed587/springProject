package com.example.demo2.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class VerificationToken {

    private static final int EXPIRATIONTIME=10;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String token;

    private Date expirationTime;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false, foreignKey = @ForeignKey (name = "FK_USER_VERIFY_TOKEN"))
    private User user;

    public VerificationToken(User user, String token){
        super();
        this.user=user;
        this.token=token;
        this.expirationTime=CalculateExpirationDate(EXPIRATIONTIME);
    }

    public VerificationToken(String token){
        super();
        this.token=token;
        this.expirationTime=CalculateExpirationDate(EXPIRATIONTIME);
    }


    private Date CalculateExpirationDate(int expirationtime) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(new Date().getTime());
        calendar.add(Calendar.MINUTE, expirationtime);
        return new Date(calendar.getTime().getTime());
    }
}
