package org.mmmorritti.borrowing.controllers;

import lombok.extern.slf4j.Slf4j;
import org.mmmorritti.borrowing.models.Borrowing;
import org.mmmorritti.borrowing.repos.BorrowingRepository;
import org.mmmorritti.borrowing.services.NotificationClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;


@RestController
@Slf4j
@RequestMapping(value = "/v2/borrowings")
public class BorrowingController {

    @Autowired
    NotificationClient notificationClient;

    @Value("${kafka.sms.message}")
    private String message;

    @Autowired
    private final BorrowingRepository borrowingRepository;

    public BorrowingController(BorrowingRepository borrowingRepository) {
        this.borrowingRepository = borrowingRepository;
    }

    //set borrowing
    @RequestMapping(method = RequestMethod.PUT)
    public Borrowing setBorrowing(@RequestBody Borrowing borrowing){
        notificationClient.sendSMS(borrowing);
        System.out.println(borrowing);
        log.info("set");
        return borrowingRepository.save(borrowing);

    }

    //get borrowing
    @RequestMapping(value = "/{borrowingId}", method = RequestMethod.GET)
    public Borrowing getBorrowing(@PathVariable long borrowingId){
        Optional<Borrowing> borrowingOpt = borrowingRepository.findById(borrowingId);
        if(borrowingOpt.isPresent()){
            log.info("Get");
            return borrowingOpt.get();
        }else{
            log.warn("Not found");
            return null;
        }
    }

    //get all
    @RequestMapping(method = RequestMethod.GET)
    public Collection<Borrowing> getAllBorrowing() {
        log.info("Get all");
        List<Borrowing> result = new ArrayList<Borrowing>();
        Iterable<Borrowing> iterable = borrowingRepository.findAll();
        iterable.forEach(result::add);
        return result;
    }

    //edit borrow
    @RequestMapping(value = "/{borrowingId}", method = RequestMethod.POST)
    public Borrowing editBorrowing(@RequestBody Borrowing borrowing, @PathVariable long borrowingId){
        log.info("Edit ");
        return borrowingRepository.save(borrowing);
    }

    //delete by ID
    @RequestMapping(value = "/{borrowingId}", method = RequestMethod.DELETE)
    public void deleteBorrowing(@PathVariable long borrowingId){
        log.info("Delete ");
        borrowingRepository.deleteById(borrowingId);
    }

    //delete all book
    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteAllBorrowing() {
        log.info("Delete all");
        borrowingRepository.deleteAll();
    }

}
