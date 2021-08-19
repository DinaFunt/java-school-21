package hw.lab4;

import hw.lab4.handlers.Handle;
import hw.lab4.handlers.InformationalHandler;
import hw.lab4.handlers.RedirectionHandle;
import hw.lab4.handlers.SuccessHandler;
import lombok.Getter;

@Getter
public enum HttpCode {

    INFORMATIONAL(100, 199, new InformationalHandler()),
    SUCCESS(200, 299, new SuccessHandler()),
    REDIRECTION(300, 399, new RedirectionHandle());


    private final int from;
    private final int to;
    private final Handle handler;

    HttpCode(int from, int to, Handle handler) {
        this.from = from;
        this.to = to;
        this.handler = handler;
    }

    public static HttpCode findByHttpCode(int code) {
        HttpCode[] statuses = values();
        for (HttpCode status : statuses) {
            if (status.from <= code && status.to >= code) {
                return status;
            }
        }
        throw new IllegalStateException(code + " not supported");
    }

    @Override
    public String toString() {

        return super.toString() + " " + from + " - " + to;
    }
}
