package com.example.MyDB.exception;
import java.util.*;

public class InternalServerErrorException extends RuntimeException{
	public InternalServerErrorException(String msg) {
		super(String.format("%s could not be Saved",msg));
	}
}
