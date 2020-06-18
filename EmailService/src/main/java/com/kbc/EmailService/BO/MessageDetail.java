package com.kbc.EmailService.BO;

import jdk.nashorn.internal.objects.annotations.Setter;

import java.util.List;
import java.util.Objects;

public class MessageDetail {
    List<String> emails;
    String subject;
    String text;

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "MessageDetail{" +
                "emails=" + emails +
                ", subject='" + subject + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
