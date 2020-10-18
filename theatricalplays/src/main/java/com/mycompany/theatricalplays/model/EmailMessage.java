/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.theatricalplays.model;

import java.io.File;
import java.util.List;

/**
 *
 * @author mac
 */
public class EmailMessage {
    private String from;
    private String to;
    private String title;
    private String body;
    private List<File> attachments;

    public EmailMessage() {
    }

    public EmailMessage(String from, String to, String title, String body, List<File> attachments) {
        this.from = from;
        this.to = to;
        this.title = title;
        this.body = body;
        this.attachments = attachments;
    }

    public List<File> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<File> attachments) {
        this.attachments = attachments;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "EmailMessage{" + "from=" + from + ", to=" + to + ", title=" + title + ", body=" + body + ", attachments=" + attachments + '}';
    }
    
    
    
}
