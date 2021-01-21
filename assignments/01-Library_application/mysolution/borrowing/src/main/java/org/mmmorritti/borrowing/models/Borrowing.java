package org.mmmorritti.borrowing.models;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "borrowings")
public class Borrowing {

    @Id
    private Long borrowingId;
    private String startBorrow;
    private String endBorrow;
    private Long bookId;
    private Long customerId;
    private String notify;



}
