package com.tatvasoft.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.tatvasoft.model.Usermaster;

@Component
public class UserValidator implements Validator {

	@Override
	public boolean supports(Class clazz) {
		return Usermaster.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "username.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.required");
		ValidationUtils.rejectIfEmpty(errors, "firstname", "firstname.required");
		ValidationUtils.rejectIfEmpty(errors, "lastname", "lastname.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "roleid", "roleid.required");
		
		
	}
}
