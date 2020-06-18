package com.kbc.EmailService.controler;

import com.kbc.EmailService.BO.MessageDetail;
import com.kbc.EmailService.exception.ValidationException;
import com.kbc.EmailService.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
public class EmailProvider {

    @Autowired
    EmailService emailSender;

    @RequestMapping(value = "/",method = RequestMethod.POST, consumes = {"application/json"})
    public String sendEmail(@RequestBody MessageDetail messageDetail){

        if(validateMessageDetail(messageDetail)) {
            emailSender.sendEmail(messageDetail);
        }
        return "success";
    }

    public static boolean validateMessageDetail(MessageDetail messageDetail){
        if(messageDetail.getSubject()==null || messageDetail.getSubject().isEmpty()){

            throw new ValidationException("ER1","subject can not be null or empty");
        }
        if( messageDetail.getText() == null || messageDetail.getText().isEmpty()){
            throw new ValidationException("ER2","text can not be null or empty");
        }
        return true;
    }

}
