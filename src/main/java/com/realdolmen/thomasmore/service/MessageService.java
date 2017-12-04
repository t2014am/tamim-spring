package com.realdolmen.thomasmore.service;

import com.realdolmen.thomasmore.domain.Message;
import com.realdolmen.thomasmore.domain.SupportTicket;
import com.realdolmen.thomasmore.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public void createMessage(SupportTicket supportTicket, String supportText, boolean bySupportUser, Date dateAdded) {
        Message message = new Message();
        message.setSupportTicket(supportTicket);
        message.setSupportText(supportText);
        message.setBySupportUser(bySupportUser);
        message.setDateAdded(dateAdded);


        messageRepository.save(message);
    }

    public List<Message> findAllMessages() {
        return messageRepository.findAll();
    }
    public List<Message> findAllMessagesBySupportTicket(SupportTicket supportTicket) {
        return messageRepository.findAllBySupportTicket(supportTicket);
    }

}
