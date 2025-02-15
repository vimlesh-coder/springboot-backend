package net.javaguides.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

//this is custom exception

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
	@Serial
	private static final long serialVersionUID=1L;
private String resourceName;
private String fieldName;
private String fieldValue;
public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue) {
	super(String.format("%s not found with %s : '%s'",resourceName, fieldName,fieldValue));
	this.resourceName = resourceName;
	this.fieldName = fieldName;
	this.fieldValue = String.valueOf(fieldValue);
}

public String getResourceName() {
	return resourceName;
}

public String getFieldName() {
	return fieldName;
}
public String getFieldValue() {
	return fieldValue;
}

}
