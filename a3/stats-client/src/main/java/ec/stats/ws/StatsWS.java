package ec.stats.ws;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
@WebService
@SOAPBinding(style = Style.RPC)
public interface StatsWS {
    @WebMethod
    int getCount();
    @WebMethod
    double getMin();
    @WebMethod
    double getMax();
    @WebMethod
    double getMean();
    @WebMethod
    double getSTD();
}
