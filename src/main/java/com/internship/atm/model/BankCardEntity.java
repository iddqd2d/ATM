package com.internship.atm.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@NoArgsConstructor
@Setter
@Getter
@Accessors(chain = true)
@Entity
@Table(name = "bank_card")
public class BankCardEntity extends MappedEntity {

    @Column (name = "card_number")
    private Long cardNumber;

    @Column (name = "valid_thru")
    private Long validThru;

    @Column
    private Integer cvv;

    @Column
    private Integer pin;

    @Column
    private Long balance;
}
