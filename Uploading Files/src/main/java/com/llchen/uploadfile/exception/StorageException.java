package com.llchen.uploadfile.exception;

/**
 * The reason for wrap exception is to make it suit a specific circumstance, thus programmer can know more about the
 * possible root cause when debugging
 */
public class StorageException extends RuntimeException{

    public StorageException(String msg) {
        super(msg);
    }

    public StorageException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
