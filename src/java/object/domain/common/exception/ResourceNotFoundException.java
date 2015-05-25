/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object.domain.common.exception;

import javax.ejb.ApplicationException;

/**
 *
 * @author 9918
 */
@ApplicationException
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
