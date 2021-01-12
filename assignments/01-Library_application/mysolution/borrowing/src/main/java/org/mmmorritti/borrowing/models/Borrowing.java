package org.mmmorritti.borrowing.models;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class Borrowing {

    @Id
    private Long borrowingId;
    private String startBorrow;
    private String endBorrow;
    private Long bookId;
    private Long customerId;
    private String notification;

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

    public Long getBorrowingId() {
        return borrowingId;
    }

    public void setBorrowingId(Long borrowingId) {
        this.borrowingId = borrowingId;
    }

    public String getStartBorrow() {
        return startBorrow;
    }

    public void setStartBorrow(String startBorrow) {
        this.startBorrow = startBorrow;
    }

    public String getEndBorrow() {
        return endBorrow;
    }

    public void setEndBorrow(String endBorrow) {
        this.endBorrow = endBorrow;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString(){
        String data = this.startBorrow + " "
                + this.endBorrow + " "
                + this.bookId + " "
                + this.customerId;
        return data;
    }
}
