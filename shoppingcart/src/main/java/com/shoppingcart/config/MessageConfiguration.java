package com.shoppingcart.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.shoppingcart.constants.ApplicationConstants;

@Configuration
public class MessageConfiguration {
    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(new Locale("en"));
        return slr;
    }

    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename(ApplicationConstants.CONFIG_MESSAGE_CLASSPATH);
        messageSource.setCacheSeconds(ApplicationConstants.MESSAGE_CACHE_TIME);
        messageSource.setDefaultEncoding(ApplicationConstants.ENCODING_UTF8);
        return messageSource;
    }
}
