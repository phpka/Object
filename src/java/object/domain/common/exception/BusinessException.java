/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object.domain.common.exception;

import javax.ejb.ApplicationException;

/**
 *
 */
@ApplicationException
public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
}
