package panomete.project.spb4featsnip.service;

import org.springframework.stereotype.Service;
import panomete.project.spb4featsnip.constant.ErrorMessage;
import panomete.project.spb4featsnip.exception.OperationFailedException;
import panomete.project.spb4featsnip.exception.PermissionDeniedException;
import panomete.project.spb4featsnip.exception.ServerErrorException;

@Service
public class ErrorServiceImpl implements ErrorService {

    @Override
    public String actionDenied() {
        throw new PermissionDeniedException(ErrorMessage.PERMISSION_DENIED);
    }

    @Override
    public String operationFailed() {
        throw new OperationFailedException(ErrorMessage.OPERATION_FAILED);
    }

    @Override
    public String serverError() {
        throw new ServerErrorException(ErrorMessage.SERVER_ERROR);
    }
}
