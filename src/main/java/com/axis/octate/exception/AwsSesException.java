package com.axis.octate.exception;

/**
 * This exception used in AwsService
 */
public class AwsSesException extends RuntimeException {

    /**
     * Aws Client Exception with error message and throwable
     *
     * @param errorMessage error message
     * @param throwable    error
     */
    public AwsSesException(String errorMessage, Throwable throwable) {
        super(errorMessage, throwable);
    }

}
