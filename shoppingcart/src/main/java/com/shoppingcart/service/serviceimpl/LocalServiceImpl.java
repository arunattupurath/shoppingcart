package com.shoppingcart.service.serviceimpl;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import com.shoppingcart.core.CommonFunctions;
import com.shoppingcart.locale.ILocaleService;

@Service
public class LocalServiceImpl implements ILocaleService {

	@Autowired
    private MessageSource messageSource;
  
    @Override
    public String getMessage(String messageConstant) {
        return messageSource.getMessage(messageConstant, null, new Locale(CommonFunctions.getUserLang()));
    }
   
    @Override
    public String getMessage(String id, String localeString) {
        LocaleContextHolder.setLocale(new Locale(localeString));
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(id, null, locale);
    }
	
}
