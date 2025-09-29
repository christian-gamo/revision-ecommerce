package com.cpg.pprojects.ecommerce.usecase.common.dto;

public class APIResponse {
    private String message;
    private boolean status;

    // No-argument constructor
    public APIResponse() {
    }

    // All-argument constructor
    public APIResponse(String message, boolean status) {
        this.message = message;
        this.status = status;
    }

    // Getter for message
    public String getMessage() {
        return message;
    }

    // Setter for message
    public void setMessage(String message) {
        this.message = message;
    }

    // Getter for status
    public boolean isStatus() {
        return status;
    }

    // Setter for status
    public void setStatus(boolean status) {
        this.status = status;
    }

    // Optional: toString, equals, hashCode can be added if needed
}
