package stocks;

import java.io.Serializable;

public class Request implements Serializable {
    private long userId;
    private String message;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Request{" +
                "userId=" + userId +
                ", message='" + message + '\'' +
                '}';
    }
}
