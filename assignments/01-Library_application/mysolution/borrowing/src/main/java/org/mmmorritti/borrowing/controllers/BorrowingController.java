package org.mmmorritti.borrowing.controllers;

import org.mmmorritti.borrowing.models.Borrowing;
import org.mmmorritti.borrowing.repos.BorrowingRepository;
import org.mmmorritti.borrowing.services.NotificationClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping(value = "/v2/borrowings")
public class BorrowingController {

    @Autowired
    NotificationClient notificationClient;

    @Value("${kafka.sms.message}")
    private String message;

    @Autowired
    private BorrowingRepository borrowingRepository;

    //set borrowing
    @RequestMapping(method = RequestMethod.PUT)
    public void setBorrowing(@RequestBody Borrowing borrowing){
        borrowingRepository.save(borrowing);
        System.out.println(borrowing);
    }

    //get borrowing
    @RequestMapping(value = "/{borrowingId}", method = RequestMethod.GET)
    public Borrowing getBorrowing(@PathVariable long borrowingId){
        Optional<Borrowing> borrowingOpt = borrowingRepository.findById(borrowingId);
        if(borrowingOpt.isPresent()){
            return borrowingOpt.get();
        }else{
            return null;
        }
    }

    //get all
    @RequestMapping(method = RequestMethod.GET)
    public Collection<Borrowing> getAllBorrowing() {
        return borrowingRepository.findAll();
    }

    //edit book
    @RequestMapping(value = "/{borrowingId}", method = RequestMethod.POST)
    public Borrowing editBorrowing(@RequestBody Borrowing borrowing, @PathVariable long borrowingId){

        return borrowingRepository.save(borrowing);
    }

    //delete by ID
    @RequestMapping(value = "/{borrowingId}", method = RequestMethod.DELETE)
    public void deleteBorrowing(@PathVariable long borrowingId){
        borrowingRepository.deleteById(borrowingId);
    }

    //delete all book
    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteAllBorrowing() {
        borrowingRepository.deleteAll();
    }

}
