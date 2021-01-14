package com.fmatheus.app.controller.rule;

import com.fmatheus.app.model.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

/**
 *
 * @author fmatheus
 */
@Component
public class UserRule {

    @Autowired
    private UserServiceImpl userServiceImpl;

    public void teste(Pageable page) {
        userServiceImpl.findAllPaginator(page);
    }

}
