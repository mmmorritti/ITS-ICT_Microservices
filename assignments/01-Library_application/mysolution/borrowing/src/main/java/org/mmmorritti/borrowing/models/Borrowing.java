package org.mmmorritti.borrowing.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document
public class Borrowing {

    @Id
    private Long borrowingId;
    private String startBorrow;
    private String endBorrow;
    private Long bookId;
    private Long customerId;
    private String notification;


}
