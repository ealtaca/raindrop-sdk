/**
 * Created by ealtaca on 15.05.2018.
 */

public class BaseApiResponse {

    private boolean success = true;
    private String message;

    public BaseApiResponse() {
    }

    public BaseApiResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "BaseApiResponse{" +
                "success=" + success +
                ", message='" + message +
                '}';
    }

}
