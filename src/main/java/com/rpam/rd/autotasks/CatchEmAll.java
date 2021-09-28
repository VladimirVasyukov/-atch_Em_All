package com.rpam.rd.autotasks;

import java.io.FileNotFoundException;
import java.io.IOException;

public class CatchEmAll {
    static Exception exception;
    final static private String IO_EXCEPTION = "IOException";
    final static private String FILE_NOT_FOUND_EXCEPTION = "FileNotFoundException";
    final static private String ARITHMETIC_EXCEPTION = "ArithmeticException";
    final static private String NUMBER_FORMAT_EXCEPTION = "NumberFormatException";


    public static void riskyMethod() throws Exception {
        if (exception != null) {
            throw exception;
        }
    }

    public static void main(String[] args) throws Exception {
        if (args.length >= 1) {
            switch (args[0]) {
                case IO_EXCEPTION:
                    exception = new IOException();
                    break;
                case FILE_NOT_FOUND_EXCEPTION:
                    exception = new FileNotFoundException();
                    break;
                case ARITHMETIC_EXCEPTION:
                    exception = new ArithmeticException();
                    break;
                case NUMBER_FORMAT_EXCEPTION:
                    exception = new NumberFormatException();
                    break;
                default:
                    System.out.println("Use arguments IOException, FileNotFoundException," +
                        "ArithmeticException, NumberFormatException");
            }
        }
        try {
            riskyMethod();
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("Resource is missing", e);
        } catch (IOException e) {
            throw new IllegalArgumentException("Resource error", e);
        } catch (ArithmeticException | NumberFormatException e) {
            System.err.print(e);
        }
    }
}
