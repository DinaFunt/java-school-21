package hw.lab4;

public class HttpService {

    public static void handleHttpCode(int httpCode) {
        HttpCode status = HttpCode.findByHttpCode(httpCode);
        status.getHandler().handle();
    }

    public static void main(String[] args) {
        HttpService service = new HttpService();
        service.handleHttpCode(133);
    }
}
