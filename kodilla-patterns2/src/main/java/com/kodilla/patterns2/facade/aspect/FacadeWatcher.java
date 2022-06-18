package com.kodilla.patterns2.facade.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class FacadeWatcher {
    private static final Logger LOGGER = LoggerFactory.getLogger(FacadeWatcher.class);

@Before("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..)) " +
        " && target(object)")
    public void logEvent(Object object) throws NoSuchMethodException {
        LOGGER.info("Entered desired method in class... " +  object.getClass().getName());
}
}

